package leetcode.number301to400.number321to330.number328;

import leetcode.util.ListNode;

public class OddEvenLinkedList {

    public ListNode oddEvenList(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode odd = head;
        ListNode even = head.next;
        ListNode evenHead = head.next;

        while (even != null && even.next != null) {
            odd.next = odd.next.next;
            even.next = even.next.next;

            // 이동
            odd = odd.next;
            even = even.next;
        }

        odd.next = evenHead;
        return head;
    }
}
