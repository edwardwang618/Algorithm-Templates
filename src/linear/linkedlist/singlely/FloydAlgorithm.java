package linear.linkedlist.singlely;

public class FloydAlgorithm {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = head.next.next.next;
        // head.next.next.next.next = null;
    
        System.out.println(findLoop(head));
        System.out.println(findEntry(head).x);
    }
    
    static boolean findLoop(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        ListNode slow = dummy, fast = dummy;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        
        return false;
    }
    
    static ListNode findEntry(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
    
        ListNode slow = dummy, fast = dummy;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                break;
            }
        }
        
        if (slow != fast) {
            return null;
        }
        
        ListNode tmp = dummy;
        while (tmp != slow) {
            tmp = tmp.next;
            slow = slow.next;
        }
        
        return slow;
    }
}
