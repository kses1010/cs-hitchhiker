package inflearn.chapter8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 1. 합이 같은 부분집합(DFS : 아마존 인터뷰)
//6
//1 3 5 6 7 10
public class Solution1 {

  static String answer = "NO";
  static int n;
  static int total;
  static boolean flag = false;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    n = Integer.parseInt(br.readLine());
    int[] arr = new int[n];

    String[] splits = br.readLine().split(" ");
    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(splits[i]);
      total += arr[i];
    }

    dfs(0, 0, arr);
    System.out.println(answer);
  }

  public static void dfs(int L, int sum, int[] arr) {
    if (flag) return;
    if (L == n) {
      if (total - sum == sum) {
        answer = "YES";
        flag = true;
      }
    } else {
      dfs(L + 1, sum + arr[L], arr); // 해당 원소를 사용할 경우
      dfs(L + 1, sum, arr); // 해당 원소를 사용하지 않을 경우
    }
  }
}
