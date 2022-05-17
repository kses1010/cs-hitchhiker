package inflearn.chapter10;

import java.util.Scanner;

// 2. 돌다리 건너기
public class Solution2 {

  static int[] dy;
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();

    System.out.println(solution(n));

  }

  private static int solution(int n) {
    dy = new int[n + 1];
    dy[1] = 2;
    dy[2] = 3;
    for (int i = 3; i <= n; i++) {
      dy[i] = dy[i - 2] + dy[i - 1];
    }
    return dy[n];
  }
}
