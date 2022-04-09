package inflearn.chapter6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 1. 선택정렬
//6
//13 5 11 7 23 15
public class Solution1 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int[] arr = new int[n];

    String[] splits = br.readLine().split(" ");
    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(splits[i]);
    }

    int[] solution = solution(n, arr);
    for (int integer : solution) {
      System.out.print(integer + " ");
    }
  }

  private static int[] solution(int n, int[] arr) {
    for (int i = 0; i < n - 1; i++) {
      int idx = i;

      for (int j = i + 1; j < n; j++) {
        if (arr[j] < arr[idx]) {
          idx = j;
        }
      }
      int tmp = arr[i];
      arr[i] = arr[idx];
      arr[idx] = tmp;
    }
    return arr;
  }
}
