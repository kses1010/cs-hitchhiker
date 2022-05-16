package inflearn.chapter9.solution7;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

class Edge implements Comparable<Edge> {
  int start;
  int end;
  int cost;

  public Edge(int start, int end, int cost) {
    this.start = start;
    this.end = end;
    this.cost = cost;
  }

  @Override
  public int compareTo(Edge o) {
    return this.cost - o.cost; // 오름차순
  }
}

// 7. 원더랜드(크루스칼, Union & Find 활용)
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
public class Solution7 {

  static int[] unf;
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int m = sc.nextInt();
    unf = new int[n + 1];
    List<Edge> arr = new ArrayList<>();
    for (int i = 0; i <= n; i++) {
      unf[i] = i;
    }
    for (int i = 0; i < m; i++) {
      int start = sc.nextInt();
      int end = sc.nextInt();
      int cost = sc.nextInt();
      arr.add(new Edge(start, end, cost));
    }

    System.out.println(solution(arr));
  }

  private static int solution(List<Edge> arr) {
    int answer = 0;
    Collections.sort(arr);
    for (Edge eg : arr) {
      int findV1 = find(eg.start);
      int findV2 = find(eg.end);
      if (findV1 != findV2) {
        answer += eg.cost;
        union(findV1, findV2);
      }
    }
    return answer;
  }

  private static void union(int a, int b) {
    int fa = find(a);
    int fb = find(b);
    if (fa != fb) unf[fa] = fb;
  }

  private static int find(int v) {
    if (v == unf[v]) {
      return v;
    }
    return unf[v] = find(unf[v]);
  }
}
