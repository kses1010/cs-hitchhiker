package baekjoon.silver.silver1;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

// 2583
//5 7 3
//0 2 4 4
//1 1 2 5
//4 0 6 2
public class CalcArea {

  static int m;
  static int n;
  static int[][] maps;
  static int[] dx = {1, 0, -1, 0};
  static int[] dy = {0, 1, 0, -1};
  static int count = 0;

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    m = sc.nextInt();
    n = sc.nextInt();
    int k = sc.nextInt();

    maps = new int[m][n];

    // map 색칠
    for (int i = 0; i < k; i++) {
      int x1 = sc.nextInt();
      int y1 = sc.nextInt();
      int x2 = sc.nextInt();
      int y2 = sc.nextInt();

      for (int y = y1; y < y2; y++) {
        for (int x = x1; x < x2; x++) {
          maps[y][x] = 1;
        }
      }
    }

    List<Integer> answers = new ArrayList<>();

    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (maps[i][j] == 0) {
          count = 0;
          dfs(i, j);
          answers.add(count);
        }
      }
    }

    System.out.println(answers.size());
    Collections.sort(answers);
    for (Integer answer : answers) {
      System.out.print(answer + " ");
    }
  }

  private static void dfs(int x, int y) {
    maps[x][y] = 1;
    count++;

    for (int i = 0; i < 4; i++) {
      int nx = x + dx[i];
      int ny = y + dy[i];

      if (nx >= 0 && ny >= 0 && nx < m && ny < n) {
        if (maps[nx][ny] == 0) {
          dfs(nx, ny);
        }
      }
    }
  }
}
