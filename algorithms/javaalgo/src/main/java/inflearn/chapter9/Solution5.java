package inflearn.chapter9;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

class Edge implements Comparable<Edge> {

  int vex; // 정점
  int cost; // 비용

  public Edge(int vex, int cost) {
    this.vex = vex;
    this.cost = cost;
  }

  @Override
  public int compareTo(Edge o) {
    return this.cost - o.cost;
  }
}

// 5. 다익스트라 알고리즘
//
public class Solution5 {

  static int n;
  static int m;
  static List<List<Edge>> graph;
  static int[] dist;

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    n = sc.nextInt();
    m = sc.nextInt();
    graph = new ArrayList<>();
    for (int i = 0; i <= n; i++) {
      graph.add(new ArrayList<>());
    }
    dist = new int[n + 1];
    Arrays.fill(dist, Integer.MAX_VALUE);
    for (int i = 0; i < m; i++) {
      int start = sc.nextInt();
      int end = sc.nextInt();
      int cost = sc.nextInt();
      graph.get(start).add(new Edge(end, cost));
    }
    solution(1);
    for (int i = 2; i <= n; i++) {
      if (dist[i] != Integer.MAX_VALUE) {
        System.out.println(i + " : " + dist[i]);
      } else {
        System.out.println(i + " : impossible");
      }
    }
  }

  private static void solution(int v) {
    PriorityQueue<Edge> pq = new PriorityQueue<>();
    pq.offer(new Edge(v, 0));
    dist[v] = 0;
    while (!pq.isEmpty()) {
      Edge tmp = pq.poll();
      int now = tmp.vex;
      int nowCost = tmp.cost;
      if (nowCost > dist[now]) continue; // PQ에서 뽑은 값이 체크 배열값보다 클경우 그 이후 코드 무시

      for (Edge ob : graph.get(now)) {
        int totalCost = nowCost + ob.cost;
        if (dist[ob.vex] > totalCost) {
          dist[ob.vex] = totalCost;
          pq.offer(new Edge(ob.vex, totalCost));
        }
      }
    }
  }
}
