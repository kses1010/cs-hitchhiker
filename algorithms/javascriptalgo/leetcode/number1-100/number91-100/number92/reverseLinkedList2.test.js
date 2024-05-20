//  Definition for singly-linked list.
function ListNode(val, next) {
  this.val = (val === undefined ? 0 : val);
  this.next = (next === undefined ? null : next);
}

/**
 * @param {ListNode} head
 * @param {number} left
 * @param {number} right
 * @return {ListNode}
 */
function reverseBetween(head, left, right) {
  if (!head || left === right) {
    return head;
  }

  let root = new ListNode();
  let start = root;
  root.next = head;

  // 출발지 선택
  for (let i = 0; i < left - 1; i++) {
    start = start.next;
  }

  let end = start.next;

  for (let i = 0; i < right - left; i++) {
    let tmp = start.next;
    start.next = end.next;
    end.next = end.next.next;
    start.next.next = tmp;
  }

  return root.next;
}
