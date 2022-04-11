package inflearn.chapter6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// 10. 마구간 정하기
public class Solution10 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] splits = br.readLine().split(" ");
    int n = Integer.parseInt(splits[0]);
    int c = Integer.parseInt(splits[1]);

    int[] arr = new int[n];
    String[] strArr = br.readLine().split(" ");
    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(strArr[i]);
    }
    System.out.println(solution(n, c, arr));
  }

  private static int solution(int n, int c, int[] arr) {
    int answer = 0;
    Arrays.sort(arr);
    int lt = 1;
    int rt = arr[n - 1];

    while (lt <= rt) {
      int mid = (lt + rt) / 2;
      if (count(arr, mid) >= c) {
        answer = mid;
        lt = mid + 1;
      } else {
        rt = mid - 1;
      }
    }

    return answer;
  }

  private static int count(int[] arr, int dist) {
    int count = 0;
    int ep = arr[0];
    for (int i = 1; i < arr.length; i++) {
      if (arr[i] - ep >= dist) {
        count++;
        ep = arr[i];
      }
    }
    return count;
  }
}
