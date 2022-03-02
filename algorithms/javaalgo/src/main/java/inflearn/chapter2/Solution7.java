package inflearn.chapter2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 7. 점수계산
// 10
// 1 0 1 1 1 0 0 1 1 0
public class Solution7 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    String str = br.readLine();

    System.out.println(solution(str));
  }

  private static int solution(String str) {
    String[] splits = str.split(" ");
    int[] nums = new int[splits.length];
    for (int i = 0; i < splits.length; i++) {
      nums[i] = Integer.parseInt(splits[i]);
    }

    int total = 0;
    int seq = 1;
    for (int num : nums) {
      if (num == 1) {
        total += seq;
        seq += 1;
      } else {
        seq = 1;
      }
    }

    return total;
  }
}
