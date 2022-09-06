package leetcode.number201to300.number231to240.number234;

import java.util.Deque;
import java.util.LinkedList;
import leetcode.util.ListNode;
import org.junit.jupiter.api.Test;

public class PalindromeLinkedListTest {

    @Test
    void test() {

    }

    public boolean isPalindrome(ListNode head) {
        Deque<Integer> q = new LinkedList<>();
        if (head == null) {
            return true;
        }

        ListNode node = head;
        while (node != null) {
            q.add(node.val);
            node = node.next;
        }

        while (q.size() > 1) {
            int left = q.pollFirst();
            int right = q.pollLast();
            if (left != right) {
                return false;
            }
        }
        return true;
    }
}
