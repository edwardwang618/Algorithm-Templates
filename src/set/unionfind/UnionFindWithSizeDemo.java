package set.unionfind;

public class UnionFindWithSizeDemo {
    public static void main(String[] args) {
        UnionFindWithSize uf = new UnionFindWithSize(10);
        uf.union(1, 2);
        System.out.println(uf.getSize(1));
        uf.union(2, 3);
        System.out.println(uf.getSize(3));
        
        uf.union(5, 6);
        uf.union(6, 1);
        System.out.println(uf.getSize(1));
    }
}

/**
 * This unionfind can return the size of the set that a given element belongs to
 */
class UnionFindWithSize {
    
    private final int[] parent, size;
    
    public UnionFindWithSize(int size) {
        parent = new int[size];
        this.size = new int[size];
        for (int i = 0; i < size; i++) {
            parent[i] = i;
            this.size[i] = 1;
        }
    }
    
    public int find(int x) {
        if (x != parent[x]) {
            parent[x] = find(parent[x]);
        }
        
        return parent[x];
    }
    
    public boolean union(int x, int y) {
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
