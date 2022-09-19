package leetcode.number1to100.number21to30.number23;

import java.util.Comparator;
import java.util.PriorityQueue;
import leetcode.util.ListNode;

public class MergeKSortedListsTest {

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }

        // val 오름차순 우선순위 큐
        PriorityQueue<ListNode> pq = new PriorityQueue<>((Comparator.comparingInt(o -> o.val)));
        ListNode root = new ListNode();
        ListNode head = root;

        for (ListNode node : lists) {
            if (node != null) {
                pq.add(node);
            }
        }

        while (!pq.isEmpty()) {
            head.next = pq.poll();
            head = head.next;

            if (head.next != null) {
                pq.add(head.next);
            }
        }

        return root.next;
    }
}
