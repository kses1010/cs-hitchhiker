package leetcode.number201to300.number221to230.number226;

import leetcode.util.TreeNode;

public class InvertBinaryTreeTest {

    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }

        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        root.left = right;
        root.right = left;

        return root;
    }
}
