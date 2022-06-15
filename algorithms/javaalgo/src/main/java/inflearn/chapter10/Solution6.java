package inflearn.chapter10;

import java.util.Scanner;

// 6. 최대점수 구하기(냅색 알고리즘)
//5 20
//10 5
//25 12
//15 8
//6 3
//7 4
public class Solution6 {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int m = sc.nextInt();
    int[] dy = new int[m + 1];
    for (int i = 0; i < n; i++) {
      int problemScore = sc.nextInt();
      int problemTime = sc.nextInt();
      for (int j = m; j >= problemTime; j--) {
        dy[j] = Math.max(dy[j], dy[j - problemTime] + problemScore);
      }
    }
    System.out.println(dy[m]);
  }
}
