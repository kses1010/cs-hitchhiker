package inflearn.chapter2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 10. 봉우리
//5
//5 3 7 2 3
//3 7 1 6 1
//7 2 5 3 4
//4 3 6 4 1
//8 7 3 5 2
public class Solution10 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int[][] maps = new int[n + 2][n + 2];

    // solution1
    for (int i = 0; i < n; i++) {
      String[] str = br.readLine().split(" ");
      for (int j = 0; j < n; j++) {
        maps[i + 1][j + 1] = Integer.parseInt(str[j]);
      }
    }

    // solution2
//    int[][] arr = new int[n][n];
//    for (int i = 0; i < n; i++) {
//      String[] str = br.readLine().split(" ");
//      for (int j = 0; j < n; j++) {
//        arr[i][j] = Integer.parseInt(str[j]);
//      }
//    }

    System.out.println(solution(n, maps));
//    System.out.println(solution2(arr));
  }

  private static int solution(int n, int[][] maps) {
    int answer = 0;
    for (int i = 1; i < n + 1; i++) {
      for (int j = 1; j < n + 1; j++) {
        int top = maps[i][j];
        if (top > maps[i][j - 1] && top > maps[i][j + 1] && top > maps[i - 1][j] && top > maps[i + 1][j]) {
          answer++;
        }
      }
    }
    return answer;
  }

  private static int solution2(int[][] maps) {
    // 상하 좌우
    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, -1, 1};


    int answer = 0;
    int n = maps.length;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        boolean flag = true;
        for (int k = 0; k < 4; k++) {
          int nx = i + dx[k];
          int ny = j + dy[k];
          if (nx >= 0 && nx < n && ny >= 0 && ny < n && maps[nx][ny] >= maps[i][j]) {
            flag = false;
            break;
          }
        }
        if (flag) answer++;
      }
    }

    return answer;
  }
}
