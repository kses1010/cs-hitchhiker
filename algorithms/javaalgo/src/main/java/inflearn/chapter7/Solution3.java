package inflearn.chapter7;

// 3. 팩토리얼
public class Solution3 {

  public static void main(String[] args) {
    System.out.println(dfs(5));
  }

  private static int dfs(int n) {
    if (n == 0) {
      return 1;
    } else {
      return n * dfs(n - 1);
    }
  }
}
