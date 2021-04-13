package set.unionfind;

public class UnionFindDemo {
    public static void main(String[] args) {
        UnionFind uf = new UnionFind(10);
        System.out.println(uf.find(1));
        System.out.println(uf.find(2));
    
        System.out.println(uf.union(1, 2));
        System.out.println(uf.find(1) == uf.find(2));
        System.out.println(uf.union(1, 2));
    }
}

/**
 * UnionFind is also called "disjoint set"
 */
class UnionFind {
    
    private final int[] parent;
    
    public UnionFind(int size) {
        parent = new int[size];
        for (int i = 0; i < size; i++) {
            parent[i] = i;
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
        return true;
    }
}
