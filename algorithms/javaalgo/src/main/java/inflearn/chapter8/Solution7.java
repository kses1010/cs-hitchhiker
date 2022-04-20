package inflearn.chapter8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 7. 조합의 경우수(메모이제이션)
public class Solution7 {
  static int[][] dy = new int[35][35];

  public static void main(String[] args) throws IOException {
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
