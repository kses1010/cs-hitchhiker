package inflearn.chapter7.solution10;

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

// 10. Tree 말단노드까지의 가장 짧은 경로(BFS)
public class Solution10 {
  Node root;

  public int bfs(Node root) {
    Queue<Node> q = new LinkedList<>();
    q.offer(root);
    int L = 0;

    while (!q.isEmpty()) {
      int len = q.size();
      for (int i = 0; i < len; i++) {
        Node cur = q.poll();
        if (cur.lt == null && cur.rt == null) {
          return L;
        }
        if (cur.lt != null) {
          q.offer(cur.lt);
        }
        if (cur.rt != null) {
          q.offer(cur.rt);
        }
      }
      L++;
    }
    return 0;
  }

  public static void main(String[] args) {
    Solution10 tree = new Solution10();
    tree.root = new Node(1);
    tree.root.lt = new Node(2);
    tree.root.rt = new Node(3);
    tree.root.lt.lt = new Node(4);
    tree.root.lt.rt = new Node(5);
    System.out.println(tree.bfs(tree.root));
  }
}
