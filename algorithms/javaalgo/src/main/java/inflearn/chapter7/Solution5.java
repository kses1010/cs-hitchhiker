package inflearn.chapter7;

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

// 5. 이진트리순회(DFS: Depth-First Search)
public class Solution5 {
  Node root;

  public void dfs(Node root) {
    if (root == null) {
      return;
    } else {
//      System.out.print(root.data + " "); // 전위순회
      dfs(root.lt);
//      System.out.print(root.data + " "); // 중위순회
      dfs(root.rt);
      System.out.print(root.data + " "); // 후위순회
    }
  }

  public static void main(String[] args) {
    Solution5 tree = new Solution5();
    tree.root = new Node(1);
    tree.root.lt = new Node(2);
    tree.root.rt = new Node(3);
    tree.root.lt.lt = new Node(4);
    tree.root.lt.rt = new Node(5);
    tree.root.rt.lt = new Node(6);
    tree.root.rt.rt = new Node(7);
    tree.dfs(tree.root);
  }
}
