package inflearn.chapter1;

import java.util.Scanner;

public class Solution3 {

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    String str = in.nextLine();
    System.out.println(solution(str));
  }

  public static String solution(String str) {
    String answer = "";
    String[] strArr = str.split(" ");

    for (String s : strArr) {
      if (answer.length() < s.length()) {
        answer = s;
      }
    }

    return answer;
  }
}
