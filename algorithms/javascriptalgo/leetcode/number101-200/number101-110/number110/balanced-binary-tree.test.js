/**
 * Definition for a binary tree node.
 * function TreeNode(val, left, right) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.left = (left===undefined ? null : left)
 *     this.right = (right===undefined ? null : right)
 * }
 */
/**
 * @param {TreeNode} root
 * @return {boolean}
 */
const isBalanced = function(root) {
  let answer = true;

  const maxDepth = (root) => {
    if (!answer) return 0;
    if (!root) return 0;

    let left = maxDepth(root.left);
    let right = maxDepth(root.right);
    if (Math.abs(left - right) > 1) {
      answer = false;
    }
    return Math.max(left, right) + 1;
  }

  maxDepth(root);
  return answer;
};
