package inflearn.chapter8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

// 5. 동전교환
//3
//1 2 5
//15
public class Solution5 {
  static int n;
  static int m;
  static Integer[] arr;
  static int answer = Integer.MAX_VALUE;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    n = Integer.parseInt(br.readLine());
    arr = new Integer[n];

    String[] splits = br.readLine().split(" ");
    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(splits[i]);
    }
    // 최소치를 구하기 때문에 내림차순으로 역정렬하면 시간이 더 빠르다.
    Arrays.sort(arr, Collections.reverseOrder());
    m = Integer.parseInt(br.readLine());

    dfs(0, 0, arr);
    System.out.println(answer);
  }

  private static void dfs(int L, int sum, Integer[] arr) {
    if (sum > m) {
      return;
    }
    if (L >= answer) {
      return;
    }
    if (sum == m) {
      answer = L;
    } else {
      for (int i = 0; i < n; i++) {
        dfs(L + 1, sum + arr[i], arr);
      }
    }
  }
}
