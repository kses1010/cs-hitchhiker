package inflearn.chapter7.solution9;

class Node {
  int data;
  Node lt;
  Node rt;

  public Node(int value) {
    data = value;
    lt = null;
    rt = null;
  }
}


// 9. Tree 말단노드까지의 가장 짧은 경로(DFS)
public class Solution9 {
  Node root;

  public int dfs(int L, Node root) {
    if (root.lt == null && root.rt == null) {
      return L;
    } else {
      return Math.min(dfs(L + 1, root.lt), dfs(L + 1, root.rt));
    }
  }

  public static void main(String[] args) {
    Solution9 tree = new Solution9();
    tree.root = new Node(1);
    tree.root.lt = new Node(2);
    tree.root.rt = new Node(3);
    tree.root.lt.lt = new Node(4);
    tree.root.lt.rt = new Node(5);
    System.out.println(tree.dfs(0, tree.root));
  }
}
