package inflearn.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AlgorithumUtils {

  // 2차원 배열
  private static void twoDArr() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int[][] arr = new int[n][n];

    for (int i = 0; i < n; i++) {
      String[] str = br.readLine().split(" ");
      for (int j = 0; j < n; j++) {
        arr[i][j] = Integer.parseInt(str[j]);
      }
    }
  }

  // 조합(메모이제이션)
  static int[][] dy = new int[35][35];

  private static void combi() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] splits = br.readLine().split(" ");
    int n = Integer.parseInt(splits[0]);
    int r = Integer.parseInt(splits[1]);

    System.out.println(dfs(n, r));
  }

  private static int dfs(int n, int r) {
    if (dy[n][r] > 0) {
      return dy[n][r];
    }
    if (n == r || r == 0) {
      return 1;
    } else {
      return dy[n][r] = dfs(n - 1, r - 1) + dfs(n - 1, r);
    }
  }
}
