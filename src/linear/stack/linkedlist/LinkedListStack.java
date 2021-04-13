package linear.stack.linkedlist;

public class LinkedListStack {
    public static void main(String[] args) {
        Stack stack = new Stack();
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
    
    private final ListNode dummy = new ListNode(0);
    private int size;
    
    public Stack() {
    }
    
    public void push(int x) {
        ListNode node = new ListNode(x);
        node.next = dummy.next;
        dummy.next = node;
        
        size++;
    }
    
    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("Illegal pop");
        }
        
        int res = dummy.next.x;
        dummy.next = dummy.next.next;
        size--;
        
        return res;
    }
    
    public int peek() {
        if (isEmpty()) {
            throw new RuntimeException("Illegal peek");
        }
        
        return dummy.next.x;
    }
    
    public void clear() {
        dummy.next = null;
        size = 0;
    }
    
    public boolean isEmpty() {
        return size == 0;
    }
    
    public int size() {
        return size;
    }
}

class ListNode {
    int x;
    ListNode next;
    
    public ListNode(int x) {
        this.x = x;
    }
}