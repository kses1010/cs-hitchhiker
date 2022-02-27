package inflearn.chapter1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 9. 숫자만 추출
public class Solution9 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    // g0en2T0s8eSoft
    String str = br.readLine();

    System.out.println(solution(str));
    System.out.println(solution2(str));
  }

  private static int solution(String str) {
    String tmp = "";
    char[] chars = str.toCharArray();
    for (char c : chars) {
      if (Character.isDigit(c)) {
        tmp += c;
      }
    }
    return Integer.parseInt(tmp);
  }

  public static int solution2(String str) {
    int answer = 0;
    for (char x : str.toCharArray()) {
      // 아스키 숫자로 해결하기
      if (x >= 48 && x <= 57) {
        answer = answer * 10 + (x - 48);
      }
    }
    return answer;
  }
}
