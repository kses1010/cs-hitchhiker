package inflearn.chapter3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 6. 최대 길이 연속부분수열
//14 2
//1 1 0 0 1 1 0 1 1 0 1 1 0 1
public class Solution6 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] str = br.readLine().split(" ");
    int n = Integer.parseInt(str[0]);
    int k = Integer.parseInt(str[1]);

    String[] strArr = br.readLine().split(" ");
    int[] binArr = new int[n];
    for (int i = 0; i < n; i++) {
      binArr[i] = Integer.parseInt(strArr[i]);
    }

    System.out.println(solution(n, k, binArr));
    System.out.println(solution2(n, k, binArr));
  }

  private static int solution(int n, int k, int[] binArr) {
    int max = 0;
    int lt = 0;
    int rt = 1;
    int zeroCount = 0;

    while (rt < n) {
      if (binArr[rt] == 0) {
        zeroCount++;
        if (zeroCount > k) {
          int length = rt - lt;
          max = Math.max(max, length);
          while (zeroCount > k) {
            if (binArr[lt] == 0) {
              zeroCount--;
            }
            lt++;
          }
        }
      }
      rt++;
    }
    return max;
  }

  private static int solution2(int n, int k, int[] arr) {
    int answer = 0;
    int count = 0;
    int lt = 0;
    for (int rt = 0; rt < n; rt++) {
      if (arr[rt] == 0) {
        count++;
        while (count > k) {
          if (arr[lt] == 0) {
            count--;
            lt++;
          }
        }
        answer = Math.max(answer, rt - lt + 1);
      }
    }
    return answer;
  }
}
