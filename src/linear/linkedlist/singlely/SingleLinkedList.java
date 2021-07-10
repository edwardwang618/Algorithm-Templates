package linear.linkedlist.singlely;

public class SingleLinkedList {
    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        linkedList.addFirst(1);
        linkedList.addLast(2);
        linkedList.addLast(2);
        System.out.println(linkedList);
        System.out.println(linkedList.size());
        
        linkedList.deleteFirst();
        System.out.println(linkedList);
        System.out.println(linkedList.size());
        
        linkedList.deleteFirst();
        linkedList.deleteFirst();
        System.out.println(linkedList);
    }
}

class LinkedList {
    
    private final ListNode dummy = new ListNode(0);
    private ListNode tail = dummy;
    private int size;
    
    public void addFirst(int x) {
        if (size == 0) {
            addLast(x);
            return;
        }
        
        ListNode node = new ListNode(x);
        node.next = dummy.next;
        dummy.next = node;
        
        size++;
    }
    
    public void addLast(int x) {
        tail.next = new ListNode(x);
        tail = tail.next;
        
        size++;
    }
    
    public void deleteFirst() {
        deleteAfter(dummy);
    }
    
    // in a singly linkedlist, if you want to delete a node,
    // you have to know its predecessor
    // in this method, we are delete node.next
    private void deleteAfter(ListNode node) {
        if (node.next == null) {
            throw new RuntimeException("Illegal delte");
        }
        
        node.next = node.next.next;
        if (node.next == null) {
            tail = node;
        }
        
        size--;
    }
    
    public int size() {
        return size;
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        if (size != 0) {
            ListNode cur = dummy.next;
            while (cur != null) {
                sb.append(cur.x).append("->");
                cur = cur.next;
            }
        
            sb.setLength(sb.length() - 2);
        }
        
        sb.append("}");
        return sb.toString();
    }
}

class ListNode {
    // its value
    int x;
    // the successor location
    ListNode next;
    
    public ListNode(int x) {
        this.x = x;
    }
}