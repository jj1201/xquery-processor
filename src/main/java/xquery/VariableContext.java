package xquery;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * Class used to store bound variables in query. Core data structure is a
 * stack. When new variables are bound, memorize their value in a hashMap and
 * then push the map into the stack. The latest variables would overrode the
 * older one automatically due to the nature of stack. When we want to remove
 * last variable definition, just call a pop method.
 *
 * Created by Chang Li on 4/25/16.
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

    public void putVar(String name, QueryList res) {stack.peek().put(name, res);}

    public QueryList getVar(String name) {
        for(int i=0; i<stack.size(); i++) {
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
