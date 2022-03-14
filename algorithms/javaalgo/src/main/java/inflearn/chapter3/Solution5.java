package inflearn.chapter3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 5. 연속된 자연수의 합
//15
public class Solution5 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());

    System.out.println(solution(n));
    System.out.println(solution2(n));
  }

  private static int solution(int n) {
    int answer = 0;
    int lt = 1;
    int rt = 2;
    int sum = lt;

    while (rt < n) {
      if (sum < n) {
        sum += rt++;
      } else if (sum == n) {
        answer++;
        sum -= lt++;
      } else {
        sum -= lt++;
      }
    }
    return answer;
  }

  private static int solution2(int n) {
    int answer = 0;
    int sum = 0;
    int lt = 0;
    int m = n / 2 + 1;
    int[] arr = new int[m];
    for (int i = 0; i < m; i++) {
      arr[i] = i + 1;
    }

    for (int rt = 0; rt < m; rt++) {
      sum += arr[rt];
      if (sum == n) {
        answer++;
      }
      while (sum >= n) {
        sum -= arr[lt++];
        if (sum == n) {
          answer++;
        }
      }
    }
    return answer;
  }
}
