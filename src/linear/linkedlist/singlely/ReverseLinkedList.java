package linear.linkedlist.singlely;

public class ReverseLinkedList {
    public static void main(String[] args) {
        ListNode res1 = null, res2 = null;
        ListNode head = null;
        System.out.println(reverseNonRecursion(head) == reverseRecursion(head));
        
        head = new ListNode(1);
        res1 = reverseNonRecursion(head);
        res2 = reverseRecursion(head);
        
        // printList(res1);
        // printList(res2);
        
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        // res1 = reverseNonRecursion(head);
        res2 = reverseRecursion(head);
        // printList(res1);
        printList(res2);
    }
    
    // reverse the linkedlist of head and return the first node of the new list
    public static ListNode reverseNonRecursion(ListNode head) {
        // prev is the head of the new reversed linked list
        ListNode prev = null, tmp = null;
        // every loop, add the node to the beginning of the new list, and maintain
        // the definition of prev
        while (head != null) {
            tmp = head.next;
            head.next = prev;
            prev = head;
            head = tmp;
        }
        
        return prev;
    }
    
    // reverse the linkedlist of head and return the first node of the new list
    public static ListNode reverseRecursion(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        
        ListNode res = reverseRecursion(head.next);
        // ...
        head.next.next = head;
        head.next = null;
        return res;
    }
    
    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.x);
            if (head.next != null) {
                System.out.print("->");
            }
            head = head.next;
        }
        
        System.out.println();
    }
}
