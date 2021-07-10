package linear.linkedlist.singlely;

public class FindMiddle {
    public static void main(String[] args) {
        ListNode head = null;
        System.out.println(findMiddle(head));
        
        head = new ListNode(1);
        System.out.println(findMiddle(head).x);
        
        head.next = new ListNode(2);
        System.out.println(findMiddle(head).x);
        
        head.next.next = new ListNode(3);
        System.out.println(findMiddle(head).x);
        
        head.next.next.next = new ListNode(4);
        System.out.println(findMiddle(head).x);
        
        head.next.next.next.next = new ListNode(5);
        System.out.println(findMiddle(head).x);
    }
    
    // two pointers on linkedlist
    //         s     f
    // d->  1->2->3->4->null
    public static ListNode findMiddle(ListNode head) {
        if (head == null) {
            return null;
        }
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode slow = dummy, fast = dummy;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        return slow;
    }
}
