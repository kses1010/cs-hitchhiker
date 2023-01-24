package leetcode.number101to200.number101to110.number102;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import leetcode.util.TreeNode;

public class BinaryTreeLevelOrderTraversal {

    List<List<Integer>> answers = new ArrayList<>();

    public List<List<Integer>> levelOrderDfs(TreeNode root) {
        if (root == null) {
            return answers;
        }
        dfs(root, 0);
        return answers;
    }

    public void dfs(TreeNode root, int L) {
        if (root == null) {
            return;
        }

        List<Integer> cur;
        if (L >= answers.size()) {
            cur = new ArrayList<>();
            cur.add(root.val);
            answers.add(cur);
        } else {
            cur = answers.get(L);
            cur.add(root.val);
        }
        dfs(root.left, L + 1);
        dfs(root.right, L + 1);
    }

    public List<List<Integer>> levelOrderBfs(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        if (root == null) {
            return answers;
        }
        q.add(root);

        while (!q.isEmpty()) {
            int size = q.size();
            List<Integer> row = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode cur = q.poll();
                row.add(cur.val);
                if (cur.left != null) {
                    q.add(cur.left);
                }
                if (cur.right != null) {
                    q.add(cur.right);
                }
            }
            answers.add(row);
        }
        return answers;
    }
}
