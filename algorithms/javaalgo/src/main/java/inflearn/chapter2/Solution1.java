package inflearn.chapter2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

// 1. 큰 수 출력하기
public class Solution1 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    String str = br.readLine();

    List<Integer> solution = solution(n, str);
    for (Integer integer : solution) {
      System.out.print(integer + " ");
    }
  }

  private static List<Integer> solution(int n, String str) {
    List<Integer> answers = new ArrayList<>();

    String[] splits = str.split(" ");
    int[] nums = new int[splits.length];
    for (int i = 0; i < splits.length; i++) {
      nums[i] = Integer.parseInt(splits[i]);
    }
    answers.add(nums[0]);

    for (int i = 1; i < nums.length; i++) {
      if (nums[i] > nums[i - 1]) {
        answers.add(nums[i]);
      }
    }

    return answers;
  }
}
