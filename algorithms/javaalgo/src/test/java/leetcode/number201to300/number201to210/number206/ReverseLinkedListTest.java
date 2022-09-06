package leetcode.number201to300.number201to210.number206;

import leetcode.util.ListNode;

public class ReverseLinkedListTest {

    public ListNode reverseList(ListNode head) {
        return reverse(head, null);
    }

    private ListNode reverse(ListNode node, ListNode prev) {
        if (node == null) {
            return prev;
        }
        ListNode next;
        next = node.next;
        node.next = prev;
        return reverse(next, node);
    }
}
