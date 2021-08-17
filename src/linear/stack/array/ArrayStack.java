package linear.stack.array;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

public class ArrayStack {
    public static void main(String[] args) {
        Stack stack = new Stack(10);
        stack.push(1);
        stack.push(2);
        stack.push(4);
        
        System.out.println(stack.peek());
        System.out.println(stack.size());
        System.out.println(stack.isEmpty());
        
        System.out.println(stack.pop());
        System.out.println(stack.size());
    }
}

class Stack {
    private int[] stk;
    
    // top is the position next to the top element
    private int top;
    
    public Stack(int maxSize) {
        stk = new int[maxSize];
    }
    
    public void push(int x) {
        stk[top++] = x;
    }
    
    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("Illegal pop");
        }
        
        return stk[--top];
    }
    
    public int peek() {
        if (isEmpty()) {
            throw new RuntimeException("Illegal peek");
        }
        
        return stk[top - 1];
    }
    
    public void clear() {
        top = 0;
    }
    
    public boolean isEmpty() {
        return top == 0;
    }
    
    public int size() {
        return top;
    }
}