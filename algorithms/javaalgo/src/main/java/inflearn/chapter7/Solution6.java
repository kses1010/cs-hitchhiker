package inflearn.chapter7;

// 6. 부분집합 구하기(DFS)
public class Solution6 {
  static int[] checks;
  static int n;

  public static void main(String[] args) {
    n = 3;
    checks = new int[n + 1];
    dfs(1);
  }

  private static void dfs(int L) {
    if (L == n + 1) {
      String tmp = "";
      for (int i = 1; i <= n; i++) {
        if (checks[i] == 1) {
          tmp += (i + " ");
        }
      }
      if (tmp.length() > 0) {
        System.out.println(tmp);
      }
    } else {
      checks[L] = 1;
      dfs(L + 1);
      checks[L] = 0;
      dfs(L + 1);
    }
  }
}
