package inflearn.chapter10;

import java.util.Arrays;
import java.util.Scanner;

// 5. 동전교환(냅색 알고리즘)
//3
//1 2 5
//15
public class Solution5 {

  static int[] dy;

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int[] arr = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = sc.nextInt();
    }

    int m = sc.nextInt();
    dy = new int[m + 1];
    System.out.println(solution(arr, m));
  }

  private static int solution(int[] coin, int m) {
    Arrays.fill(dy, Integer.MAX_VALUE);
    dy[0] = 0;
    int n = coin.length;
    for (int i = 0; i < n; i++) {
      for (int j = coin[i]; j <= m; j++) {
        dy[j] = Math.min(dy[j], dy[j - coin[i]] + 1);
      }
    }
    return dy[m];
  }
}
