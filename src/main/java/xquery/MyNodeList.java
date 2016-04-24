package xquery;

import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by lichkkkk on 4/23/16.
 */
public class MyNodeList implements NodeList {

    private LinkedList<Node> list;
    private HashSet<Node> nodeSet;

    public MyNodeList() {
        this(null);
    }

    public MyNodeList(NodeList nodeList) {
        list = new LinkedList<>();
        nodeSet = new HashSet<>();
        if (nodeList != null) {
            for (int i = 0; i < nodeList.getLength(); i++) {
                list.add(nodeList.item(i));
            }
        }
    }

    @Override
    public int getLength() {
        return list.size();
    }

    @Override
    public Node item(int i) {
        return list.get(i);
    }

    public MyNodeList children() {
        MyNodeList res = new MyNodeList();
        for (Node node : list) {
            NodeList nl = node.getChildNodes();
            for (int i=0; i<nl.getLength(); i++) {
                Node child = nl.item(i);
                if (child.getNodeType() == Node.ELEMENT_NODE) {
                    res.list.add(child);
                }
            }
        }
        return res;
    }

    public MyNodeList parent() {
        MyNodeList res = new MyNodeList();
        for (Node node : list) {
            Node p = node.getParentNode();
            if (p != null) {
                res.list.add(node);
            }
        }
        return res;
    }

    public MyNodeList union(MyNodeList nodeList) {
        for (Node node : nodeList.getList()) {
            if (!nodeSet.contains(node)) {
                list.add(node);
            }
        }
        return this;
    }

    public List<Node> getList() {
        return list;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Node node : list) {
            sb.append(node.getNodeName());
            sb.append(" | ");
        }
        if (sb.length() > 0)
            return sb.substring(0, sb.length()-3);
        else
            return "";
    }
}
