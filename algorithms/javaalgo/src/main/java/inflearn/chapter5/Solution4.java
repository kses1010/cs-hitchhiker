package inflearn.chapter5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

// 4. 후위식 연산(postfix)
//352+*9-
public class Solution4 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String str = br.readLine();

    System.out.println(solution(str));
  }

  private static int solution(String str) {
    Stack<Integer> stack = new Stack<>();

    for (char c : str.toCharArray()) {
      if (Character.isDigit(c)) {
        stack.push(c - 48);
      } else if (c == '+') {
        Integer a = stack.pop();
        Integer b = stack.pop();
        stack.push(b + a);
      } else if (c == '-') {
        Integer a = stack.pop();
        Integer b = stack.pop();
        stack.push(b - a);
      } else if (c == '*') {
        Integer a = stack.pop();
        Integer b = stack.pop();
        stack.push(b * a);
      } else if (c == '/') {
        Integer a = stack.pop();
        Integer b = stack.pop();
        stack.push(b / a);
      }
    }

    return stack.pop();
  }
}
