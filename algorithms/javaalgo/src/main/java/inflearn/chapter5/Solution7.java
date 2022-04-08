package inflearn.chapter5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

// 7. 교육과정 설계
// CBA
// CBDAGE
public class Solution7 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String needSub = br.readLine();
    String plan = br.readLine();

    System.out.println(solution(needSub, plan));
  }

  private static String solution(String needSub, String plan) {
    Queue<Character> q = new LinkedList<>();
    for (char c : needSub.toCharArray()) {
      q.offer(c);
    }

    for (char subject : plan.toCharArray()) {
      if (q.isEmpty()) {
        return "YES";
      }
      if (q.peek() == subject) {
        q.poll();
      }
    }

    return "NO";
  }
}
