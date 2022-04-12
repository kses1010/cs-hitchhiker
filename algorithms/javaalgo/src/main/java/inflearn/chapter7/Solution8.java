package inflearn.chapter7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

// 8. 송아지 찾기 1(BFS)
// 5 14
public class Solution8 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] splits = br.readLine().split(" ");
    int s = Integer.parseInt(splits[0]);
    int e = Integer.parseInt(splits[1]);

    System.out.println(solution(s,e));
  }

  private static int solution(int s, int e) {
    int[] dist = {-1, 1, 5};
    int[] checks = new int[10001];
    Queue<Integer> q = new LinkedList<>();

    q.offer(s);
    checks[s] = 1;
    int level = 0;

    while (!q.isEmpty()) {
      int len = q.size();
      for (int i = 0; i < len; i++) {
        int x = q.poll();
        if (x == e) {
          return level;
        }
        for (int d : dist) {
          int nx = x + d;
          if (nx >= 1 && nx <= 10001 && checks[nx] == 0) {
            checks[nx] = 1;
            q.offer(nx);
          }
        }
      }
      level++;
    }
    return 0;
  }
}
