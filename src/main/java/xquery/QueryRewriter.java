package xquery;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import xquery.antlr.*;

import java.io.File;
import java.io.FileInputStream;
import java.util.*;

/**
 * Take a non-core Xquery as input and output a rewritten xquery, which use
 * more efficient "Join" to replace normal FLWR expression.
 */
public class QueryRewriter {

    public static String rewrite(String query) {
        // Init ANTLR
        ANTLRInputStream inputStream = new ANTLRInputStream(query);
        XQueryReducedLexer lexer = new XQueryReducedLexer(inputStream);
        CommonTokenStream tokenStream = new CommonTokenStream(lexer);
        XQueryReducedParser parser = new XQueryReducedParser(tokenStream);
        ParseTree tree = parser.xq();

        // Visit
        HelperVisitor visitor = new HelperVisitor();
        return (String) visitor.visit(tree);
    }

    public static void main(String[] args) throws Exception{
        File queryFile = new File("test.xql");
        byte[] queryBuf = new byte[4096];
        (new FileInputStream(queryFile)).read(queryBuf);
        String query = (new String(queryBuf)).trim();
        String res = rewrite(query);

        System.out.println(res);
    }
}

class HelperVisitor extends XQueryReducedBaseVisitor<Object> {

    public LabelTree tree = new LabelTree();

    @Override
    public String visitXq(XQueryReducedParser.XqContext ctx) {

        /* Construct the graph */
        for (int i=0; i<ctx.var().size(); i++) {
            String var = ctx.var(i).getText();
            String path = ctx.path(i).getText();
            String var2 = ctx.path(i).var() == null ? null
                                :ctx.path(i).var().getText();
            tree.addVar(var, var2, path);
        }

        /* Analyze the conditions */
        for (int i=0; i<ctx.cond().var().size(); i++) {
            // Not const condition
            if (ctx.cond().var2(i).var() != null) {
                String var1 = ctx.cond().var(i).getText();
                String var2 = ctx.cond().var2(i).var().getText();
                tree.addJoin(var1, var2);
            } else {
                String var = ctx.cond().var(i).getText();
                String constant = ctx.cond().var2(i).constant().getText();
                tree.addSelfCond(var, constant);
            }
        }
        String joinExpression = tree.mergeAllJoinNode();

        /* Replace variables in return */
        String retExpression = ctx.ret().getText().replace("$", "$tuple/");
        StringBuilder builder = new StringBuilder(retExpression);
        for (int i=builder.indexOf("$tuple/"), j=i+7; i != -1;
             i=builder.indexOf("$tuple/", j+2)) {
            for (j=i+7; j<builder.length(); j++) {
                char ch = builder.charAt(j);
                if (ch == ',' || ch == '}' || ch == '/') {
                    break;
                }
            }
            builder.insert(j, "/*");
        }
        retExpression = builder.toString();

        return "for $tuple in " + joinExpression + "\nreturn " + retExpression;
    }
}

class LabelTree {

    public LabelNode root;

    public HashMap<String, LabelNode> varMap;

    public ArrayList<JoinNode> joinNodes;

    public LabelTree() {
        root = new LabelNode();
        varMap = new HashMap<>();
        joinNodes = new ArrayList<>();
        varMap.put("root", root);
    }

    public void addVar(String var, String var2, String path) {
        if (varMap.containsKey(var)) {
            throw new IllegalStateException();
        }
        LabelNode pnode = (var2 == null) ? root : varMap.get(var2);
        if (pnode == null) {
            throw new IllegalStateException();
        }
        LabelNode node = new LabelNode();
        node.parent = pnode;
        node.relativePath = path;
        node.var = var;
        pnode.children.add(node);
        varMap.put(var, node);

        asignJoinNum(node);
    }

    public void addJoin(String var1, String var2) {
        LabelNode node1 = varMap.get(var1);
        LabelNode node2 = varMap.get(var2);
        if (node1 == null || node2 == null) {
            throw new IllegalStateException();
        }

        JoinNode joinNode1 = joinNodes.get(node1.joinNum);
        JoinNode joinNode2 = joinNodes.get(node2.joinNum);

        JoinNode.addJoin(joinNode1, node1, joinNode2, node2);
    }

    public void addSelfCond(String var, String constant) {
        LabelNode node = varMap.get(var);
        if (node == null) {
            throw new IllegalStateException();
        }

        JoinNode joinNode = joinNodes.get(node.joinNum);
        joinNode.addSelfCond(node, constant);
    }

    public int asignJoinNum(LabelNode node) {
        if (node.joinNum == -1) {
            LinkedList<LabelNode> path = new LinkedList<>();
            LabelNode currNode = node;
            while (currNode != root && currNode.joinNum == -1) {
                path.add(0, currNode);
                currNode = currNode.parent;
            }
            if (currNode != root) {
                for (LabelNode n : path) {
                    JoinNode joinNode = joinNodes.get(currNode.joinNum);
                    joinNode.varSet.add(n);
                    n.joinNum = currNode.joinNum;
                }
            } else {
                int num = joinNodes.size();
                JoinNode joinNode = new JoinNode(num);
                joinNodes.add(joinNode);
                for (LabelNode n : path) {
                    joinNode.varSet.add(n);
                    n.joinNum = num;
                }
            }
        }
        return node.joinNum;
    }

    public String mergeAllJoinNode() {
        while (joinNodes.size() != 1) {
            JoinNode node1 = joinNodes.remove(0);
            JoinNode node2 = joinNodes.remove(0);
            JoinNode newNode = mergeJoinNode(node1, node2);
            joinNodes.add(0, newNode);
        }
        return joinNodes.get(0).getExpression();
    }

