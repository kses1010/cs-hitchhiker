package leetcode.number1to100.number1to10.number2;

import leetcode.util.ListNode;

public class AddTwoNumbersTest {

    public ListNode addtwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode root = head;
        int carry = 0;

        while (l1 != null || l2 != null || carry != 0) {
            int x = (l1 != null) ? l1.val : 0;
            int y = (l2 != null) ? l2.val : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            root.next = new ListNode(sum % 10);
            root = root.next;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        return head.next;
    }
}
