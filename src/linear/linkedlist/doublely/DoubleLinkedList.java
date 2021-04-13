package linear.linkedlist.doublely;

public class DoubleLinkedList {
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
        
        linkedList.addFirst(3);
        linkedList.addLast(4);
        System.out.println(linkedList);
        System.out.println(linkedList.size());
    
        System.out.println(linkedList.deleteFirstOccurrence(2));
        System.out.println(linkedList);
        System.out.println(linkedList.size());
        
        linkedList.deleteLast();
        linkedList.deleteLast();
        System.out.println(linkedList);
        linkedList.deleteFirst();
        System.out.println(linkedList);
        System.out.println(linkedList.size());
    }
}

class LinkedList {
    
    private ListNode head, tail;
    private int size;
    
    public void addFirst(int x) {
        if (size == 0) {
            head = tail = new ListNode(x);
        } else {
            head.prev = new ListNode(x);
            head.prev.next = head;
            head = head.prev;
        }
        
        size++;
    }
    
    public void addLast(int x) {
        if (size == 0) {
            addFirst(x);
            return;
        }
        
        tail.next = new ListNode(x);
        tail.next.prev = tail;
        tail = tail.next;
        
        size++;
    }
    
    public void deleteFirst() {
        if (size == 0) {
            throw new RuntimeException("Illegal delete");
        }
        
        if (size == 1) {
            head = tail = null;
        } else {
            head = head.next;
            head.prev.next = null;
            head.prev = null;
        }
        
        size--;
    }
    
    public void deleteLast() {
        if (size == 0) {
            throw new RuntimeException("Illegal delete");
        }
    
        if (size == 1) {
            head = tail = null;
        } else {
            tail = tail.prev;
            tail.next.prev = null;
            tail.next = null;
        }
        
        size--;
    }
    
    public boolean deleteFirstOccurrence(int x) {
        if (size == 0) {
            return false;
        }
    
        if (head.x == x) {
            deleteFirst();
            return true;
        }
        
        ListNode cur = head;
        while (cur != tail) {
            if (cur.x == x) {
                deleteInBetween(cur);
                return true;
            }
            
            cur = cur.next;
        }
    
        if (tail.x == x) {
            deleteLast();
            return true;
        }
        
        return false;
    }
    
    private void deleteInBetween(ListNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
        node.prev = node.next = null;
        
        size--;
    }
    
    public int size() {
        return size;
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        if (size != 0) {
            ListNode cur = head;
            while (cur != null) {
                sb.append(cur.x).append("<->");
                cur = cur.next;
            }
    
            sb.setLength(sb.length() - 3);
        }
        
        sb.append("}");
        return sb.toString();
    }
}

class ListNode {
    int x;
    ListNode prev, next;
    
    public ListNode(int x) {
        this.x = x;
    }
}