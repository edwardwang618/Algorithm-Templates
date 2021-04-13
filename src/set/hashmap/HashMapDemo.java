package set.hashmap;

import java.util.Random;

public class HashMapDemo {
    static Random random = new Random();
    
    public static void main(String[] args) {
        HashMap hashMap = new HashMap();
        System.out.println(hashMap.put(1, 1));
        System.out.println(hashMap.get(1));
        System.out.println(hashMap.put(1, 2));
        System.out.println(hashMap.get(1));
        System.out.println(hashMap.put(2, 2));
        System.out.println(hashMap.put(3, 2));
        
        System.out.println(hashMap.put(132, 1));
        
        System.out.println(hashMap.size());
        System.out.println(hashMap.contains(132));
        
        System.out.println(hashMap.remove(132));
        System.out.println(hashMap.size());
        
        System.out.println(hashMap.contains(132));
        
        for (int i = 0; i < 300; i++) {
            int r = random.nextInt(1000);
            hashMap.put(r, r * r);
            
            if (!hashMap.contains(r)) {
                System.out.println("wrong!");
            }
        }
        
        System.out.println(hashMap.size());
    }
}

/**
 * This map is to store the entries whose keys are non-negative
 */
class HashMap {
    private ListNode[] A;
    private int size;
    private final int P = 131;
    
    public HashMap() {
        A = new ListNode[P];
    }
    
    // return the value of the key, or -1 if key does not exist
    public int get(int key) {
        int h = hash(key);
        ListNode cur = A[h];
        while (cur != null) {
            if (cur.key == key) {
                return cur.value;
            }
        
            cur = cur.next;
        }
    
        return -1;
    }
    
    // return the old value of the key, or -1 if key does not exist
    public int put(int key, int value) {
        int h = hash(key);
        if (A[h] == null) {
            A[h] = new ListNode(key, value);
            
            size++;
            return -1;
        }
        
        ListNode cur = A[h], prev = null;
        while (cur != null) {
            if (cur.key == key) {
                int old = cur.value;
                cur.value = value;
                return old;
            }
            
            prev = cur;
            cur = cur.next;
        }
        
        prev.next = new ListNode(key, value);
        
        size++;
        return -1;
    }
    
    public boolean contains(int key) {
        int h = hash(key);
        ListNode cur = A[h];
        while (cur != null) {
            if (cur.key == key) {
                return true;
            }
            
            cur = cur.next;
        }
        
        return false;
    }
    
    public boolean remove(int key) {
        int h = hash(key);
        if (A[h] == null) {
            return false;
        }
        
        if (A[h].key == key) {
            A[h] = A[h].next;
            
            size--;
            return true;
        }
        
        ListNode prev = A[h];
        while (prev.next != null) {
            if (prev.next.key == key) {
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
    int key, value;
    ListNode next;
    
    public ListNode(int key, int value) {
        this.key = key;
        this.value = value;
    }
}