package tree.heap;

import java.util.Arrays;
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
        heap = new int[maxSize];
    }
    
    public BinaryHeap(int[] heap) {
        this.heap = Arrays.copyOf(heap, heap.length);
        size = heap.length;
        heapify();
    }
    
    private void heapify() {
        for (int i = heap.length - 2 >> 1; i >= 0; i--) {
            siftDown(i);
        }
    }
    
    public int peek() {
        if (isEmpty()) {
            throw new RuntimeException("Illegal peek");
        }
        
        return heap[0];
    }
    
    public void push(int x) {
        if (size == heap.length) {
            throw new RuntimeException("Illegal push");
        }
        
        heap[size++] = x;
        siftUp(size - 1);
    }
    
    public int pop() {
        int res = heap[0];
        heap[0] = heap[--size];
        siftDown(0);
        
        return res;
    }
    
    private void siftDown(int pos) {
        int cur = heap[pos];
        while (leftChild(pos) < size) {
            int smallerIdx = leftChild(pos);
            if (smallerIdx + 1 < size) {
                int rightIdx = smallerIdx + 1;
                if (heap[rightIdx] < heap[smallerIdx]) {
                    smallerIdx = rightIdx;
                }
            }
            
            if (cur <= heap[smallerIdx]) {
                break;
            }
            
            heap[pos] = heap[smallerIdx];
            pos = smallerIdx;
        }
        
        heap[pos] = cur;
    }
    
    private void siftUp(int pos) {
        int cur = heap[pos];
        while (pos > 0) {
            int parent = heap[pos - 1 >> 1];
            if (parent > cur) {
                heap[pos] = parent;
                pos = pos - 1 >> 1;
            } else {
                break;
            }
        }
        
        heap[pos] = cur;
    }
    
    private int leftChild(int pos) {
        return pos * 2 + 1;
    }
    
    public int size() {
        return size;
    }
    
    public boolean isEmpty() {
        return size == 0;
    }
    
    public void replace(int x) {
        if (isEmpty()) {
            throw new RuntimeException("Illegal replace");
        }
        
        heap[0] = x;
        siftDown(0);
    }
}
