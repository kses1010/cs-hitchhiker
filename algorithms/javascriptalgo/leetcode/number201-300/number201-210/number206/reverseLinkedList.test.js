/**
 * Definition for singly-linked list.
 * function ListNode(val, next) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.next = (next===undefined ? null : next)
 * }
 */
/**
 * @param {ListNode} head
 * @return {ListNode}
 */
const reverseList = function(head) {
  const reverse = (node, prev) => {
    if (!node) return prev;

    let next = node.next;
    node.next = prev;
    return reverse(next, node);
  }

  return reverse(head, null);
};
