package inflearn.chapter8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 10. 미로탐색(DFS)
//0 0 0 0 0 0 0
//0 1 1 1 1 1 0
//0 0 0 1 0 0 0
//1 1 0 1 0 1 1
//1 1 0 0 0 0 1
//1 1 0 1 1 0 0
//1 0 0 0 0 0 0
public class Solution10 {
  static int answer;
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
    arr[0][0] = 1;
    dfs(0, 0, arr);

    System.out.println(answer);
  }

  private static void dfs(int x, int y, int[][] arr) {
    if (x == n - 1 && y == n - 1) {
      answer++;
    } else {
      for (int i = 0; i < 4; i++) {
        int nx = x + dx[i];
        int ny = y + dy[i];
        if (nx >= 0 && ny >= 0 && nx < n && ny < n && arr[nx][ny] == 0) {
          arr[nx][ny] = 1;
          dfs(nx, ny, arr);
          arr[nx][ny] = 0;
        }
      }
    }
  }
}
