package linear.blockarray;

public class BlockArrayDemo {
    public static void main(String[] args) {
        int[] A = {1, 2, 3, 4, 5, 0};
        BlockArray blockArray = new BlockArray(A);
        System.out.println(blockArray.max(1, 3));
        blockArray.add(1, 2, 2);
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
        max = new int[n % len == 0 ? n / len : n / len + 1];
        lazy = new int[n % len == 0 ? n / len : n / len + 1];
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
                res = Math.max(res, A[i++] + lazy[get(i)]);
            }
            while (get(j) == get(r)) {
                res = Math.max(res, A[j--] + lazy[get(j)]);
            }
            for (int k = get(i); k <= get(j); k++) {
                res = Math.max(res, max[k] + lazy[k]);
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
                A[i++] += x;
                max[get(i)] = Math.max(max[get(i)], A[i]);
            }
            while (get(j) == get(r)) {
                A[j--] += x;
                max[get(j)] = Math.max(max[get(j)], A[j]);
            }
            for (int k = get(i); k <= get(j); k++) {
                lazy[k] += x;
            }
        }
    }
}