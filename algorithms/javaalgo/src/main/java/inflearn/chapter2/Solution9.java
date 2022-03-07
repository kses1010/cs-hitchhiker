package inflearn.chapter2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 9. 격자판 최대합
//5
//10 13 10 12 15
//12 39 30 23 11
//11 25 50 53 15
//19 27 29 37 27
//19 13 30 13 19
public class Solution9 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
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
    int answer = Integer.MIN_VALUE;
    int sum1; // 행의 합
    int sum2; // 열의 합
    for (int i = 0; i < n; i++) {
      sum1 = sum2 = 0;
      for (int j = 0; j < n; j++) {
        sum1 += arr[i][j];
        sum2 += arr[j][i];
      }
      answer = Math.max(answer, sum1);
      answer = Math.max(answer, sum2);
    }
    sum1 = sum2 = 0;
    for (int i = 0; i < n; i++) {
      sum1 += arr[i][i];
      sum2 += arr[i][n - i - 1];
    }
    answer = Math.max(answer, sum1);
    answer = Math.max(answer, sum2);

    return answer;
  }
}
