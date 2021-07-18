package linear.stack.monotonestack;

import java.util.ArrayDeque;
import java.util.Deque;

public class ExpressionValuationPostfix {
    public static void main(String[] args) {
        System.out.println(evaluate("1 2 + 3 * 4-"));
    }
    
    public static int evaluate(String s) {
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == ' ') {
                continue;
            }
            
            if (Character.isDigit(ch)) {
                int j = i;
                while (j < s.length() && Character.isDigit(s.charAt(j))) {
                    j++;
                }
                
                stack.push(Integer.parseInt(s.substring(i, j)));
                i = j - 1;
            } else {
                int b = stack.pop(), a = stack.pop();
                int res = 0;
                switch (ch) {
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
        
        return stack.peek();
    }
}
