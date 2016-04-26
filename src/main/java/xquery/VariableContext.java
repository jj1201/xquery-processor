package xquery;

import org.antlr.v4.runtime.tree.RuleNode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * Created by lichkkkk on 4/25/16.
 */
public class VariableContext {

    private LinkedList<Map<String, QueryList>> stack = new LinkedList<>();

    /*
     *  Basic stack methods
     */

    public void pushContext() {
        stack.push(new HashMap<String, QueryList>());
    }

    public void popContext() {
        stack.pop();
    }

    public Map<String, QueryList> peek() {
        return stack.peek();
    }

    /*
     *  Variable Related methods
     */

    public void putVar(String name, QueryList xq) {stack.peek().put(name, xq);}

    public QueryList getVar(String name) {
        for(int i=stack.size()-1; i>=0; i--) {
            Map<String, QueryList> context = stack.get(i);
            if (context.containsKey(name)) {
                return context.get(name);
            }
        }
        throw new Error("Variable <" + name + "> not found.");
    }

    /*
     *  Other methods
     */

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for(Map<String, QueryList> context : stack) {
            builder.append("[ ");
            for (String name : context.keySet()) {
                builder.append(name + "-" + context.get(name) + ";");
            }
            builder.append(" ]\n");
        }
        return builder.toString();
    }

}
