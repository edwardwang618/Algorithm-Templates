package linear.linkedlist.singlely;

public class MergeSort {
    public static void main(String[] args) {
        ListNode head = new ListNode(2);
        head.next = new ListNode(1);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(5);
        head.next.next.next.next = new ListNode(0);
        head.next.next.next.next.next = new ListNode(-1);
        head.next.next.next.next.next.next = new ListNode(7);
        
        head = mergeSort(head);
        
        printList(head);
    }
    
    public static ListNode mergeSort(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        
        ListNode l1 = head, mid = findMid(head), l2 = mid.next;
        mid.next = null;
        
        l1 = mergeSort(l1);
        l2 = mergeSort(l2);
        
        ListNode dummy = new ListNode(0), prev = dummy;
        
        while (l1 != null || l2 != null) {
            if (l1 == null) {
                prev.next = l2;
                break;
            } else if (l2 == null) {
                prev.next = l1;
                break;
            } else {
                if (l1.x < l2.x) {
                    prev.next = l1;
                    l1 = l1.next;
                } else {
                    prev.next = l2;
                    l2 = l2.next;
                }
                
                prev = prev.next;
            }
        }
        
        return dummy.next;
    }
    
    private static ListNode findMid(ListNode head) {
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
    
    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.x);
            if (head.next != null) {
                System.out.print(" -> ");
            }
            
            head = head.next;
        }
        
        System.out.println();
    }
}
