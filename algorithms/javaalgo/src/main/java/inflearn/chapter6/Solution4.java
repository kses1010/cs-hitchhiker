package inflearn.chapter6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 4. Least Recently Used
public class Solution4 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] splits = br.readLine().split(" ");
    int s = Integer.parseInt(splits[0]);
    int n = Integer.parseInt(splits[1]);

    int[] arr = new int[n];
    String[] strArr = br.readLine().split(" ");
    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(strArr[i]);
    }

    int[] solution = solution(s, n, arr);
    for (int i : solution) {
      System.out.print(i + " ");
    }
  }

  private static int[] solution(int s, int n, int[] arr) {
    int[] cache = new int[s];
    for (int x : arr) {
      int pos = -1;

      // 캐시에 값이 있는가
      for (int i = 0; i < s; i++) {
        if (x == cache[i]) {
          pos = i;
        }
      }

      // 캐시에 값이 없을 경우
      if (pos == -1) {
        for (int i = s - 1; i >= 1; i--) {
          cache[i] = cache[i - 1];
        }
      }
      // 캐시에 값이 있을 경우
      else {
        for (int i = pos; i >= 1; i--) {
          cache[i] = cache[i - 1];
        }
      }
      cache[0] = x;
    }
    return cache;
  }
}
