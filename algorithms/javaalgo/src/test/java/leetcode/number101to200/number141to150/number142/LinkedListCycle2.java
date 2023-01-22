package leetcode.number101to200.number141to150.number142;

import leetcode.util.ListNode;

public class LinkedListCycle2 {

    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null; // no Cycle
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                while (head != slow) {
                    slow = slow.next;
                    head = head.next;
                }
                return head;
            }
        }
        return null;
    }
}
