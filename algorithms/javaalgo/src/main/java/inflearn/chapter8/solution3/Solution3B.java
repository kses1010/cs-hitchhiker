package inflearn.chapter8.solution3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 객체로 풀기
class Problem {

  int score;
  int time;

  public Problem(int score, int time) {
    this.score = score;
    this.time = time;
  }
}

public class Solution3B {

  static int n;
  static int m;
  static int answer;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] splits = br.readLine().split(" ");
    n = Integer.parseInt(splits[0]);
    m = Integer.parseInt(splits[1]);
    Problem[] arr = new Problem[n];

    for (int i = 0; i < n; i++) {
      String[] strings = br.readLine().split(" ");
      arr[i] = new Problem(Integer.parseInt(strings[0]), Integer.parseInt(strings[1]));
    }

    dfs(0, 0, 0, arr);
    System.out.println(answer);
  }

  private static void dfs(int L, int score, int time, Problem[] arr) {
    if (time > m) {
      return;
    }
    if (L == n) {
      answer = Math.max(answer, score);
    } else {
      dfs(L + 1, score + arr[L].score, time + arr[L].time, arr);
      dfs(L + 1, score, time, arr);
    }
  }
}
