package inflearn.chapter2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 5. 소수(에라토스테네스 체)
public class Solution5 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());

    System.out.println(solution(n));
  }

  private static int solution(int n) {
    int count = 0;
    int[] check = new int[n + 1];
    for (int i = 2; i < n; i++) {
      if (check[i] == 0) {
        count++;
        for (int j = i; j < n; j += i) {
          check[j] = 1;
        }
      }
    }
    return count;
  }
}
