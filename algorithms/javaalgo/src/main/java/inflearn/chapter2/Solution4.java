package inflearn.chapter2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

// 4. 피보나치 수열
// 10
public class Solution4 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());

    List<Integer> nums = solution(n);
    for (Integer num : nums) {
      System.out.print(num + " ");
    }
    System.out.println();
    solution3(n);
  }

  private static List<Integer> solution(int n) {
    List<Integer> answers = new ArrayList<>();
    int n1 = 1;
    int n2 = 1;
    answers.add(n1);
    answers.add(n2);
    for (int i = 2; i < n; i++) {
      int tmp = n2;
      n2 = n2 + n1;
      answers.add(n2);
      n1 = tmp;
    }

    return answers;
  }

  private static int[] solution2(int n) {
    int[] answers = new int[n];
    answers[0] = 1;
    answers[1] = 1;
    for (int i = 2; i < n; i++) {
      answers[i] = answers[i - 2] + answers[i - 1];
    }
    return answers;
  }

  private static void solution3(int n) {
    int n1 = 1;
    int n2 = 1;
    int n3;
    System.out.print(n1 + " " + n2 + " ");
    for (int i = 2; i < n; i++) {
      n3 = n1 + n2;
      System.out.print(n3 + " ");
      n1 = n2;
      n2 = n3;
    }
  }
}
