package inflearn.chapter2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 2. 보이는 학생
// 8
// 130 135 148 140 145 150 150 153
public class Solution2 {

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

    int answer = 0;
    int init = 0;
    for (int h : nums) {
      if (init < h) {
        answer++;
        init = h;
      }
    }

    return answer;
  }
}
