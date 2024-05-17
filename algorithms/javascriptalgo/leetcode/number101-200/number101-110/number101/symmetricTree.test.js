//  Definition for a binary tree node.
function TreeNode(val, left, right) {
  this.val = (val === undefined ? 0 : val)
  this.left = (left === undefined ? null : left)
  this.right = (right === undefined ? null : right)
}

/**
 * @param {TreeNode} root
 * @return {boolean}
 */
function isSymmetric(root) {
  if (!root) return true;
  return isSymmetricHelper(root.left, root.right);
}

const isSymmetricHelper = (left, right) => {
  if (!left && !right) return true;
  if (!left || !right) return false;
  if (left.val !== right.val) return false;

  return isSymmetricHelper(left.left, right.right) && isSymmetricHelper(left.right, right.left);
}
