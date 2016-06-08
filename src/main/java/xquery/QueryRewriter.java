package xquery;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import xquery.antlr.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.*;

/**
 * Take a non-core Xquery as input and output a rewritten xquery, which use
 * more efficient "Join" to replace normal FLWR expression.
 */
public class  QueryRewriter {

    public static String rewrite(String query) {

        // Init ANTLR
        ANTLRInputStream inputStream = new ANTLRInputStream(query);
        XQueryReducedLexer lexer = new XQueryReducedLexer(inputStream);
        CommonTokenStream tokenStream = new CommonTokenStream(lexer);
        XQueryReducedParser parser = new XQueryReducedParser(tokenStream);
        ParseTree tree = parser.xq();

        // Visit
        HelperVisitor visitor = new HelperVisitor();
        String res = (String) visitor.visit(tree);

        /* If the query don't need to be rewrite, retuen it self */
        if (res == null) res = query;

        return res;
    }

    public static void main(String[] args) throws Exception{

        /* read query from file */
        File queryFile = new File("test.xql");
        byte[] queryBuf = new byte[4096*2];
        (new FileInputStream(queryFile)).read(queryBuf);
        String query = (new String(queryBuf)).trim();

        /* Try to rewrite */
        String res = rewrite(query);
        System.out.println(res);

        /* Write result back to the file */
        File resultFile = new File("rewrite.xql");
        FileOutputStream outputStream = new FileOutputStream(resultFile);
        outputStream.write(res.getBytes());
    }
}

class HelperVisitor extends XQueryReducedBaseVisitor<Object> {

    public LabelTree tree = new LabelTree();

    @Override
    public String visitXq(XQueryReducedParser.XqContext ctx) {

        /* No where, no rewrite */
        if (ctx.cond() == null) return null;

        /* Construct the graph */
        for (int i=0; i<ctx.var().size(); i++) {
            String var = ctx.var(i).getText();
            String path = ctx.path(i).getText();
            String var2 = ctx.path(i).var() == null ? null
                                :ctx.path(i).var().getText();
            tree.addVar(var, var2, path);
        }

        /* Add conditions to join nodes */
        for (int i=0; i<ctx.cond().var().size(); i++) {
            if (ctx.cond().var2(i).var() != null) {
                // Not self const condition
                String var1 = ctx.cond().var(i).getText();
                String var2 = ctx.cond().var2(i).var().getText();
                tree.addJoin(var1, var2);
            } else {
                // Self const condition
                String var = ctx.cond().var(i).getText();
                String constant = ctx.cond().var2(i).constant().getText();
                tree.addSelfCond(var, constant);
            }
        }
        String joinExpression = tree.mergeAllJoinNode();

        /* Replace variables in return */
        String retExpression = ctx.ret().getText().replace("$", "$tuple/");
        StringBuilder builder = new StringBuilder(retExpression);
        /* Add star after each variable in the tuple */
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

/**
 * Label Tree for partition
 */
class LabelTree {

    private LabelNode root;

    private HashMap<String, LabelNode> varMap;

    private ArrayList<JoinNode> joinNodes;

    public LabelTree() {
        root = new LabelNode();
        varMap = new HashMap<>();
        joinNodes = new ArrayList<>();
        varMap.put("root", root);
    }

    public void addVar(String var, String var2, String path) {
        if (varMap.containsKey(var)) {
            throw new IllegalStateException("for has duplicate vars.");
        }

        // Get the parent node
        LabelNode pnode = (var2 == null) ? root : varMap.get(var2);
        if (pnode == null) {
            throw new IllegalStateException();
        }

        // Attach the new node under the parent node
        LabelNode node = new LabelNode();
        node.parent = pnode;
        node.relativePath = path;
        node.var = var;
        pnode.children.add(node);
        varMap.put(var, node);

        // Assign this node to one Join Node
        asignJoinNum(node);
    }

    /**
     * Add one join condition between join nodes
     * @param var1  var name of node 1 to join
     * @param var2  var name of node 2 to join
     */
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

    /**
     * Add one self condition to one one join node
     * @param var   var name of the condition
     * @param constant  const condition
     */
    public void addSelfCond(String var, String constant) {
        LabelNode node = varMap.get(var);
        if (node == null) {
            throw new IllegalStateException();
        }

        JoinNode joinNode = joinNodes.get(node.joinNum);
        joinNode.addSelfCond(node, constant);
    }

    /**
     * Assign one node to its join node
     * @param node  node to assign
     * @return  join number
     */
    public int asignJoinNum(LabelNode node) {
        if (node.joinNum == -1) {

            LinkedList<LabelNode> path = new LinkedList<>();
            LabelNode currNode = node;

            /* Go upwards, until find one assigned node or reach the root*/
            while (currNode != root && currNode.joinNum == -1) {
                path.add(0, currNode);
                currNode = currNode.parent;
            }

            if (currNode != root) {
                /* If find one assigned node, then assign to the same node */
                for (LabelNode n : path) {
                    JoinNode joinNode = joinNodes.get(currNode.joinNum);
                    joinNode.varSet.add(n);
                    n.joinNum = currNode.joinNum;
                }
            } else {
                /* If reach the root, then create a new join node and assign */
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

    /**
     * Merge all join nodes in the join node list
     * @return  Merged expression
     */
    public String mergeAllJoinNode() {
        while (joinNodes.size() != 1) {
            JoinNode node1 = joinNodes.remove(0);
            JoinNode node2 = joinNodes.remove(0);
            JoinNode newNode = mergeJoinNode(node1, node2);
            joinNodes.add(0, newNode);
        }
        return joinNodes.get(0).getExpression();
    }

    /**
     * Merge two join nodes and return the merged one
     * @param n1    join node 1
     * @param n2    join node 2
     * @return      new merged node
     */
    public JoinNode mergeJoinNode(JoinNode n1, JoinNode n2) {

        /* Remove each other from the join table */
        Map<LabelNode, LabelNode> joinMap = n1.joinTable.remove(n2);
        n2.joinTable.remove(n1);

        /* Add other join conditions to the new node's join map */
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

        /* Construct the join expression */
        StringBuilder res = new StringBuilder();
        res.append("join(\n");
        res.append(n1.getExpression());
        res.append(",\n");
        res.append(n2.getExpression());
        res.append(",\n");

        /* Construct the join cond list expression */
        res.append("[");
        if (joinMap != null) {
            for (LabelNode n : joinMap.keySet()) {
                res.append(n.var.substring(1) + ", ");
            }
            res.deleteCharAt(res.length() - 1);
            res.deleteCharAt(res.length() - 1);
        }
        res.append("],\n");

        res.append("[");
        if (joinMap != null) {
            for (LabelNode n : joinMap.keySet()) {
                res.append(joinMap.get(n).var.substring(1) + ", ");
            }
            res.deleteCharAt(res.length() - 1);
            res.deleteCharAt(res.length() - 1);
        }
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

    /**
     * Get experssion for one single join node
     * @return  string of the expression
     */
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

    /**
     * Add a self constant condition
     * @param n     node
     * @param constant  constant
     */
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

    /**
     * Add a join condition to two nodes
     * @param n1    join node 1
     * @param v1    label node 1
     * @param n2    join node 2
     * @param v2    label node 2
     */
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