package inflearn.chapter8.solution11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

class Coordinate {
  int x;
  int y;

  public Coordinate(int x, int y) {
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
public class Solution11B {
  static int n;
  static int[] dx = {-1, 0, 1, 0};
  static int[] dy = {0, -1, 0, 1};

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    n = 7;
    int[][] arr = new int[n][n];

    for (int i = 0; i < n; i++) {
      String[] str = br.readLine().split(" ");
      for (int j = 0; j < n; j++) {
        arr[i][j] = Integer.parseInt(str[j]);
      }
    }

    System.out.println(solution(n, arr));
  }

  private static int solution(int n, int[][] arr) {
    int answer;
    Queue<Coordinate> q = new LinkedList<>();
    q.offer(new Coordinate(0, 0));

    arr[0][0] = 1;

    while (!q.isEmpty()) {
      int len = q.size();
      for (int i = 0; i < len; i++) {
        Coordinate coord = q.poll();
        for (int d = 0; d < 4; d++) {
          int nx = coord.x + dx[d];
          int ny = coord.y + dy[d];
          if (nx >= 0 && ny >= 0 && nx < n && ny < n && arr[nx][ny] == 0) {
            arr[nx][ny] = arr[coord.x][coord.y] + 1;
            q.offer(new Coordinate(nx, ny));
          }
        }
      }
    }
    answer = arr[n - 1][n - 1] - 1;

    return answer;
  }
}
