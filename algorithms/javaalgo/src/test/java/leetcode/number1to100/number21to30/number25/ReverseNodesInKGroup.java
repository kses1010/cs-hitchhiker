package leetcode.number1to100.number21to30.number25;

import leetcode.util.ListNode;

public class ReverseNodesInKGroup {

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode node = head;
        int count = 0;

        while (count < k) {
            if (node == null) {
                return head;
            }
            node = node.next;
            count++;
        }

        ListNode prev = reverseKGroup(node, k);
        while (count > 0) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
            count--;
        }
        return prev;
    }
}
