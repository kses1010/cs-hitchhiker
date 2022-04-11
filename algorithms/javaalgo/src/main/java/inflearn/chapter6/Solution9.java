package inflearn.chapter6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// 9. 뮤직비디오
public class Solution9 {

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
    System.out.println(solution(n, m, arr));
  }

  private static int solution(int n, int m, int[] arr) {
    int answer = 0;
    int lt = Arrays.stream(arr).max().getAsInt();
    int rt = Arrays.stream(arr).sum();

    while (lt <= rt) {
      int mid = (lt + rt) / 2;
      if (count(arr, mid) <= m) {
        answer = mid;
        rt = mid - 1;
      } else {
        lt = mid +1;
      }
    }

    return answer;
  }

  private static int count(int[] arr, int capacity) {
    int count = 1;
    int sum = 0;
    for (int i : arr) {
      if (sum + i > capacity) {
        count++;
        sum = i;
      } else {
        sum += i;
      }
    }
    return count;
  }
}
