package inflearn.chapter1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 5. 특정 문자 뒤집기
public class Solution5 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String str = br.readLine();

    System.out.println(solution(str));
  }

  private static String solution(String str) {
    char[] chars = str.toCharArray();
    int lt = 0;
    int rt = chars.length - 1;
    while (lt < rt) {
      if (!Character.isAlphabetic(chars[lt])) {
        lt++;
      } else if (!Character.isAlphabetic(chars[rt])) {
        rt--;
      } else {
        char tmp = chars[lt];
        chars[lt] = chars[rt];
        chars[rt] = tmp;
        lt++;
        rt--;
      }
    }
    return String.valueOf(chars);
  }
}
