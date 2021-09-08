package tree.special;

import java.util.PriorityQueue;

public class HuffmanTree {
    public static void main(String[] args) {
        int[] A = {3, 3, 1, 2};
        System.out.println(merge(A));
    }
    
    static int merge(int[] A) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int x : A) {
            minHeap.offer(x);
        }
        
        int res = 0;
        while (minHeap.size() > 1) {
            int x = minHeap.poll(), y = minHeap.poll();
            res += x + y;
            minHeap.offer(x + y);
        }
        
        return res;
    }
}
