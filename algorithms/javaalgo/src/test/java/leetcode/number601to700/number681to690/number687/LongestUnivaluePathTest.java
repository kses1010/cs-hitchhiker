package leetcode.number601to700.number681to690.number687;

import leetcode.util.TreeNode;

public class LongestUnivaluePathTest {

    int answer = 0;

    public int longestUnivaluePath(TreeNode root) {
        dfs(root);
        return answer;
    }

    public int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = dfs(root.left);
        int right = dfs(root.right);

        if (root.left != null && root.left.val == root.val) {
            left++;
        } else {
            left = 0;
        }
        if (root.right != null && root.right.val == root.val) {
            right++;
        } else {
            right = 0;
        }

        answer = Math.max(answer, left + right);

        return Math.max(left, right);
    }
}
