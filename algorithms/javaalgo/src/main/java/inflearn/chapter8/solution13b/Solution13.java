package inflearn.chapter8.solution13b;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

class Point {
  int x;
  int y;

  public Point(int x, int y) {
    this.x = x;
    this.y = y;
  }
}

// 13. 섬나라 아일랜드(BFS)
public class Solution13 {

  static int answer;
  static int n;
  static int[][] board;
  static int[][] checks;
  static int[] dx = {-1, 0, 1, 0};
  static int[] dy = {0, -1, 0, 1};
  static Queue<Point> q = new LinkedList<>();

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    n = Integer.parseInt(br.readLine());
    board = new int[n][n];
    checks = new int[n][n];

    for (int i = 0; i < n; i++) {
      String[] str = br.readLine().split(" ");
      for (int j = 0; j < n; j++) {
        board[i][j] = Integer.parseInt(str[j]);
      }
    }

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        if (checks[i][j] == 0 && board[i][j] == 1) {
          bfs(new Point(i, j));
          answer++;
        }
      }
    }
    System.out.println(answer);
  }

  private static void bfs(Point point) {
    q.offer(point);
    while (!q.isEmpty()) {
      Point tmp = q.poll();
      for (int i = 0; i < 4; i++) {
        int nx = tmp.x + dx[i];
        int ny = tmp.y + dy[i];

        if (nx >= 0 && nx < n && ny >= 0 && ny < n && board[nx][ny] == 1 && checks[nx][ny] == 0) {
          q.offer(new Point(nx, ny));
          checks[nx][ny] = 1;
        }
      }
    }
  }
}
