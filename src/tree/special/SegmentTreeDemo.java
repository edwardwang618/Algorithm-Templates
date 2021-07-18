package tree.special;

import java.util.ArrayList;
import java.util.List;

public class SegmentTreeDemo {
    public static void main(String[] args) {
        int[] A = {4, 3, 5, 2};
        SegTree segTree = new SegTree(A);
        
        segTree.add(1, 3, 2);
        System.out.println(segTree);
        
        segTree.update(2, 4, 0);
        System.out.println(segTree);
        
        segTree.update(1, 2, 3);
        System.out.println(segTree);
        System.out.println(segTree.query(1, 4));
    }
}


class SegTree {
    class Node {
        int l, r, sum;
        int lazy, update;
        boolean change;
        
        public Node(int l, int r, int sum) {
            this.l = l;
            this.r = r;
            this.sum = sum;
        }
    }
    
    private Node[] tr;
    private int[] A;
    private int size;
    
    public SegTree(int[] a) {
        size = a.length;
        A = new int[size + 1];
        for (int i = 1; i < A.length; i++) {
            A[i] = a[i - 1];
        }
        
        tr = new Node[size << 2];
        build(1, 1, size);
    }
    
    public void build(int root, int l, int r) {
        if (l == r) {
            tr[root] = new Node(l, l, A[l]);
            return;
        }
        
        tr[root] = new Node(l, r, 0);
        int m = l + r >> 1;
        build(root << 1, l, m);
        build(root << 1 | 1, m + 1, r);
        pushup(root);
    }
    
    private void pushup(int root) {
        tr[root].sum = tr[root << 1].sum + tr[root << 1 | 1].sum;
    }
    
    public void add(int L, int R, int val) {
        add(1, L, R, val);
    }
    
    // [L, R]任务范围
    private void add(int root, int L, int R, int val) {
        int l = tr[root].l, r = tr[root].r;
        // 任务范围覆盖了区间范围，可以懒
        if (L <= l && r <= R) {
            tr[root].sum += val * (r - l + 1);
            tr[root].lazy += val;
            return;
        }
        
        int m = l + r >> 1;
        pushdown(root);
        if (L <= m) {
            add(root << 1, L, R, val);
        }
        if (m + 1 <= R) {
            add(root << 1 | 1, L, R, val);
        }
        pushup(root);
    }
    
    private void pushdown(int root) {
        Node left = tr[root << 1], right = tr[root << 1 | 1];
        if (tr[root].change) {
            tr[root].sum = tr[root].update * (tr[root].r - tr[root].l + 1);
            tr[root].lazy = 0;
            left.sum = tr[root].update * (left.r - left.l + 1);
            left.lazy = 0;
            left.update = tr[root].update;
            left.change = true;
            right.sum = tr[root].update * (right.r - right.l + 1);
            right.lazy = 0;
            right.update = tr[root].update;
            right.change = true;
            tr[root].change = false;
        }
        
        if (tr[root].lazy != 0) {
            left.sum += tr[root].lazy * (left.r - left.l + 1);
            left.lazy += tr[root].lazy;
            right.sum += tr[root].lazy * (right.r - right.l + 1);
            right.lazy += tr[root].lazy;
            tr[root].lazy = 0;
        }
    }
    
    public void update(int L, int R, int val) {
        update(1, L, R, val);
    }
    
    private void update(int root, int L, int R, int val) {
        int l = tr[root].l, r = tr[root].r;
        if (L <= l && r <= R) {
            tr[root].sum = val * (r - l + 1);
            tr[root].lazy = 0;
            tr[root].update = val;
            tr[root].change = true;
            return;
        }
        
        int m = l + r >> 1;
        pushdown(root);
        if (L <= m) {
            update(root << 1, L, R, val);
        }
        if (m + 1 <= R) {
            update(root << 1 | 1, L, R, val);
        }
        pushup(root);
    }
    
    public long query(int L, int R) {
        return query(1, L, R);
    }
    
    private long query(int root, int L, int R) {
        int l = tr[root].l, r = tr[root].r;
        if (L <= l && r <= R) {
            return tr[root].sum;
        }
        
        long res = 0;
        int m = l + r >> 1;
        pushdown(root);
        if (L <= m) {
            res += query(root << 1, L, R);
        }
        if (m + 1 <= R) {
            res += query(root << 1 | 1, L, R);
        }
        return res;
    }
    
    @Override
    public String toString() {
        List<Long> res = new ArrayList<>();
        for (int i = 1; i <= size; i++) {
            res.add(query(1, i, i));
        }
        
        return res.toString();
    }
}

class Right {
    public int[] arr;
    
    public Right(int[] arr) {
        this.arr = new int[arr.length + 1];
        System.arraycopy(arr, 0, this.arr, 1, arr.length);
    }
    
    public void update(int l, int r, int c) {
        for (int i = l; i <= r; i++) {
            arr[i] = c;
        }
    }
    
    public void add(int l, int r, int c) {
        for (int i = l; i <= r; i++) {
            arr[i] += c;
        }
    }
    
    public long query(int l, int r) {
        long res = 0;
        for (int i = l; i <= r; i++) {
            res += arr[i];
        }
        return res;
    }
}