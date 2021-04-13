package linear.array;

public class BinarySearch {
    public static void main(String[] args) {
        int[] A = {1, 3, 4, 7, 10};
        System.out.println(binSearch1(A, 5));
        System.out.println(binSearchRec1(A, 5));
    
        System.out.println(binSearch2(A, 5));
    }
    
    // Find the index of the first number that's >= x
    // [NO, NO, ..., NO, YES, YES, ...]
    // if not found, return -1
    public static int binSearch1(int[] A, int x) {
        if (A.length == 0) {
            return -1;
        }
        
        int l = 0, r = A.length - 1;
        while (l < r) {
            int m = l + (r - l >> 1);
            if (A[m] >= x) {
                r = m;
            } else {
                l = m + 1;
            }
        }
        
        return A[l] >= x ? l : -1;
    }
    
    public static int binSearchRec1(int[] A, int x) {
        return binSearchRec1(A, 0, A.length - 1, x);
    }
    
    // Recursion version of binSearch1, don't use it unless required
    public static int binSearchRec1(int[] A, int l, int r, int x) {
        if (l > r) {
            return -1;
        }
        if (l == r) {
            return A[l] >= x ? l : -1;
        }
        
        int m = l + (r - l >> 1);
        if (A[m] >= x) {
            return binSearchRec1(A, l, m, x);
        } else {
            return binSearchRec1(A, m + 1, r, x);
        }
    }
    
    // Find the index of the last number that's <= x
    // [YES, YES, ..., YES, NO, NO, ...]
    // if not found, return -1
    public static int binSearch2(int[] A, int x) {
        if (A.length == 0) {
            return -1;
        }
        
        int l = 0, r = A.length - 1;
        while (l < r) {
            int m = l + (r - l + 1 >> 1);
            if (A[m] <= x) {
                l = m;
            } else {
                r = m - 1;
            }
        }
        
        return A[l] <= x ? l : -1;
    }
}
