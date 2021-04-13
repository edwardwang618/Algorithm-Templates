package linear.deque.array;

public class ArrayDeque {
    public static void main(String[] args) {
        Deque deque = new Deque(10);
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
    
    private int[] dq;
    private int head, tail;
    private int size;
    
    public Deque(int maxSize) {
        dq = new int[maxSize];
    }
    
    public void pushFirst(int x) {
        if (size == dq.length) {
            throw new RuntimeException("Illegal push");
        }
        
        head = (head - 1 + dq.length) % dq.length;
        dq[head] = x;
        
        size++;
    }
    
    public void pushLast(int x) {
        if (size == dq.length) {
            throw new RuntimeException("Illegal push");
        }
        
        dq[tail++] = x;
        tail %= dq.length;
        
        size++;
    }
    
    public int popFirst() {
        if (isEmpty()) {
            throw new RuntimeException("Illegal pop");
        }
        
        int res = dq[head++];
        head %= dq.length;
        
        size--;
        return res;
    }
    
    public int popLast() {
        if (isEmpty()) {
            throw new RuntimeException("Illegal pop");
        }
        
        tail = (tail - 1 + dq.length) % dq.length;
        
        size--;
        return dq[tail];
    }
    
    public int peekFirst() {
        if (isEmpty()) {
            throw new RuntimeException("Illegal peek");
        }
        
        return dq[head];
    }
    
    public int peekLast() {
        if (isEmpty()) {
            throw new RuntimeException("Illegal peek");
        }
        
        return dq[(tail - 1 + dq.length) % dq.length];
    }
    
    public void clear() {
        head = tail = size = 0;
    }
    
    public int size() {
        return size;
    }
    
    public boolean isEmpty() {
        return size == 0;
    }
}