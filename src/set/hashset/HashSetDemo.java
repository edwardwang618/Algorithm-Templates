package set.hashset;

import java.util.Random;

public class HashSetDemo {
    
    static Random random = new Random();
    
    public static void main(String[] args) {
        HashSet hashSet = new HashSet();
        System.out.println(hashSet.add(1));
        System.out.println(hashSet.add(1));
        System.out.println(hashSet.add(2));
        System.out.println(hashSet.add(3));
    
        System.out.println(hashSet.add(132));
    
        System.out.println(hashSet.size());
        System.out.println(hashSet.contains(132));
    
        System.out.println(hashSet.remove(132));
        System.out.println(hashSet.size());
    
        System.out.println(hashSet.contains(132));
    
        for (int i = 0; i < 300; i++) {
            int r = random.nextInt(1000);
            hashSet.add(r);
    
            if (!hashSet.contains(r)) {
                System.out.println("wrong!");
            }
        }
    
        System.out.println(hashSet.size());
    }
}

/**
 * This set is used to store non-negative integers
 */
class HashSet {
    private ListNode[] A;
    private int size;
    private final int P = 131;
    
    public HashSet() {
        A = new ListNode[P];
    }
    
    public boolean add(int x) {
        int h = hash(x);
        if (A[h] == null) {
            A[h] = new ListNode(x);
            
            size++;
            return true;
        }
        
        ListNode cur = A[h], prev = null;
        while (cur != null) {
            if (cur.x == x) {
                return false;
            }
            
            prev = cur;
            cur = cur.next;
        }
        
        prev.next = new ListNode(x);
        
        size++;
        return true;
    }
    
    public boolean contains(int x) {
        int h = hash(x);
        ListNode cur = A[h];
        while (cur != null) {
            if (cur.x == x) {
                return true;
            }
            
            cur = cur.next;
        }
        
        return false;
    }
    
    public boolean remove(int x) {
        int h = hash(x);
        if (A[h] == null) {
            return false;
        }
        
        if (A[h].x == x) {
            A[h] = A[h].next;
            
            size--;
            return true;
        }
        
        ListNode prev = A[h];
        while (prev.next != null) {
            if (prev.next.x == x) {
                prev.next = prev.next.next;
                
                size--;
                return true;
            }
            
            prev = prev.next;
        }
        
        return false;
    }
    
    private int hash(int x) {
        return x % A.length;
    }
    
    public boolean isEmpty() {
        return size == 0;
    }
    
    public int size() {
        return size;
    }
}

class ListNode {
    int x;
    ListNode next;
    
    public ListNode(int x) {
        this.x = x;
    }
}