/**
 * Definition for singly-linked list.
 * function ListNode(val) {
 *     this.val = val;
 *     this.next = null;
 * }
 */

/**
 * test-case
 * 1. head = [3, 2, 0, -4] // pos = 1
 * 2. head = [1, 2] // pos = 0
 * 3. head = [1] // pos = -1
 */

function hasCycle(head) {
  if (!head || !head.next) {
    return false;
  }

  let slow = head;
  let fast = head;

  while (fast && fast.next) {
    slow = slow.next;
    fast = fast.next.next;

    if (slow === fast) {
      return true;
    }
  }

  return false;
}
