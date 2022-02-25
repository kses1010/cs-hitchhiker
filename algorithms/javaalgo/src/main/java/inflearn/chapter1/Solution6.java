package inflearn.chapter1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashSet;
import java.util.Set;

// 6. 중복문자제거
public class Solution6 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String str = br.readLine();

    System.out.println(solution(str));
    System.out.println(solution2(str));
  }

  private static String solution(String str) {
    StringBuilder sb = new StringBuilder();
    char[] chars = str.toCharArray();
    Set<Character> charSets = new LinkedHashSet<>();
    for (char c : chars) {
      charSets.add(c);
    }

    for (Character c : charSets) {
      sb.append(c);
    }

    return sb.toString();
  }

  private static String solution2(String str) {
    String answer = "";
    for (int i = 0; i < str.length(); i++) {
      // indexOf(): 해당 원소가 처음 발견되는 인덱스
      if (str.indexOf(str.charAt(i)) == i) {
        answer += str.charAt(i);
      }
    }
    return answer;
  }
}
