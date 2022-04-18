package inflearn.chapter8.solution3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


// 3. 최대점수 구하기(DFS)
//5 20
//10 5
//25 12
//15 8
//6 3
//7 4
public class Solution3 {
  static int n;
  static int m;
  static int answer;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] splits = br.readLine().split(" ");
    n = Integer.parseInt(splits[0]);
    m = Integer.parseInt(splits[1]);
    int[] scoreArr = new int[n];
    int[] timeArr = new int[m];

    for (int i = 0; i < n; i++) {
      String[] strings = br.readLine().split(" ");
      scoreArr[i] = Integer.parseInt(strings[0]);
      timeArr[i] = Integer.parseInt(strings[1]);
    }

    dfs(0, 0, 0, scoreArr, timeArr);
    System.out.println(answer);
  }

  private static void dfs(int L, int sum, int time, int[] scoreArr, int[] timeArr) {
    if (time > m) {
      return;
    }
    if (L == n) {
      answer = Math.max(answer, sum);
    } else {
      dfs(L + 1, sum + scoreArr[L], time + timeArr[L], scoreArr, timeArr);
      dfs(L + 1, sum, time, scoreArr, timeArr);
    }
  }
}
