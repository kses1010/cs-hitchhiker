package inflearn.chapter8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 4. 중복순열
//3 2
public class Solution4 {
  static int n;
  static int m;
  static int[] pm;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] splits = br.readLine().split(" ");
    n = Integer.parseInt(splits[0]);
    m = Integer.parseInt(splits[1]);
    pm = new int[m];

    dfs(0);
  }

  private static void dfs(int L) {
    if (L == m) {
      for (int x : pm) {
        System.out.print(x + " ");
      }
      System.out.println();
    } else {
      for (int i = 1; i <= n; i++) {
        pm[L] = i;
        dfs(L + 1);
      }
    }
  }
}
