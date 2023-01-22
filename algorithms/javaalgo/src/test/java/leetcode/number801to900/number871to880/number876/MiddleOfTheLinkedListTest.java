package leetcode.number801to900.number871to880.number876;

import leetcode.util.ListNode;

public class MiddleOfTheLinkedListTest {

    public ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
