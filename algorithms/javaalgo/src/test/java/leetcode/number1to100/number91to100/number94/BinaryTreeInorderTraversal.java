package leetcode.number1to100.number91to100.number94;

import java.util.ArrayList;
import java.util.List;
import leetcode.util.TreeNode;

public class BinaryTreeInorderTraversal {

    static List<Integer> nums;

    public List<Integer> inorderTraversal(TreeNode root) {
        nums = new ArrayList<>();
        inorder(root);
        return nums;
    }

    public void inorder(TreeNode root) {
        if (root == null) {
            return;
        }
        inorder(root.left);
        nums.add(root.val);
        inorder(root.right);
    }
}
