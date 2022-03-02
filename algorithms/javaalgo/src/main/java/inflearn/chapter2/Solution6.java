package inflearn.chapter2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

// 6. 뒤집은 소수
// 9
// 32 55 62 20 250 370 200 30 100
public class Solution6 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    String str = br.readLine();

    List<Integer> answers = solution(str);
    for (Integer num : answers) {
      System.out.print(num + " ");
    }
  }

  private static List<Integer> solution(String str) {
    List<Integer> answers = new ArrayList<>();

    String[] splits = str.split(" ");

    for (String s : splits) {
      StringBuilder sb = new StringBuilder(s);
      int num = Integer.parseInt(sb.reverse().toString());

      // 소수발견하기
      if (isPrime(num)) {
        answers.add(num);
      }
    }

    return answers;
  }

  private static boolean isPrime(int num) {
    if (num == 1) {
      return false;
    }
    for (int i = 2; i < num; i++) {
      if (num % i == 0) {
        return false;
      }
    }
    return true;
  }
}
