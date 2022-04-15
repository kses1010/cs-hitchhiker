package inflearn.chapter8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 2. 바둑이 승차
//259 5
//81
//58
//42
//33
//61
public class Solution2 {

  static int c;
  static int n;
  static int answer;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] splits = br.readLine().split(" ");
    c = Integer.parseInt(splits[0]);
    n = Integer.parseInt(splits[1]);

    int[] arr = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(br.readLine());
    }

    dfs(0, 0, arr);
    System.out.println(answer);
  }

  private static void dfs(int L, int sum, int[] arr) {
    if (sum > c) {
      return;
    }
    if (L == n) {
      answer = Math.max(answer, sum);
    } else {
      dfs(L + 1, sum + arr[L], arr);
      dfs(L + 1, sum, arr);
    }
  }
}
