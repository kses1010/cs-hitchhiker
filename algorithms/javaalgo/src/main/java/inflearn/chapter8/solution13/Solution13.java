package inflearn.chapter8.solution13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 13. 섬나라 아일랜드(DFS)
public class Solution13 {

  static int answer;
  static int n;
  static int[][] board;
  static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
  static int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};


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

    solution(board);
    System.out.println(answer);
  }

  private static void solution(int[][] board) {
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        if (board[i][j] == 1) {
          answer++;
          board[i][j] = 0;
          dfs(i, j, board);
        }
      }
    }
  }

  private static void dfs(int x, int y, int[][] board) {
    for (int i = 0; i < 8; i++) {
      int nx = x + dx[i];
      int ny = y + dy[i];
      if (nx >= 0 && nx < n && ny >= 0 && ny < n && board[nx][ny] == 1) {
        board[nx][ny] = 0;
        dfs(nx, ny, board);
      }
    }
  }
}
