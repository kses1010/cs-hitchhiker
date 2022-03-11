package inflearn.chapter3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 4. 연속 부분수열
//8 6
//1 2 1 3 1 1 1 2
public class Solution4 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] str = br.readLine().split(" ");
    int n = Integer.parseInt(str[0]);
    int m = Integer.parseInt(str[1]);

    String[] numStr = br.readLine().split(" ");
    int[] arr = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(numStr[i]);
    }

    System.out.println(solution(n, m, arr));
    System.out.println(solution2(n, m, arr));
  }

  // O(n^2)
  private static int solution(int n, int m, int[] arr) {
    int answer = 0;
    for (int i = 0; i < n; i++) {
      int sum = 0;
      int p = i;
      while (sum <= m && p < n) {
        sum += arr[p];
        if (sum == m) {
          answer++;
          break;
        }
        p++;
      }
    }
    return answer;
  }

  // O(n)
  private static int solution2(int n, int m, int[] arr) {
    int answer = 0;
    int lt = 0;
    int sum = 0;
    for (int rt = 0; rt < n; rt++) {
      sum += arr[rt];
      if (sum == m) {
        answer++;
      }
      while (sum >= m) {
        sum -= arr[lt];
        lt++;
        if (sum == m) {
          answer++;
        }
      }
    }
    return answer;
  }
}
