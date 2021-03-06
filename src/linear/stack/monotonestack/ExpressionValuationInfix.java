package linear.stack.monotonestack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Map;

public class ExpressionValuationInfix {
    public static void main(String[] args) {
        System.out.println(evaluate("1+2* (3 + 4)"));
        System.out.println(evaluate("(7+2)/ (1 + 2)"));
    }
    
    // s is an infix polish expression, evaluate it
    public static int evaluate(String s) {
        Map<Character, Integer> prio = Map.of(
                '(', 0,
                '+', 1, '-', 1,
                '*', 2, '/', 2);
        
        Deque<Integer> stk = new ArrayDeque<>();
        // maintain the stack op as a monotone stack, op stores the operators
        // in the increasing order from button to the top
        Deque<Character> op = new ArrayDeque<>();
        
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == ' ') {
                continue;
            }
            
            if (ch == '(') {
                op.push(ch);
            } else if (Character.isDigit(ch)) {
                int j = i;
                while (j < s.length() && Character.isDigit(s.charAt(j))) {
                    j++;
                }
                
                stk.push(Integer.parseInt(s.substring(i, j)));
                i = j - 1;
            } else if (prio.containsKey(ch)) {
                while (!op.isEmpty() && prio.get(op.peek()) >= prio.get(ch)) {
                    calc(stk, op);
                }
                
                op.push(ch);
            } else if (ch == ')') {
                while (op.peek() != '(') {
                    calc(stk, op);
                }
                
                // pop '('
                op.pop();
            }
        }
        
        while (!op.isEmpty()) {
            calc(stk, op);
        }
        
        return stk.peek();
    }
    
    private static void calc(Deque<Integer> stack, Deque<Character> op) {
        int b = stack.pop(), a = stack.pop();
        
        int res = 0;
        switch (op.pop()) {
            case '+':
                res = a + b;
                break;
            case '-':
                res = a - b;
                break;
            case '*':
                res = a * b;
                break;
            case '/':
                res = a / b;
                break;
            default:
        }
        
        stack.push(res);
    }
}
