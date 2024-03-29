package xquery;

import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * A warpped NodeList class. Use this to store node context during the
 * processing. Except for common list-related methods, also add some
 * set-related and tree-related methods.
 *
 * Created by Chang Li on 4/23/16.
 */
public class QueryList implements NodeList, Iterable<Node> {

    private LinkedList<Node> nodeList;

    /**
     * Constructor
     */

    public QueryList() {
        nodeList = new LinkedList<>();
    }

    public QueryList(NodeList nl) {
        this();
        for (int i=0; i<nl.getLength(); i++) {
            nodeList.add(nl.item(i));
        }
    }

    /**
     * Core Helper Methods
     */

    public boolean nodeValueEqual(Node node1, Node node2) {
        return node1.isEqualNode(node2);
    }

    public boolean nodeIdEqual(Node node1, Node node2) {
        return node1.isSameNode(node2);
    }

    public boolean valueContains(Node node) {
        for (Node n : nodeList) {
            if (nodeValueEqual(node, n)) {
                return true;
            }
        }
        return false;
    }

    public boolean idContains(Node node) {
        for (Node n : nodeList) {
            if (nodeIdEqual(node, n)) {
                return true;
            }
        }
        return false;
    }

    /**
     * General NodeList/List Methods
     */

    @Override
    public int getLength() {
        return nodeList.size();
    }

    @Override
    public Node item(int i) {
        return nodeList.get(i);
    }

    public boolean add(Node node) {
        if (idContains(node)) {
            return false;
        }
        nodeList.add(node);
        return true;
    }

    public Iterator<Node> iterator() {
        return nodeList.iterator();
    }

    public int size() { return nodeList.size(); }

    public boolean isEmpty() { return nodeList.isEmpty(); }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Node node : nodeList) {
            sb.append(node.getNodeName());
            sb.append(" | ");
        }
        if (sb.length() > 0)
            return sb.substring(0, sb.length()-3);
        else
            return "";
    }

    /**
     * Special Set Methods
     */

    public QueryList children() {
        QueryList res = new QueryList();
        for (Node node : nodeList) {
            NodeList childList = node.getChildNodes();
            for (int i=0; i<childList.getLength(); i++) {
                Node child = childList.item(i);
                if (child.getNodeType() == Node.ELEMENT_NODE) {
                    res.add(child);
                }
            }
        }
        return res;
    }

    public QueryList parent() {
        QueryList res = new QueryList();
        for (Node node : nodeList) {
            Node p = node.getParentNode();
            if (p != null) {
                res.add(p);
            }
        }
        return res;
    }

    public QueryList union(QueryList nl) {
        for (Node node : nl) {
            add(node);
        }
        return this;
    }

    public QueryList valueIntersect(QueryList nl) {
        QueryList res = new QueryList();
        for (Node node : nl) {
            if (valueContains(node)) {
                res.add(node);
            }
        }
        return res;
    }

    public QueryList idIntersect(QueryList nl) {
        QueryList res = new QueryList();
        for (Node node : nl) {
            if (idContains(node)) {
                res.add(node);
            }
        }
        return res;
    }

    public QueryList subtract(QueryList nl) {
        QueryList res = new QueryList();
        for(Node node : this) {
            if(!nl.valueContains(node))
                res.add(node);
        }
        return res;
    }
}
