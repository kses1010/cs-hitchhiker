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
 * @return {number}
 */
const diameterOfBinaryTree = function(root) {
  let distance = 0;

  const dfs = (node) => {
    if (!node) return 0;

    let left = dfs(node.left);
    let right = dfs(node.right);

    distance = Math.max(distance, left + right);

    return Math.max(left, right) + 1;
  }

  dfs(root);
  return distance;
};
