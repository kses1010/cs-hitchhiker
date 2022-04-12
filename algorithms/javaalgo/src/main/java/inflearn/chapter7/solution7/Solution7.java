package inflearn.chapter7.solution7;

import java.util.LinkedList;
import java.util.Queue;

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

  // 7. 이진트리 레벨탐색(BFS : Breadth-First Search)
  public class Solution7 {
    Node root;
    public void bfs(Node root) {
      Queue<Node> q = new LinkedList<>();
      q.offer(root);
      int l = 0;
      while (!q.isEmpty()) {
        int len = q.size();
        System.out.print(l + " : ");
        for (int i = 0; i < len; i++) {
          Node cur = q.poll();
          System.out.print(cur.data + " ");
          if (cur.lt != null) {
            q.offer(cur.lt);
          }
          if (cur.rt != null) {
            q.offer(cur.rt);
          }
        }
        l++;
        System.out.println();
      }
    }

    public static void main(String[] args) {
      Solution7 tree = new Solution7();
      tree.root = new Node(1);
      tree.root.lt = new Node(2);
      tree.root.rt = new Node(3);
      tree.root.lt.lt = new Node(4);
      tree.root.lt.rt = new Node(5);
      tree.root.rt.lt = new Node(6);
      tree.root.rt.rt = new Node(7);
      tree.bfs(tree.root);
    }
}

