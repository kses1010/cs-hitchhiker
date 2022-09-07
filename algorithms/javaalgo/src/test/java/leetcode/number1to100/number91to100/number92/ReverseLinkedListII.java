package leetcode.number1to100.number91to100.number92;

import leetcode.util.ListNode;

public class ReverseLinkedListII {

    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || left == right) {
            return head;
        }

        ListNode root = new ListNode();
        ListNode start = root;
        root.next = head;

        // start, end 시점
        for (int i = 0; i < left - 1; i++) {
            start = start.next;
        }
        ListNode end = start.next;

        for (int i = right; i < left; i++) {
            ListNode tmp = start.next;
            start.next = end.next;
            end.next = end.next.next;
            start.next.next = tmp;
        }
        return root.next;
    }

    public ListNode reverseBetween2(ListNode head, int left, int right) {
        if (head == null) {
            return null;
        }
        ListNode root = new ListNode();
        root.next = head;
        ListNode prev = root;
        for (int i = 0; i < left - 1; i++) {
            prev = prev.next;
        }

        ListNode start = prev.next;
        ListNode end = start.next;

        // 1 -> 2 -> 3 -> 4 -> 5 ; (left = 2, right = 4) prev = 1, start = 2, end = 3
        // root -> 1 -> 2 -> 3 -> 4 -> 5
        for (int i = 0; i < right - left; i++) {
            start.next = end.next;
            end.next = prev.next;
            prev.next = end;
            end = start.next;
        }
        // first reversing : root -> 1 - 3 - 2 - 4 - 5; pre = 1, start = 2, end = 4
        // second reversing: root -> 1 - 4 - 3 - 2 - 5; pre = 1, start = 2, end = 5 (finish)
        return root.next;
    }
}
