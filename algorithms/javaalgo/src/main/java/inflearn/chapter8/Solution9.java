package inflearn.chapter8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 9. 조합 구하기
//4 2
public class Solution9 {
  static int[] combi;
  static int n;
  static int m;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] splits = br.readLine().split(" ");
    n = Integer.parseInt(splits[0]);
    m = Integer.parseInt(splits[1]);
    combi = new int[m];

    dfs(0, 1);
  }

  private static void dfs(int L, int s) {
    if (L == m) {
      for (int x : combi) {
        System.out.print(x + " ");
      }
      System.out.println();
    } else {
      for (int i = s; i <= n; i++) {
        combi[L] = i;
        dfs(L + 1, i + 1);
      }
    }
  }
}
