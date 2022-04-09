package inflearn.chapter6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 3. 삽입정렬
public class Solution3 {

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
    for (int i = 1; i < n; i++) {
      int tmp = arr[i];
      int j;
      for (j = i - 1; j >= 0; j--) {
        if (arr[j] > tmp) {
          arr[j + 1] = arr[j];
        } else {
          break;
        }
      }
      arr[j + 1] = tmp;
    }
    return arr;
  }

  private static int[] solution2(int n, int[] arr) {
    for (int i = 1; i < n; i++) {
      int tmp = arr[i];
      int j = i - 1;

      while (j >= 0 && tmp < arr[j]) {
        arr[j + 1] = arr[j];
        j--;
      }
      arr[j + 1] = tmp;
    }
    return arr;
  }
}
