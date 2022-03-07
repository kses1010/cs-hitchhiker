package inflearn.chapter2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 12. 멘토링
//4 3
//3 4 1 2
//4 3 2 1
//3 1 4 2
public class Solution12 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] splits = br.readLine().split(" ");
    int n = Integer.parseInt(splits[0]);
    int m = Integer.parseInt(splits[1]);
    int[][] arr = new int[m][n];

    for (int i = 0; i < m; i++) {
      String[] str = br.readLine().split(" ");
      for (int j = 0; j < n; j++) {
        arr[i][j] = Integer.parseInt(str[j]);
      }
    }

//    System.out.println(solution(n, m, arr));
    System.out.println(solution2(n, m, arr));
  }

  private static int solution(int n, int m, int[][] arr) {
    int answer = 0;
    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= n; j++) {
        int count = 0;
        for (int k = 0; k < m; k++) {
          int pi = 0;
          int pj = 0;
          for (int s = 0; s < n; s++) {
            if (arr[k][s] == i) {
              pi = s;
            }
            if (arr[k][s] == j) {
              pj = s;
            }
          }
          if (pi < pj) {
            count++;
          }
        }
        if (count == m) {
          answer++;
        }
      }
    }
    return answer;
  }

  private static int solution2(int n, int m, int[][] arr) {
    int answer = 0;
    for (int i = 0; i < n; i++) {
      for (int j = i + 1; j < n; j++) {
        boolean flag = true;
        for (int k = 0; k < m; k++) {
          if (arr[k][i] < arr[k][j]) {
            flag = false;
            break;
          }
        }
        if (flag) {
          answer++;
        }
      }
    }
    return answer;
  }
}
