package linear.blockarray;

import java.util.Arrays;

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
    final private int[] A, max, lazy, sum;
    
    public BlockArray(int[] a) {
        A = a;
        int n = a.length;
        len = (int) Math.sqrt(n);
        int cnt = n % len == 0 ? n / len : n / len + 1;
        max = new int[cnt];
        Arrays.fill(max, Integer.MIN_VALUE);
        sum = new int[cnt];
        for (int i = 0; i < n; i++) {
            max[get(i)] = Math.max(max[get(i)], A[i]);
            sum[get(i)] += A[i];
        }
        
        lazy = new int[cnt];
    }
    
    // A[i] is in which block
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
    
    // add x on [l : r], x any number
    public void add(int l, int r, int x) {
        if (get(l) == get(r)) {
            for (int i = l; i <= r; i++) {
                A[i] += x;
                sum[get(i)] += x;
            }
            // l is the index for the first element of the get(l)'s block
            l = get(l) * len;
            r = Math.min(A.length - 1, (get(l) + 1) * len - 1);
            
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
    
    private void updateMax(){

    }
}

// prefix sum is a data structure to do what?
//
//     purpose of this data structure:
//
//     given an array A, we can build the prefix sum array for it, and prefix sum array
//     can answer the query like "what is the sum within [l, l + 1, ..., r] for the array A", A[l:r] in O1. Why we need this? because answering that query will take On time by brute force, but only O1 time by using prefix sum array
//
//
//     how to build this data structure?
//
//
//
//     how to use this data structure to answer the query? what is the complexity
//
//
//
//
//
//
//
//     BlockArray
//
//
//     purpose of this data structure
//     given an array A, length is n, we can build the blockarray for it, and this data structure has functions:
//     1. query an interval          find the max in [l: r]           O(sqrt n)
//     2. modify an interval         add a nonnegative number x on [l: r], x>0    O(sqrt n)
//
//     find the sum in [l:r]
//     add a number x on [l:r]
//
//
//     build?
//     given an array A, length is n,
//
//     int[] A, max, lazy;
//     A: itself
//     max: max[i] is the maximum for the numbers in the ith block
//     lazy: lazy[i] is tagging, is the number that should be added to the ith block, but not yet
//
//
//     [1, 2, 3, 4, 5, 0]
//
//     max   (  )  (  )  (   )
//     max  [ 2     4      5]
//
//
//     max[0]
//     len = 2, cnt = 3
//
//
//
//     how to use this data structure to answer the query?
//
//     add a nonnegative number over [l:r]
//
//
//     [1, 2, 3, 4, 5, 0]
//
//     max   (  )  (  )  (   )         max stores the actual, real, genuin max for the block(no lazy taken into consideration)
//
//     max  [ 2     4      5]
//     lazy [               ]
//
//
//     first check whether l and r belong to the same block?
//     if yes, modify by brute force
//     update the A, update the max accordingly
//     if no, l is in block i, r in block j, do brute force for incomplete blocks, do lazy tagging and update max accordingly for complete block
//
//
//     0  1  2  3  4  5
//     [1, 4, 3, 4, 7, 0]          [1, 4, 5, 6, 7, 0] genuine array
//
//     max   (  )  (  )  (   )         max stores the actual, real, genuin max for the block for the genuine array
//
//     max  [ 4     6      7]
//     lazy [       2       ]
//
//     add 2 on [1 : 4]
//
//
//     find the block id for left end point, 0, do brute force,
//     find the block id for right end point, 2, do brute force
//     for the complete blocks in between, we do lazy tagging, and update max accordingly
//
//
//
//     when you do a modification on a data structure, you need to check the definition of the variables is maintained
//
//
//     general rule: for incomplete blocks, query must consider the lazy;
//     for complete blocks, query not consider the lazy
//
//     query the max [l: r]
//     first check whether l and r belong to the same block?
//     if yes, brute force, check the max A[l:r] + lazy,
//     if no, brute force for incomplete, and check max on the complete blocks
//
//
//
//
//
//     0  1  2  3  4  5
//     [1, 4, 3, 4, 7, 0]          [1, 4, 5, 6, 7, 0] genuine array
//
//     max   (  )  (  )  (   )         max stores the actual, real, genuin max for the block for the genuine array
//
//     max  [ 4     6      7]
//     lazy [       2       ]
//
//     query max over [1:3]
//
//
//     1, 0th, 4
//     3  1st, 4 + 2, 3 + 2


// do 2 things, find the sum [l:r], add any number on [l:r]
//
//         construct a block which can do 2 things, find the sum [l:r], add any number on [l:r]
//
//         0  1  2  3  4  5
//         A    [1, 4, 3, 4, 7, 2]      [1, 4, 5, 6, 7, 2]
//         sum   ( 5 ) (11)  ( 9)
//         lazy  (  )  ( 2)  (  )
//
//
//
//         add 2 on 1:5
//
//         1, 0th,
//         5  2nd
//
//
//         query 2:4
//         2, 1st,  (3 + 2) + (4 + 2) = 11
//         4 2nd  7
//
//         11 + 7 = 18
//
//
//         0  1  2  3  4  5
//         A    [-1, 2, 3, 4, 5, 2]      [-1, 2, 3, 4, 5, 2]
//         sum   ( 1 ) (7)  ( 7)
//         lazy  (  )  (0)  (  )
//
//         add -2  on 0:4
//         0, 0th
//         4, 2nd
//
//
//         0  1  2  3  4  5
//         A    [-1, 5, 3, 4, 8, 5]      [-1, 5, 6, 7, 8, 5]
//         sum   ( 4 ) (13 )  ( 13)
//         lazy  (  )  (3  )  (   )
//
//         add 3 on 1:5
//         1, 0th
//         5 2nd,


// 0  1  2  3  4  5
// A    [-1, 5, 3, 4, 8, 5]      [-1, 5, 6, 7, 8, 5]
// sum   ( 4 ) (13  )  ( 13)
// lazy  (  )  (3  )  (  )
//
//
//
// query 1:4
// 1, 0th   5 + 0
// 4, 2nd   8 + 0
// complete  13
//
// 5+8+13=26


// construct a block array to do 3 things
//     1 query the max [l:r]
//     2 query the sum [l:r]
//     3 add number x over [l:r]
//
//
//
//     0  1  2  3  4  5
//     A    [1, 5, 3, 4, 8, 0]          [1, 5, 6, 7, 8, 0]
//     max   ( 5)  (7  ) (8 )
//     sum   (6 )  (13  ) (8)
//     lazy  (  )  ( 3)   ()
//
//
//     add 3 on[1: 4]
//     1, 0th
//     4, 2nd
//
//
//     query the max on [2:5]
//     2, 1st,   3 + 3, 4+3
//     5 2nd     0  8
//
//     8
//
//     0  1  2  3  4  5
//     A    [1, 5, 3, 4, 8, 0]          [1, 5, 6, 7, 8, 0]
//     max   ( 5)  (7  ) (8 )
//     sum   (6 )  (13  ) (8)
//     lazy  (  )  ( 3)   ()
//
//     query the sum on [3:5]
//
//     3, 1st  7
//     5, 2nd  0 + 8
//     15
//
//
//     0  1  2  3  4  5
//     A    [-4, 0, 3, 4, 3, -5]          [-4, 0, 1, 2, 3, -5]
//     max   ( 0)  (2  ) (3 )
//     sum   (-4 )  (3 ) (-2)
//     lazy  (  )  ( -2)   ()
//
//     add -5 on [0:5]
//     0, 0th block
//     5, 2nd block