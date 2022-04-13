package inflearn.chapter7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// 14. 그래프 최단거리(BFS)
//6 9
//1 3
//1 4
//2 1
//2 5
//3 4
//4 5
//4 6
//6 2
//6 5
public class Solution14 {
  static int n = 0;
  static int m = 0;
  static List<List<Integer>> graph;
  static int[] checks;
  static int[] dist;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] splits = br.readLine().split(" ");
    n = Integer.parseInt(splits[0]);
    m = Integer.parseInt(splits[1]);
    graph = new ArrayList<>();
    for (int i = 0; i <= n; i++) {
      graph.add(new ArrayList<>());
    }
    checks = new int[n + 1];
    dist = new int[n + 1];
    for (int i = 0; i < m; i++) {
      String[] coordinates = br.readLine().split(" ");
      int a = Integer.parseInt(coordinates[0]);
      int b = Integer.parseInt(coordinates[1]);
      graph.get(a).add(b);
    }

    bfs(1);
    for (int i = 2; i <= n; i++) {
      System.out.println(i + " : " + dist[i]);
    }
  }

  private static void bfs(int v) {
    Queue<Integer> q = new LinkedList<>();
    checks[v] = 1;
    dist[v] = 1;
    q.offer(v);

    while (!q.isEmpty()) {
      int cv = q.poll();
      for (int nv : graph.get(cv)) {
        if (checks[nv] == 0) {
          checks[nv] = 1;
          q.offer(nv);
          dist[nv] = dist[cv] + 1;
        }
      }
    }
  }
}
