package inflearn.chapter9.solution8;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

class Edge implements Comparable<Edge> {

  int vex;
  int cost;

  public Edge(int vex, int cost) {
    this.vex = vex;
    this.cost = cost;
  }
  
  @Override
  public int compareTo(Edge o) {
    return this.cost - o.cost;
  }
}

// 8. 원더랜드(프림: PriorityQueue)
//9 12
//1 2 12
//1 9 25
//2 3 10
//2 8 17
//2 9 8
//3 4 18
//3 7 55
//4 5 44
//5 6 60
//5 7 38
//7 8 35
//8 9 15
public class Solution8 {

  static int[] checks;

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int m = sc.nextInt();
    List<List<Edge>> graph = new ArrayList<>();
    for (int i = 0; i <= n; i++) {
      graph.add(new ArrayList<>());
    }
    checks = new int[n + 1];
    for (int i = 0; i < m; i++) {
      int start = sc.nextInt();
      int end = sc.nextInt();
      int cost = sc.nextInt();
      graph.get(start).add(new Edge(end, cost));
      graph.get(end).add(new Edge(start, cost));
    }

    System.out.println(solution(graph));
  }

  private static int solution(List<List<Edge>> graph) {
    int answer = 0;
    PriorityQueue<Edge> pq = new PriorityQueue<>();
    pq.offer(new Edge(1, 0));

    while (!pq.isEmpty()) {
      Edge tmp = pq.poll();
      int endVex = tmp.vex;
      if (checks[endVex] == 0) { // 회로 방지 체크
        checks[endVex] = 1;
        answer += tmp.cost;
        for (Edge eg : graph.get(endVex)) {
          if (checks[eg.vex] == 0) { // 중복 간선 체크
            pq.offer(new Edge(eg.vex, eg.cost));
          }
        }
      }
    }
    return answer;
  }
}
