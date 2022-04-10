package inflearn.chapter6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

// 5. 중복 확인
//8
//20 25 52 30 39 33 43 33
public class Solution5 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int[] arr = new int[n];

    String[] splits = br.readLine().split(" ");
    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(splits[i]);
    }

    System.out.println(solution(n, arr));
  }

  private static String solution(int n, int[] arr) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int x : arr) {
      map.put(x, map.getOrDefault(x, 0) + 1);
      if (map.get(x) > 1) {
        return "D";
      }
    }
    return "U";
  }

  private static String solution2(int n, int[] arr) {
    Arrays.sort(arr);
    for (int i = 0; i < n - 1; i++) {
      if (arr[i] == arr[i + 1]) {
        return "D";
      }
    }
    return "U";
  }
}
