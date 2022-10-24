package leetcode.number101to200.number101to110.number104;

import leetcode.util.TreeNode;

public class MaximumDepthOfBinaryTreeTest {

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);

        return Math.max(left, right) + 1;
    }
}
