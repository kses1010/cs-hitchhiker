package inflearn.chapter8.solution11;

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

// 11. 미로의 최단거리 통로(BFS)
//0 0 0 0 0 0 0
//0 1 1 1 1 1 0
//0 0 0 1 0 0 0
//1 1 0 1 0 1 1
//1 1 0 0 0 0 1
//1 1 0 1 1 0 0
//1 0 0 0 0 0 0
public class Solution11 {

  static int n;
  static int[] dx = {-1, 0, 1, 0};
  static int[] dy = {0, -1, 0, 1};
  static int[][] board;
  static int[][] dis;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    n = 7;
    board = new int[n][n];
    dis = new int[n][n];

    for (int i = 0; i < n; i++) {
      String[] str = br.readLine().split(" ");
      for (int j = 0; j < n; j++) {
        board[i][j] = Integer.parseInt(str[j]);
      }
    }

    bfs(0, 0);
    if (dis[n - 1][n - 1] == 0) {
      System.out.println(-1);
    }

    System.out.println(dis[n - 1][n - 1]);
  }

  private static void bfs(int x, int y) {
    Queue<Point> q = new LinkedList<>();
    q.offer(new Point(x, y));
    board[x][y] = 1;
    while (!q.isEmpty()) {
      Point tmp = q.poll();
      for (int i = 0; i < 4; i++) {
        int nx = tmp.x + dx[i];
        int ny = tmp.y + dy[i];
        if (nx >= 0 && ny >= 0 && nx < n && ny < n && board[nx][ny] == 0) {
          board[nx][ny] = 1;
          q.offer(new Point(nx, ny));
          dis[nx][ny] = dis[tmp.x][tmp.y] + 1;
        }
      }
    }
  }
}
