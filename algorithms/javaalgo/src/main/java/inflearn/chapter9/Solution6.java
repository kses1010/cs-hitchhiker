package inflearn.chapter9;

import java.util.Scanner;

// 6. 친구인가(서로소)
//9 7
//1 2
//2 3
//3 4
//1 5
//6 7
//7 8
//8 9
//3 8
public class Solution6 {

  static int[] unf;
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int m = sc.nextInt();
    unf = new int[n + 1];
    for (int i = 1; i <= n; i++) {
      unf[i] = i;
    }
    for (int i = 1; i <= m; i++) {
      int a = sc.nextInt();
      int b = sc.nextInt();
      union(a, b);
    }
    int a = sc.nextInt();
    int b = sc.nextInt();
    int fa = find(a);
    int fb = find(b);
    if (fa == fb) {
      System.out.println("YES");
    } else {
      System.out.println("NO");
    }
  }

  private static void union(int a, int b) {
    int fa = find(a);
    int fb = find(b);
    if (fa != fb) {
      unf[fa] = fb;
    }
  }

  private static int find(int v) {
    if (v == unf[v]) {
      return v;
    }
    return unf[v] = find(unf[v]); // 경로 압축 이전: find(unf[v])
  }
}
