package leetcode.number101to200.number101to110.number110;

import leetcode.util.TreeNode;

public class BalancedBinaryTreeTest {

    private boolean answer = true;

    public boolean isBalanced(TreeNode root) {
        maxDepth(root);
        return answer;
    }

    private int maxDepth(TreeNode root) {
        if (!answer) {
            return 0;
        }
        if (root == null) {
            return 0;
        }
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        if (Math.abs(left - right) > 1) {
            answer = false;
        }

        return Math.max(left, right) + 1;
    }
}
