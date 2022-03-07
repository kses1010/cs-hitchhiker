package inflearn.chapter2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 8. 등수구하기
//5
//87 89 92 100 76
public class Solution8 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    String str = br.readLine();

    int[] answers = solution(str);
    for (int answer : answers) {
      System.out.print(answer + " ");
    }
  }

  private static int[] solution(String str) {
    String[] splits = str.split(" ");
    int[] scores = new int[splits.length];
    for (int i = 0; i < splits.length; i++) {
      scores[i] = Integer.parseInt(splits[i]);
    }

    int[] answers = new int[scores.length];

    for (int i = 0; i < answers.length; i++) {
      int score = scores[i];
      int count = 0;
      for (int j = 0; j < scores.length; j++) {
        if (score < scores[j]) {
          count++;
        }
      }
      answers[i] = count + 1;
    }

    return answers;
  }
}
