package linear.linkedlist.singlely;

public class StaticLinkedList {
    public static void main(String[] args) {
        StaticList list = new StaticList();
        list.addFirst(1);
        list.addFirst(2);
        list.addFirst(3);
    
        System.out.println(list);
        
        list.deleteFirst();
        System.out.println(list);
    }
}

class StaticList {
    private static final int N = 100000;
    private int h, idx;
    private final int[] e, ne;
    
    public StaticList() {
        h = -1;
        e = new int[N];
        ne = new int[N];
        idx = 0;
    }
    
    public void addFirst(int x) {
        e[idx] = x;
        ne[idx] = h;
        h = idx++;
    }
    
    public void deleteFirst() {
        if (h == -1) {
            throw new RuntimeException("Illegal delete");
        }
        
        h = ne[h];
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        if (h != -1) {
            for (int cur = h; cur != -1; cur = ne[cur]) {
                sb.append(e[cur]).append("->");
            }
    
            sb.setLength(sb.length() - 2);
        }
        
        sb.append("}");
        return sb.toString();
    }
}
