package tree.heap;

import java.util.Random;

public class BinaryHeapDemo {
    public static void main(String[] args) {
        // int[] A = {62, 41, 30, 28, 16, 22, 13, 19, 17, 15, 52};
        int[] A = {62, 41, 30, 28, 16, 22, 13, 19, 17, 15};
        BinaryHeap heap = new BinaryHeap(A);
        System.out.println("heap.peek() = " + heap.peek());
        System.out.println("heap.pop() = " + heap.pop());
        
        heap.replace(-1);
        System.out.println("heap.peek() = " + heap.peek());
        
        System.out.println("===============");
        int[] arr = new int[new Random().nextInt(1000000)];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = new Random().nextInt(100000);
        }
        
        BinaryHeap heap1 = new BinaryHeap(arr);
        int cur = heap1.peek();
        for (int i = 0; i < arr.length; i++) {
            if (cur > heap1.peek()) {
                System.out.println("error!");
            }
            cur = heap1.pop();
        }
        
        System.out.println("heap1.isEmpty() = " + heap1.isEmpty());
    }
}

/**
 * This heap is min heap
 */
class BinaryHeap {
    private int[] heap;
    private int size;
    
    public BinaryHeap(int maxSize) {
        heap = new int[maxSize + 1];
    }
    
    public BinaryHeap(int[] heap) {
        this.heap = new int[heap.length + 1];
        System.arraycopy(heap, 0, this.heap, 1, heap.length);
        size = heap.length;
        heapify();
    }
    
    private void heapify() {
        for (int i = size >> 1; i >= 1; i--) {
            siftDown(i);
        }
    }
    
    public int peek() {
        return heap[1];
    }
    
    public void push(int x) {
        heap[++size] = x;
        siftUp(size);
    }
    
    public int pop() {
        int res = heap[1];
        heap[1] = heap[size--];
        siftDown(1);
        
        return res;
    }
    
    private void siftDown(int pos) {
        int cur = heap[pos];
        while (pos << 1 < size) {
            int s = pos << 1;
            if (s + 1 < size) {
                if (heap[s + 1] < heap[s]) {
                    s++;
                }
            }
            
            if (cur <= heap[s]) {
                break;
            }
            
            heap[pos] = heap[s];
            pos = s;
        }
        
        heap[pos] = cur;
    }
    
    private void siftUp(int pos) {
        int cur = heap[pos];
        while (pos > 1) {
            int parent = heap[pos >> 1];
            if (parent > cur) {
                heap[pos] = parent;
                pos = pos >> 1;
            } else {
                break;
            }
        }
        
        heap[pos] = cur;
    }
    
    private int leftChild(int pos) {
        return pos * 2;
    }
    
    public int size() {
        return size;
    }
    
    public boolean isEmpty() {
        return size == 0;
    }
    
    public void replace(int x) {
        heap[1] = x;
        siftDown(1);
    }
}
