package inflearn.chapter7;

// 2. 이진수 출력(재귀)
public class Solution2 {

  public static void main(String[] args) {
    dfs(11);
  }

  private static void dfs(int n) {
    if (n == 0) {
      return;
    } else {
      dfs(n / 2);
      System.out.print(n % 2);
    }
  }
}
