package inflearn.chapter5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

// 2. 괄호문자제거
//(A(BC)D)EF(G(H)(IJ)K)LM(N)
public class Solution2 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String str = br.readLine();

    System.out.println(solution(str));
    System.out.println(solution2(str));
  }

  private static String solution(String str) {
    String answer = "";
    char[] chars = str.toCharArray();
    Deque<Character> stack = new ArrayDeque<>();
    for (char c : chars) {
      if (c == '(') {
        stack.add(c);
      } else if (c == ')') {
        stack.removeLast();
      }

      if (Character.isAlphabetic(c)) {
        if (stack.isEmpty()) {
          answer += c;
        }
      }
    }

    return answer;
  }

  private static String solution2(String str) {
    String answer = "";
    Stack<Character> stack = new Stack<>();
    for (char c : str.toCharArray()) {
      if (c == ')') {
        while (stack.pop() != '(') {
          ;
        }
      } else {
        stack.push(c);
      }
    }
    for (Character c : stack) {
      answer += c;
    }
    return answer;
  }
}
