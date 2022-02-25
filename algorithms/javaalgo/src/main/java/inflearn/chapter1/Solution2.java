package inflearn.chapter1;

import java.util.Scanner;

public class Solution2 {

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    String str = in.next();
    System.out.println(solution(str));
  }

  public static String solution(String str) {
    String answer = "";
    for (char c : str.toCharArray()) {
      if (Character.isLowerCase(c)) {
        answer += Character.toUpperCase(c);
      } else {
        answer += Character.toLowerCase(c);
      }
    }

    return answer;
  }


  /*
    아스키 넘버
    대문자는 65 ~ 90 (소문자로 바꾸려면 32를 더하고)
    소문자는 97 ~ 122 (대문자로 바꾸려면 32를 빼고)
   */
}
