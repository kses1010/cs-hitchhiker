// Definition for singly-linked list.
function ListNode(val, next) {
  this.val = (val === undefined ? 0 : val)
  this.next = (next === undefined ? null : next)
}

function addTwoNumbers(l1, l2) {
  let root = new ListNode(0);
  let head = root;
  let carry = 0;

  while (l1 !== null || l2 !== null || carry !== 0) {
    let v1 = (l1 !== null) ? l1.val : 0;
    let v2 = (l2 !== null) ? l2.val : 0;

    let sum = v1 + v2 + carry;

    carry = Math.floor(sum / 10);

    haed.next = new ListNode(sum % 10);
    head = head.next;

    if (l1 !== null) {
      l1 = l1.next;
    }
    if (l2 !== null) {
      l2 = l2.next;
    }
  }
  return root.next;
}
