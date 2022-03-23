package inflearn.chapter5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

// 1. 올바른 괄호
//(()(()))(()
public class Solution1 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String str = br.readLine();

    System.out.println(solution(str));
  }

  private static String solution(String str) {
    char[] chars = str.toCharArray();
    Deque<Character> stack = new ArrayDeque<>();
    for (char c : chars) {
      if (c == '(') {
        stack.add(c);
      } else {
        if (stack.isEmpty()) {
          return "NO";
        }
        stack.removeLast();
      }
    }
    if (stack.isEmpty()) {
      return "YES";
    }
    return "NO";
  }
}
