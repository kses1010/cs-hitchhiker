package inflearn.chapter3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 3. 최대 매출
//10 3
//12 15 11 20 25 10 20 19 13 15
public class Solution3 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] str = br.readLine().split(" ");
    int n = Integer.parseInt(str[0]);
    int k = Integer.parseInt(str[1]);

    String[] strs = br.readLine().split(" ");
    int[] incomes = new int[n];
    for (int i = 0; i < n; i++) {
      incomes[i] = Integer.parseInt(strs[i]);
    }

    System.out.println(solution(k, incomes));
  }

  private static int solution(int k, int[] incomes) {
    int answers = 0;
    for (int i = 0; i < incomes.length - k; i++) {
      int sum = 0;
      for (int j = i; j < i + k; j++) {
        sum += incomes[j];
      }
      answers = Math.max(answers, sum);
    }
    return answers;
  }
}
