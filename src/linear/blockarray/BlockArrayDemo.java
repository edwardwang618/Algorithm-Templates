package linear.blockarray;

public class BlockArrayDemo {
    public static void main(String[] args) {
        // when adding, you can only add nonnegative numbers
        int[] A = {1, 2, 3, 4, 5, 0};
        BlockArray blockArray = new BlockArray(A);
        System.out.println(blockArray.max(1, 3));
        blockArray.add(1, 4, 2);
        System.out.println(blockArray.max(1, 3));
    
        System.out.println(blockArray.max(3, 5));
        blockArray.add(5, 5, 6);
        System.out.println(blockArray.max(3, 5));
    }
}

class BlockArray {
    final private int len;
    final private int[] A, max, lazy;
    
    public BlockArray(int[] a) {
        A = a;
        int n = a.length;
        len = (int) Math.sqrt(n);
        int cnt = n % len == 0 ? n / len : n / len + 1;
        max = new int[cnt];
        for (int i = 0; i < n; i++) {
            max[get(i)] = Math.max(max[get(i)], A[i]);
        }
        lazy = new int[cnt];
    }
    
    private int get(int i) {
        return i / len;
    }
    
    public int max(int l, int r) {
        int res = Integer.MIN_VALUE;
        if (get(l) == get(r)) {
            for (int i = l; i <= r; i++) {
                res = Math.max(res, A[i] + lazy[get(i)]);
            }
        } else {
            int i = l, j = r;
            while (get(i) == get(l)) {
                res = Math.max(res, A[i] + lazy[get(i)]);
                i++;
            }
            while (get(j) == get(r)) {
                res = Math.max(res, A[j] + lazy[get(j)]);
                j--;
            }
            for (int k = get(i); k <= get(j); k++) {
                res = Math.max(res, max[k]);
            }
        }
        
        return res;
    }
    
    public void add(int l, int r, int x) {
        if (get(l) == get(r)) {
            for (int i = l; i <= r; i++) {
                A[i] += x;
                max[get(i)] = Math.max(max[get(i)], A[i]);
            }
        } else {
            int i = l, j = r;
            while (get(i) == get(l)) {
                A[i] += x;
                max[get(i)] = Math.max(max[get(i)], A[i]);
                i++;
            }
            while (get(j) == get(r)) {
                A[j] += x;
                max[get(j)] = Math.max(max[get(j)], A[j]);
                j--;
            }
            for (int k = get(i); k <= get(j); k++) {
                max[k] += x;
                lazy[k] += x;
            }
        }
    }
}

//     block array         (segment tree more powerful, but complicated)
//
// to do two things:
//         find the maximum over an interval  O sqrt n
//         add a number over an interval
//
//
//         7  2,
//
//         if n can be divided by len, n/len, otherwise n/len + 1
//
//         (1, 2), (3, 4), (5, 6), (7)
//
//         set each block has length sqrt(length of A),  best practice
//         0  1    2  3    4  5
//         A = (1, 2), (3, 4), (5, 0)
//
//         int[] max,   max[i] stores the maximum over the ith block, not including lazy
//         max[0] = 2, max[1] = 4, max[2] = 5
//
//         int[] lazy, lazy[i] stores the number that need to be added but not added in reality
//
//
//         add a number:
//
//         l, r, x
//         1, 2, 2    add 2 over [1: 2]
//
//         A= [1, 4, 5, 4, 5, 0]
//
//
//         add x on the interval [l, r]
//
//         get the block id of l, and the block id of r,  the block id for an index, idx / len
//
//
//         1 if l and r belongs to the same block, then add the number to the array by brute false, and update the max also
//         O(sqrt n)
//
//         2 [l, ............,.... r]
//         (   ) (i th)  (  )  (    )
//
//         do brute force for incomplete blocks(and the update the max[] accordingly),
//         for complete blocks, we do lazy tagging, update sum as well
//
//         do this: lazy[i] += x, max[i] += x
//
//         imcomplete   complete
//         O(2 * sqrt n + sqrt n)
//
//
//
//         query the max:
//
//         query the max over [l, r]
//
//         [1, 2, 3]  lazy[i] = 4
//         1 if l and r belongs to the same block, we do brute force, but take lazy[i] into consideration
//
//         2 if l and r belongs to different blocks
//         [l, ............,.... r]
//         (   ) (i th)  (  )  (    )
//
//         do brute force for incomplete blocks(for the block containing the ending point), taking lazy into consideration;
//         for the complete blocks, traverse max array, also taking lazy into consideration;
//
//
//
//
//         A = [1, 4, 5, 4, 5, 0]
//         (1, 4),(5, 4), (5, 0)
//         (             )
//         max [4,     5,       5]
//         lazy[0      0        0]
//
//
//         1,   max over [1: 3]    5
//
//         2,   add 2 over [1: 4]
//         1 is in the 0th block, 4 is in the second block
//
//         for the incomplete block, brute force
//
//         A = [1, 6,  5, 4,   7, 0]              [1, 6, 7, 6, 7, 0]
//         (1, 6),(5, 4), (7, 0)
//         max [   6,    7       7]
//         for the complete block
//         lazy[  0      2       0]
//
//
//
//         query max over [1:3]
//
//         1 is in the 0th block, 3 is in the first block
//
//         6   6 7
//
//         query max over [1, 4]
//
//         1 is in the 0th block, 4 is in the 2nd block
//
//         6   7   7   max is 7
//
//
//         add 4 on [0:4]
//
//         0 is in the 0th block, 4 is in 2nd block
//
//
//         A = [5, 10,  5, 4,   11, 0]              [5, 10, 11, 10, 11, 0]
//         (5, 10),(5, 4), (11, 0)
//         max [   10,    11       11]
//         for the complete block
//         lazy[  0      2+4=6       0]
//
//
//         query max [3, 5]
//
//         10  0  11  max 11
//
//
//         query the sum over an interval
//         add a number over an interval   can be negative
