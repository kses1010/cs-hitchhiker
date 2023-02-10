package leetcode.number101to200.number141to150.number141;

import leetcode.util.ListNode;

// Cycle Detection
// 플로이드의 토끼와 거북이 풀이법
public class LinkedListCycle {

    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                return true;
            }
        }
        return false;
    }
}
