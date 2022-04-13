package inflearn.chapter7.solution11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 12. 경로탐색(DFS)
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
public class Solution12 {
  static int n = 0;
  static int m = 0;
  static int answer = 0;
  static int[][] graph;
  static int[] checks;


  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] splits = br.readLine().split(" ");
    n = Integer.parseInt(splits[0]);
    m = Integer.parseInt(splits[1]);
    graph = new int[n + 1][n + 1];
    checks = new int[n + 1];
    for (int i = 0; i < m; i++) {
      String[] coordinates = br.readLine().split(" ");
      int a = Integer.parseInt(coordinates[0]);
      int b = Integer.parseInt(coordinates[1]);
      graph[a][b] = 1;  // a -> b 간다는 뜻
    }
    checks[1] = 1;
    dfs(1);
    System.out.println(answer);
  }

  private static void dfs(int v) {
    if (v == n) {
      answer++;
    } else {
      for (int i = 1; i <= n; i++) {
        if (graph[v][i] == 1 && checks[i] == 0) {
          checks[i] = 1;
          dfs(i);
          checks[i] = 0;
        }
      }
    }
  }
}
