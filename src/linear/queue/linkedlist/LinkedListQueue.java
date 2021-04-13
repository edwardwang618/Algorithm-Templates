package linear.queue.linkedlist;

public class LinkedListQueue {
    public static void main(String[] args) {
        Queue queue = new Queue();
        queue.push(1);
        queue.push(2);
        queue.push(3);
    
        System.out.println(queue.size());
    
        System.out.println(queue.pop());
        System.out.println(queue.pop());
    
        System.out.println(queue.peek());
        System.out.println(queue.pop());
    
        System.out.println(queue.isEmpty());
    
        for (int i = 0; i < 10; i++) {
            queue.push(i);
        }
    
        System.out.println(queue.pop());
        queue.push(0);
        System.out.println(queue.peek());
    }
}

class Queue {
    private final ListNode dummy = new ListNode(0);
    private ListNode tail = dummy;
    private int size;
    
    public Queue() {
    }
    
    public void push(int x) {
        tail.next = new ListNode(x);
        tail = tail.next;
        size++;
    }
    
    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("Illegal pop");
        }
        
        int res = dummy.next.x;
        dummy.next = dummy.next.next;
        if (size == 1) {
            tail = dummy;
        }
        
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
        tail = dummy;
        size = 0;
    }
    
    public int size() {
        return size;
    }
    
    public boolean isEmpty() {
        return size == 0;
    }
}

class ListNode {
    int x;
    ListNode next;
    
    public ListNode(int x) {
        this.x = x;
    }
}