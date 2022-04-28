package inflearn.chapter8.solution14;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

class Point {
  int x;
  int y;

  public Point(int x, int y) {
    this.x = x;
    this.y = y;
  }
}

// 14. 피자 배달 거리
//4 4
//0 1 2 0
//1 0 2 1
//0 2 1 2
//2 0 1 2
public class Solution14 {
  static int n;
  static int m;
  static int len;
  static int answer = Integer.MAX_VALUE;
  static int[] combi;
  static ArrayList<Point> pz;
  static ArrayList<Point> hs;

  public static void main(String[] args) throws IOException {
    Scanner sc = new Scanner(System.in);
    n = sc.nextInt();
    m = sc.nextInt();
    pz = new ArrayList<>();
    hs = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        int tmp = sc.nextInt();
        if (tmp == 1) {
          hs.add(new Point(i, j));
        } else if (tmp == 2) {
          pz.add(new Point(i, j));
        }
      }
    }

    len = pz.size();
    combi = new int[m];
    dfs(0, 0);

    System.out.println(answer);
  }

  private static void dfs(int L, int s) {
    if (L == m) {
      int sum = 0;
      for (Point h : hs) {
        int dis = Integer.MAX_VALUE;
        for (int i : combi) {
          dis = Math.min(dis, Math.abs(h.x - pz.get(i).x) + Math.abs(h.y - pz.get(i).y));
        }
        sum += dis;
      }
      answer = Math.min(answer, sum);
    } else {
      for (int i = s; i < len; i++) {
        combi[L] = i;
        dfs(L + 1, i + 1);
      }
    }
  }
}
