package leetcode.number501to600.number581to590.number589;

import java.util.ArrayList;
import java.util.List;
import leetcode.util.Node;

public class NAryTreePreorderTraversal {

    List<Integer> answers = new ArrayList<>();

    public List<Integer> preorder(Node root) {
        if (root == null) {
            return answers;
        }
        answers.add(root.val);
        for (Node child : root.children) {
            preorder(child);
        }
        return answers;
    }
}