    public JoinNode mergeJoinNode(JoinNode n1, JoinNode n2) {
        Map<LabelNode, LabelNode> joinMap = n1.joinTable.remove(n2);
        n2.joinTable.remove(n1);

        JoinNode newNode = new JoinNode(n1.joinNum);
        for (JoinNode n : n1.joinTable.keySet()) {
            if (newNode.joinTable.containsKey(n)) {
                newNode.joinTable.get(n).putAll(n1.joinTable.get(n));
            } else {
                newNode.joinTable.put(n, n1.joinTable.get(n));
            }
        }
        for (JoinNode n : n2.joinTable.keySet()) {
            if (newNode.joinTable.containsKey(n)) {
                newNode.joinTable.get(n).putAll(n2.joinTable.get(n));
            } else {
                newNode.joinTable.put(n, n2.joinTable.get(n));
            }
        }

        StringBuilder res = new StringBuilder();
        res.append("join(\n");
        res.append(n1.getExpression());
        res.append(",\n");
        res.append(n2.getExpression());
        res.append(",\n");

        res.append("[");
        for (LabelNode n : joinMap.keySet()) {
            res.append(n.var.substring(1) + ", ");
        }
        res.deleteCharAt(res.length()-1);
        res.deleteCharAt(res.length()-1);
        res.append("],\n");

        res.append("[");
        for (LabelNode n : joinMap.keySet()) {
            res.append(joinMap.get(n).var.substring(1) + ", ");
        }
        res.deleteCharAt(res.length()-1);
        res.deleteCharAt(res.length()-1);
        res.append("]");

        res.append(")\n");
        newNode.expression = res.toString();

        return newNode;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("LabelTree:\n");
        for (LabelNode n : varMap.values()) {
            res.append("\n" + n.var + " | " + n.relativePath + "\n");
            res.append("children: \n");
            for (LabelNode c : n.children) {
                res.append(c.var + " | " + c.relativePath + "\n");
            }
        }
        res.append("JoinNodes:\n");
        for (JoinNode n : joinNodes) {
            res.append(n);
            res.append(n.getExpression());
        }
        return res.toString();
    }
}

class LabelNode {

    public String var;
    public String relativePath;
    public LabelNode parent;
    public LinkedList<LabelNode> children;
    public int joinNum;

    public LabelNode() {
        children = new LinkedList<>();
        joinNum = -1;
    }
}

class JoinNode {

    public int joinNum;
    public LinkedList<LabelNode> varSet;
    public Map<JoinNode, Map<LabelNode, LabelNode>> joinTable;
    public Map<LabelNode, String> selfCondMap;
    public Map<LabelNode, LabelNode> selfJoinMap;
    public String expression;

    public JoinNode(int joinNum) {
        this.joinNum = joinNum;
        varSet = new LinkedList<>();
        joinTable = new HashMap<>();
        selfCondMap = new HashMap<>();
        selfJoinMap = new HashMap<>();
    }

    public String getExpression() {
        if (expression == null) {
            StringBuilder exp = new StringBuilder();
            exp.append("for\n");
            for (LabelNode n : varSet) {
                exp.append("\t" + n.var + " in " + n.relativePath + ",\n");
            }
            exp.deleteCharAt(exp.length()-2);
            if (selfCondMap.size() != 0 || selfJoinMap.size() != 0) {
                exp.append("where\n");
                for (LabelNode n : selfCondMap.keySet()) {
                    exp.append("\t"+n.var+" eq "+selfCondMap.get(n)+",\n");
                }
                for (LabelNode n : selfJoinMap.keySet()) {
                    exp.append("\t"+n.var+" eq "+selfJoinMap.get(n).var+",\n");
                }
                exp.deleteCharAt(exp.length()-2);
            }
            exp.append("return\n<tuple>{\n");
            for (LabelNode n : varSet) {
                exp.append("\t<"+n.var.substring(1)+">{" +n.var +"}</"
                                +n.var.substring(1)+">,\n");
            }
            exp.deleteCharAt(exp.length()-2);
            exp.append("}</tuple>\n");

            expression = exp.toString();
        }
        return expression;
    }

    public void addSelfCond(LabelNode n, String constant) {
        selfCondMap.put(n, constant);
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("#########\n");
        res.append("JoinNode:" + joinNum + "\n");
        res.append("var list:\n");
        for (LabelNode n : varSet) {
            res.append(n.var + " | " + n.relativePath + "\n");
        }
        res.append("Join cond:\n");
        for (JoinNode n : joinTable.keySet()) {
            res.append(n.joinNum + ": \n");
            for (LabelNode ln : joinTable.get(n).keySet()) {
                res.append(ln.var+" <|> "+joinTable.get(n).get(ln).var+"\n");
            }
        }
        res.append("Self Cond:\n");
        for (LabelNode n : selfCondMap.keySet()) {
            res.append(n.var+" -|> "+ selfCondMap.get(n) +"\n");
        }
        return res.toString();
    }

    public static void addJoin(JoinNode n1, LabelNode v1, JoinNode n2, LabelNode v2) {

        if (n1 == n2) {
            n1.selfJoinMap.put(v1, v2);
        } else {
            if (!n1.joinTable.containsKey(n2)) {
                n1.joinTable.put(n2, new HashMap<LabelNode, LabelNode>());
            }
            n1.joinTable.get(n2).put(v1, v2);

            if (!n2.joinTable.containsKey(n1)) {
                n2.joinTable.put(n1, new HashMap<LabelNode, LabelNode>());
            }
            n2.joinTable.get(n1).put(v2, v1);
        }
    }
}