package inflearn.chapter5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

// 6. 공주 구하기
// 8 3
public class Solution6 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] splits = br.readLine().split(" ");
    int n = Integer.parseInt(splits[0]);
    int k = Integer.parseInt(splits[1]);

    System.out.println(solution(n, k));
  }

  private static int solution(int n, int k) {
    int answer = 0;
    Queue<Integer> q = new LinkedList<>();
    for (int i = 1; i <= n; i++) {
      q.offer(i);
    }
    while (!q.isEmpty()) {
      for (int i = 1; i < k; i++) {
        q.offer(q.poll());
      }
      q.poll();
      if (q.size() == 1) {
        answer = q.poll();
      }
    }

    return answer;
  }
}
