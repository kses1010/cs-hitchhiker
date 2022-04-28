package inflearn.chapter8.solution14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// 14. 피자 배달 거리(안됨)
//4 4
//0 1 2 0
//1 0 2 1
//0 2 1 2
//2 0 1 2
public class Solution14B {

  static int n;
  static int m;
  static int px;
  static int py;
  static int[][] board;
  static int[][] dist;
  static int[] dx = {-1, 0, 1, 0};
  static int[] dy = {0, -1, 0, 1};
  static int answer;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] splits = br.readLine().split(" ");
    n = Integer.parseInt(splits[0]);
    m = Integer.parseInt(splits[1]);
    board = new int[n][n];
    dist = new int[n][n];

    for (int i = 0; i < n; i++) {
      String[] str = br.readLine().split(" ");
      for (int j = 0; j < n; j++) {
        board[i][j] = Integer.parseInt(str[j]);
      }
    }
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        dist[i][j] = Integer.MAX_VALUE;
      }
    }

    findDist(board);
    System.out.println(solution(m));
  }

  private static int solution(int m) {
    List<Integer> distanceList = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        if (dist[i][j] != Integer.MAX_VALUE) {
          distanceList.add(dist[i][j]);
        }
      }
    }
    Collections.sort(distanceList);
    for (int i = 0; i < m; i++) {
      answer += distanceList.get(i);
    }
    return answer;
  }

  private static void findDist(int[][] board) {
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        if (board[i][j] == 2) {
          px = i;
          py = j;
          dfs(i, j);
        }
      }
    }
  }

  private static void dfs(int x, int y) {
    for (int i = 0; i < 4; i++) {
      int nx = x + dx[i];
      int ny = y + dy[i];
      if (nx >= 0 && ny >= 0 && nx < n && ny < n && board[nx][ny] == 1) {
        board[nx][ny] = 0;
        int distance = Math.abs(nx - px) + Math.abs(ny - py);
        dist[nx][ny] = Math.min(dist[nx][ny], distance);
        dfs(nx, ny);
        board[nx][ny] = 1;
      }
    }
  }
}
