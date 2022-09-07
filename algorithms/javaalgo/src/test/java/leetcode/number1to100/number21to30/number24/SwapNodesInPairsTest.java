package leetcode.number1to100.number21to30.number24;

import leetcode.util.ListNode;

public class SwapNodesInPairsTest {

    public ListNode swapPairsWhile(ListNode head) {
        ListNode root = new ListNode();
        ListNode prev = root;
        prev.next = head;

        while (head != null && head.next != null) {
            ListNode b = head.next;
            head.next = b.next;
            b.next = head;
            prev.next = b;

            // 이동
            head = head.next;
            prev = prev.next.next;
        }
        return root.next;
    }

    public ListNode swapPair(ListNode head) {
        if (head != null && head.next != null) {
            ListNode p = head.next;
            // 스왑된 값 리턴
            head.next = swapPair(p.next);
            p.next = head;
            return p;
        }
        return head;
    }
}
