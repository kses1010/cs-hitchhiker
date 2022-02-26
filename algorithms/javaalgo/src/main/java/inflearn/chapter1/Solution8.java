package inflearn.chapter1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 8.팰린드롬 (정규표현식과 replaceAll)
public class Solution8 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String str = br.readLine();

    System.out.println(solution(str));
    System.out.println(solution2(str));
  }

  private static String solution(String str) {
    String tmp = "";
    String reTmp = "";
    String reverse = new StringBuilder(str).reverse().toString();
    for (int i = 0; i < str.length(); i++) {
      if (Character.isAlphabetic(str.charAt(i))) {
        tmp += str.charAt(i);
        reTmp += reverse.charAt(i);
      }
    }

    if (tmp.equalsIgnoreCase(reTmp)) {
      return "YES";
    }
    return "NO";
  }

  private static String solution2(String str) {
    String reStr = str.toLowerCase().replaceAll("[^a-z]", "");
    String tmp = new StringBuilder(reStr).reverse().toString();

    if (reStr.equals(tmp)) {
      return "YES";
    }

    return "NO";
  }
}
