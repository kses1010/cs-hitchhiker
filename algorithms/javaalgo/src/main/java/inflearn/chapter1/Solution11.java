package inflearn.chapter1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 12. 문자열 압축
// KKHSSSSSSSE
// KSTTTSEEKFKKKDJJGG
public class Solution11 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String str = br.readLine();

    System.out.println(solution(str));
    System.out.println(solution2(str));
  }

  private static String solution(String str) {
    int count = 0;
    char fc = str.charAt(0);
    String answer = String.valueOf(fc);

    for (int i = 0; i < str.length(); i++) {
      if (fc == str.charAt(i)) {
        count++;
        if (i == str.length() - 1) {
          answer += count;
        }
      } else {
        if (count > 1) {
          answer += count;
        }
        fc = str.charAt(i);
        answer += str.charAt(i);
        count = 1;
      }
    }

    return answer;
  }

  private static String solution2(String s) {
    String answer = "";
    s = s + " ";
    int count = 1;
    for (int i = 0; i < s.length() - 1; i++) {
      if (s.charAt(i) == s.charAt(i + 1)) {
        count++;
      } else {
        answer += s.charAt(i);
        if (count > 1) {
          answer += count;
        }
        count = 1;
      }
    }

    return answer;
  }
}
