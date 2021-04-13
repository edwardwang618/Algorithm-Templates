package linear.queue.array;

public class ArrayQueue {
    public static void main(String[] args) {
        Queue queue = new Queue(10);
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
    private int[] q;
    private int head, tail;
    private int size;
    
    public Queue(int maxSize) {
        q = new int[maxSize];
    }
    
    public void push(int x) {
        if (size == q.length) {
            throw new RuntimeException("Illegal push");
        }
        
        q[tail++] = x;
        tail %= q.length;
        size++;
    }
    
    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("Illegal pop");
        }
        
        int res = q[head++];
        head %= q.length;
        
        size--;
        return res;
    }
    
    public int peek() {
        if (isEmpty()) {
            throw new RuntimeException("Illegal peek");
        }
        
        return q[head];
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
