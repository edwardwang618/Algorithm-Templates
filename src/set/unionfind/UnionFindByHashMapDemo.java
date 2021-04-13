package set.unionfind;

import java.util.HashMap;
import java.util.Map;

public class UnionFindByHashMapDemo {
    public static void main(String[] args) {
        UnionFindByHashMap uf = new UnionFindByHashMap();
        uf.add("abc");
        uf.add("cba");
        uf.union("abc", "cba");
        System.out.println(uf.getSize("abc"));
        
        uf.add("acb");
        uf.union("abc", "acb");
        System.out.println(uf.getSize("abc"));
    }
}

class UnionFindByHashMap {
    private final Map<String, String> parent;
    private final Map<String, Integer> size;
    
    public UnionFindByHashMap() {
        parent = new HashMap<>();
        size = new HashMap<>();
    }
    
    public boolean contains(String s) {
        return parent.containsKey(s);
    }
    
    public boolean add(String s) {
        if (contains(s)) {
            return false;
        }
        
        parent.put(s, s);
        size.put(s, 1);
        return true;
    }
    
    public String find(String s) {
        if (!contains(s)) {
            return null;
        }
        
        if (!s.equals(parent.get(s))) {
            parent.put(s, find(parent.get(s)));
        }
        
        return parent.get(s);
    }
    
    public boolean union(String x, String y) {
        if (!contains(x) || !contains(y)) {
            return false;
        }
        
        String px = parent.get(x), py = parent.get(y);
        if (px.equals(py)) {
            return false;
        }
        
        parent.put(px, py);
        size.put(py, size.get(px) + size.get(py));
        return true;
    }
    
    public int getSize(String s) {
        return size.getOrDefault(find(s), -1);
    }
}