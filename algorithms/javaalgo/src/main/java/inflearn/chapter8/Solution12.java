package inflearn.chapter8;

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

// 12. 토마토
//6 4
//0 0 -1 0 0 0
//0 0 1 0 -1 0
//0 0 -1 0 0 0
//0 0 0 0 -1 1
public class Solution12 {

  static int n;
  static int m;
  static int[] dx = {-1, 0, 1, 0};
  static int[] dy = {0, -1, 0, 1};
  static int[][] board;
  static int[][] dis;
  static Queue<Point> q = new LinkedList<>();

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] splits = br.readLine().split(" ");
    m = Integer.parseInt(splits[0]);
    n = Integer.parseInt(splits[1]);
    board = new int[n][m];
    dis = new int[n][m];

    for (int i = 0; i < n; i++) {
      String[] str = br.readLine().split(" ");
      for (int j = 0; j < m; j++) {
        board[i][j] = Integer.parseInt(str[j]);
        if (board[i][j] == 1) {
          q.offer(new Point(i, j));
        }
      }
    }

    bfs();
    System.out.println(answer());
  }

  private static int answer() {
    int answer = Integer.MIN_VALUE;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (board[i][j] == 0) {
          return -1;
        }
        answer = Math.max(answer, dis[i][j]);
      }
    }
    return answer;
  }

  private static void bfs() {
    while (!q.isEmpty()) {
      Point tmp = q.poll();
      for (int i = 0; i < 4; i++) {
        int nx = tmp.x + dx[i];
        int ny = tmp.y + dy[i];
        if (nx >= 0 && ny >= 0 && nx < n && ny < m && board[nx][ny] == 0) {
          board[nx][ny] = 1;
          q.offer(new Point(nx, ny));
          dis[nx][ny] = dis[tmp.x][tmp.y] + 1;
        }
      }
    }
  }
}
