package inflearn.chapter7;

// 1. 재귀함수(스택프레임)
public class Solution1 {

  public static void main(String[] args) {
    dfs(3);
  }

  private static void dfs(int n) {
    if (n == 0) {
      return;
    } else {
      dfs(n - 1);
      System.out.print(n + " ");
    }
  }
}
