package leetcode.number501to600.number541to550.number543;

import leetcode.util.TreeNode;

public class DiameterOfBinaryTreeTest {

    int distance = 0;

    public int diameterOfBianryTree(TreeNode node) {
        dfs(node);
        return distance;
    }

    private int dfs(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int left = dfs(node.left);
        int right = dfs(node.right);

        distance = Math.max(distance, left + right);

        return Math.max(left, right) + 1;
    }
}
