package baekjoon.silver.silver4;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

// 9012
//6
//(())())
//(((()())()
//(()())((()))
//((()()(()))(((())))()
//()()()()(()()())()
//(()((())()(
public class Bracket {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    List<String> lists = new ArrayList<>();

    for (int i = 0; i < n; i++) {
      lists.add(sc.next());
    }

    List<String> answer = solution(lists);
    for (String s : answer) {
      System.out.println(s);
    }
  }

  private static List<String> solution(List<String> lists) {
    List<String> answers = new ArrayList<>();
    for (String s : lists) {
      answers.add(judge(s));
    }
    return answers;
  }

  private static String judge(String s) {
    Stack<Character> stack = new Stack<>();
    for (char c : s.toCharArray()) {
      if (c == '(') {
        stack.push(c);
      } else {
        if (stack.isEmpty()) {
          return "NO";
        } else {
          stack.pop();
        }
      }
    }
    if (!stack.isEmpty()) {
      return "NO";
    }
    return "YES";
  }
}
