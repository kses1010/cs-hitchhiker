package inflearn.chapter6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// 8. 이분검색
//8 32
//23 87 65 12 57 32 99 81
public class Solution8 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] splits = br.readLine().split(" ");
    int n = Integer.parseInt(splits[0]);
    int m = Integer.parseInt(splits[1]);

    int[] arr = new int[n];
    String[] strArr = br.readLine().split(" ");
    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(strArr[i]);
    }
    Arrays.sort(arr);
    System.out.println(solution2(n, m, arr));
  }

  private static int solution(int n, int m, int[] arr) {
    int answer = 0;
    int lt = 0;
    int rt = n - 1;

    while (lt <= rt) {
      int mid = (lt + rt) / 2;
      if (arr[mid] == m) {
        answer = mid + 1;
      }
      if (arr[mid] > m) {
        rt = mid - 1;
      } else {
        lt = mid + 1;
      }
    }
    return answer;
  }

  private static int solution2(int n, int m, int[] arr) {
    int lt = 0;
    int rt = n - 1;
    return recur(lt, rt, arr, m);
  }

  private static int recur(int lt, int rt, int[] arr, int m) {
    int mid;

    if (lt <= rt) {
      mid = (lt + rt) / 2;

      if (arr[mid] == m) {
        return mid + 1;
      } else if (arr[mid] > m) {
        return recur(lt, mid - 1, arr, m);
      } else {
        return recur(mid + 1, rt, arr, m);
      }
    }
    return -1;
  }
}
