package linear.deque.linkedlist;

public class LinkedListDeque {
    public static void main(String[] args) {
        Deque deque = new Deque();
        deque.pushFirst(1);
        deque.pushFirst(2);
        deque.pushLast(3);
        deque.pushLast(4);
        deque.pushLast(5);
        
        System.out.println(deque.peekFirst());
        System.out.println(deque.peekLast());
        
        System.out.println(deque.size());
        
        System.out.println(deque.popFirst());
        System.out.println(deque.peekFirst());
        System.out.println(deque.popLast());
        System.out.println(deque.size());
        
        deque.clear();
        
        for (int i = 0; i < 10; i++) {
            deque.pushLast(i);
        }
        
        System.out.println(deque.popFirst());
        System.out.println(deque.size());
    }
}

class Deque {
    private ListNode head, tail;
    private int size;
    
    public Deque() {
    }
    
    public void pushFirst(int x) {
        if (isEmpty()) {
            head = tail = new ListNode(x);
        } else {
            head.prev = new ListNode(x);
            head.prev.next = head;
            head = head.prev;
        }
        
        size++;
    }
    
    public void pushLast(int x) {
        if (isEmpty()) {
            head = tail = new ListNode(x);
        } else {
            tail.next = new ListNode(x);
            tail.next.prev = tail;
            tail = tail.next;
        }
        
        size++;
    }
    
    public int popFirst() {
        if (isEmpty()) {
            throw new RuntimeException("Illegal pop");
        }
        
        int res = head.x;
        if (size == 1) {
            head = tail = null;
        } else {
            head.next.prev = null;
            head = head.next;
        }
        
        size--;
        return res;
    }
    
    public int popLast() {
        if (isEmpty()) {
            throw new RuntimeException("Illegal pop");
        }
        
        int res = tail.x;
        if (size == 1) {
            head = tail = null;
        } else {
            tail.prev.next = null;
            tail = tail.prev;
        }
        
        size--;
        return res;
    }
    
    public int peekFirst() {
        if (isEmpty()) {
            throw new RuntimeException("Illegal peek");
        }
        
        return head.x;
    }
    
    public int peekLast() {
        if (isEmpty()) {
            throw new RuntimeException("Illegal peek");
        }
        
        return tail.x;
    }
    
    public void clear() {
        head = tail = null;
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
    ListNode prev, next;
    
    public ListNode(int x) {
        this.x = x;
    }
}
