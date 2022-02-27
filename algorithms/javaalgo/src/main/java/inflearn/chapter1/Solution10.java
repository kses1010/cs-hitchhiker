package inflearn.chapter1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 10. 가장 짧은 문자거리
// teachermode e
public class Solution10 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String str = br.readLine();
    String[] splits = str.split(" ");
    String s = splits[0];
    char t = splits[1].charAt(0);

    for (int i : solution(s, t)) {
      System.out.print(i + " ");
    }
  }

  private static int[] solution(String s, char t) {
    int[] answer = new int[s.length()];
    int p = 1000;
    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) == t) {
        p = 0;
      } else {
        p++;
      }
      answer[i] = p;
    }
    p = 1000;
    for (int i = s.length() - 1; i >= 0; i--) {
      if (s.charAt(i) == t) {
        p = 0;
      } else {
        p++;
        answer[i] = Math.min(answer[i], p);
      }
    }
    return answer;
  }
}
