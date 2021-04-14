package tree;

import java.util.Arrays;

public class BinaryHeapDemo {
    public static void main(String[] args) {
        // BinaryHeap heap = new BinaryHeap(10);
    
        // for (int i = 0; i < 10; i++) {
        //     heap.push(new Random().nextInt(20));
        // }
        
        // System.out.println(heap.peek());
        
        int[] A = {62, 41, 30, 28, 16, 22, 13, 19, 17, 15, 52};
        BinaryHeap heap = new BinaryHeap(A);
        System.out.println("heap.peek() = " + heap.peek());
    
        System.out.println("heap.size() = " + heap.size());
        System.out.println("heap.pop() = " + heap.pop());
        System.out.println("heap.pop() = " + heap.pop());
        System.out.println("heap.pop() = " + heap.pop());
        System.out.println("heap.pop() = " + heap.pop());
        System.out.println("heap.pop() = " + heap.pop());
        System.out.println("heap.pop() = " + heap.pop());
        System.out.println("heap.size() = " + heap.size());
        System.out.println("heap.pop() = " + heap.pop());
        System.out.println("heap.pop() = " + heap.pop());
        System.out.println("heap.pop() = " + heap.pop());
        System.out.println("heap.pop() = " + heap.pop());
        System.out.println("heap.size() = " + heap.size());
        System.out.println("heap.peek() = " + heap.peek());
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
        for (int i = heap.length - 2 >> 1; i >= 0 ; i--) {
            siftDown(i);
        }
    }
    
    public int peek() {
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
        while (pos * 2 + 1 < size - 1) {
            int smallerIdx = pos, tmp = cur;
            int leftIdx = leftChild(pos);
            if (heap[leftIdx] < tmp) {
                smallerIdx = leftIdx;
                tmp = heap[leftIdx];
            }
            
            if (pos * 2 + 2 < size - 1) {
                int rightIdx = rightChild(pos);
                if (heap[rightIdx] < tmp) {
                    smallerIdx = rightIdx;
                }
            }
            
            if (smallerIdx == pos) {
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
    
    private int rightChild(int pos) {
        return pos * 2 + 2;
    }
    
    public int size() {
        return size;
    }
    
    public boolean isEmpty() {
        return size == 0;
    }
}
