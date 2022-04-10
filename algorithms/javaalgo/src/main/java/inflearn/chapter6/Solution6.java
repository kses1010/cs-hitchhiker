package inflearn.chapter6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 6. 장난꾸러기
//9
//120 125 152 130 135 135 143 127 160
public class Solution6 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int[] arr = new int[n];

    String[] splits = br.readLine().split(" ");
    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(splits[i]);
    }

    List<Integer> solution = solution(n, arr);
    for (Integer x : solution) {
      System.out.print(x + " ");
    }
  }

  private static List<Integer> solution(int n, int[] arr) {
    List<Integer> answer = new ArrayList<>();
    int[] tmp = arr.clone();
    Arrays.sort(tmp);

    for (int i = 0; i < n; i++) {
      if (arr[i] != tmp[i]) {
        answer.add(i + 1);
      }
    }
    return answer;
  }
}
