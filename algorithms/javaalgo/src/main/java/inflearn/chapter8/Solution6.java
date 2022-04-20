package inflearn.chapter8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 6. 순열 구하기
//3 2
//3 6 9
public class Solution6 {
  static int[] pm;
  static int[] checks;
  static int[] arr;
  static int n;
  static int m;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] splits = br.readLine().split(" ");
    n = Integer.parseInt(splits[0]);
    m = Integer.parseInt(splits[1]);
    arr = new int[n];
    checks = new int[n];
    pm = new int[m];

    String[] splits2 = br.readLine().split(" ");
    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(splits2[i]);
    }
    dfs(0);
  }

  private static void dfs(int L) {
    if (L == m) {
      for (int x : pm) {
        System.out.print(x + " ");
      }
      System.out.println();
    } else {
      for (int i = 0; i < n; i++) {
        if (checks[i] == 0) {
          checks[i] = 1;
          pm[L] = arr[i];
          dfs(L + 1);
          checks[i] = 0;
        }
      }
    }
  }
}
