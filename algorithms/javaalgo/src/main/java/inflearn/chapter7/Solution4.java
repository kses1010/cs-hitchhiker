package inflearn.chapter7;

// 4. 피보나치 수열
public class Solution4 {

  static int[] fibo;
  public static void main(String[] args) {
    int n = 45;
    fibo = new int[n + 1];

//    for (int i = 1; i <= n; i++) {
//      System.out.print(dfs(i) + " ");
//    }
//    System.out.println();
//
//    // 배열 적용
//    dfs2(n);
//    for (int i = 1; i <= n; i++) {
//      System.out.print(fibo[i] + " ");
//    }

    // 메모이제이션 적용
    dfs3(n);
    for (int i = 1; i <= n; i++) {
      System.out.print(fibo[i] + " ");
    }
  }

  private static int dfs(int n) {
    if (n == 1) {
      return 1;
    } else if (n == 2) {
      return 1;
    } else {
      return dfs(n - 2) + dfs(n - 1);
    }
  }

  private static int dfs2(int n) {
    if (n == 1) {
      return fibo[n] = 1;
    } else if (n == 2) {
      return fibo[n] = 1;
    } else {
      return fibo[n] = dfs2(n - 2) + dfs2(n - 1);
    }
  }

  private static int dfs3(int n) {
    if (fibo[n] > 0) {
      return fibo[n];
    }
    if (n == 1) {
      return fibo[n] = 1;
    } else if (n == 2) {
      return fibo[n] = 1;
    } else {
      return fibo[n] = dfs3(n - 2) + dfs3(n - 1);
    }
  }
}
