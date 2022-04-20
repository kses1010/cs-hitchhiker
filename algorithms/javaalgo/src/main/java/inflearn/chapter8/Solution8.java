package inflearn.chapter8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 8. 수열 추측하기
// 4 16
public class Solution8 {
  static int n;
  static int f;
  static boolean flag = false;
  static int[] b;
  static int[] p;
  static int[] checks;
  static int[][] dy = new int[100][100];

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] splits = br.readLine().split(" ");
    n = Integer.parseInt(splits[0]);
    f = Integer.parseInt(splits[1]);
    b = new int[n];
    p = new int[n];
    checks = new int[n + 1];
    for (int i = 0; i < n; i++) {
      b[i] = combi(n - 1, i);
    }

    dfs(0, 0);
  }

  private static int combi(int n, int r) {
    if (dy[n][r] > 0) {
      return dy[n][r];
    }
    if (n == r || r == 0) {
      return 1;
    } else {
      return dy[n][r] = combi(n - 1, r - 1) + combi(n - 1, r);
    }
  }

  private static void dfs(int L, int sum) {
    if (flag) {
      return;
    }
    if (L == n) {
      if (sum == f) {
        for (int x : p) {
          System.out.print(x + " ");
        }
        flag = true;
      }
    } else {
      for (int i = 1; i <= n; i++) {
        if (checks[i] == 0) {
          checks[i] = 1;
          p[L] = i;
          dfs(L + 1, sum + (p[L] * b[L]));
          checks[i] = 0;
        }
      }
    }
  }
}
