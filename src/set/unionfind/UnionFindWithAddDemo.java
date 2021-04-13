package set.unionfind;

import java.util.Arrays;

public class UnionFindWithAddDemo {
    public static void main(String[] args) {
        UnionFindWithAdd uf = new UnionFindWithAdd(10);
        uf.add(1);
        System.out.println(uf.contains(1));
        
        uf.add(2);
        uf.union(1, 2);
        System.out.println(uf.getSize(1));
    
        System.out.println(uf.union(2, 3));
    }
}

/**
 * This unionfind can add element (only nonnegative number), ask an element exists or not,
 * also can return the size of the set that a given element belongs to
 */
class UnionFindWithAdd {
    
    private final int[] parent, size;
    
    public UnionFindWithAdd(int size) {
        parent = new int[size];
        this.size = new int[size];
        
        // -1 means an element doesn't exist yet
        Arrays.fill(parent, -1);
    }
    
    public boolean add(int x) {
        if (parent[x] != -1) {
            return false;
        }
        
        parent[x] = x;
        size[x] = 1;
        return true;
    }
    
    public boolean contains(int x) {
        return parent[x] != -1;
    }
    
    public int find(int x) {
        if (!contains(x)) {
            return -1;
        }
        
        if (x != parent[x]) {
            parent[x] = find(parent[x]);
        }
        
        return parent[x];
    }
    
    public boolean union(int x, int y) {
        if (!contains(x) || !contains(y)) {
            return false;
        }
        
        int px = find(x), py = find(y);
        if (px == py) {
            return false;
        }
        
        parent[px] = py;
        size[py] += size[px];
        return true;
    }
    
    public int getSize(int x) {
        return size[find(x)];
    }
}
