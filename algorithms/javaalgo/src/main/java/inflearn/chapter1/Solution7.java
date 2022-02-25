package inflearn.chapter1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 7. 회전문자열
public class Solution7 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String str = br.readLine();

    System.out.println(solution(str));
    System.out.println(solution2(str));
  }

  private static String solution(String str) {
    String s = str.toLowerCase();
    int lt = 0;
    int rt = s.length() - 1;
    while (lt < rt) {
      if (s.charAt(lt) != s.charAt(rt)) {
        return "NO";
      }
      lt++;
      rt--;
    }
    return "YES";
  }

  private static String solution2(String str) {
    String s = str.toLowerCase();
    int len = s.length();
    for (int i = 0; i < len / 2; i++) {
      if (s.charAt(i) != s.charAt(len - i - 1)) {
        return "NO";
      }
    }
    return "YES";
  }
}
