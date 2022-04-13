package inflearn.chapter7.solution11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

// 13. 경로탐색(인접리스트, ArrayList) - 정점갯수가 많을 경우에 사용
//5 9
//1 2
//1 3
//1 4
//2 1
//2 3
//2 5
//3 4
//4 2
//4 5
public class Solution13 {
  static int n = 0;
  static int m = 0;
  static int answer = 0;
  static List<List<Integer>> graph;
  static int[] checks;

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
    for (int i = 0; i < m; i++) {
      String[] coordinates = br.readLine().split(" ");
      int a = Integer.parseInt(coordinates[0]);
      int b = Integer.parseInt(coordinates[1]);
      graph.get(a).add(b);
    }
    checks[1] = 1;
    dfs(1);
    System.out.println(answer);
  }

  private static void dfs(int v) {
    if (v == n) {
      answer++;
    } else {
      for (int nv : graph.get(v)) {
        if (checks[nv] == 0) {
          checks[nv] = 1;
          dfs(nv);
          checks[nv] = 0;
        }
      }
    }
  }
}
