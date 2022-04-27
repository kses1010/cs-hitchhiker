package inflearn.chapter8.solution13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 13. 섬나라 아일랜드(DFS)
//7
//1 1 0 0 0 1 0
//0 1 1 0 1 1 0
//0 1 0 0 0 0 0
//0 0 0 1 0 1 1
//1 1 0 1 1 0 0
//1 0 0 0 1 0 0
//1 0 1 0 1 0 0
public class Solution13B {

  static int n;
  static int[][] board;
  static int count;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    n = Integer.parseInt(br.readLine());
    board = new int[n][n];

    for (int i = 0; i < n; i++) {
      String[] str = br.readLine().split(" ");
      for (int j = 0; j < n; j++) {
        board[i][j] = Integer.parseInt(str[j]);
      }
    }

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        if (board[i][j] == 1) {
          count++;
          dfs(i, j);
        }
      }
    }
    System.out.println(count);
  }

  private static void dfs(int x, int y) {
    if (x < 0 || y < 0 || x >= n || y >= n || board[x][y] == 0) {
      return;
    } else {
      board[x][y] = 0; // 방문처리

      dfs(x - 1, y);
      dfs(x + 1, y);
      dfs(x, y - 1);
      dfs(x, y + 1);
    }
  }
}
