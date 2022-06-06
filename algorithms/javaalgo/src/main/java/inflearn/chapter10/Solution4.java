package inflearn.chapter10;

import java.util.Arrays;
import java.util.Scanner;

class Brick implements Comparable<Brick>{
  int area;
  int h;
  int w;

  public Brick(int area, int h, int w) {
    this.area = area;
    this.h = h;
    this.w = w;
  }

  @Override
  public int compareTo(Brick o) {
    return o.area - this.area;
  }
}

// 4. 가장 높은 탑 쌓기(LIS)
//5
//25 3 4
//4 4 6
//9 2 3
//16 2 5
//1 5 2
public class Solution4 {

  static int[] dy;

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    Brick[] arr = new Brick[n];
    dy = new int[n];

    for (int i = 0; i < n; i++) {
      int area = sc.nextInt();
      int h = sc.nextInt();
      int w = sc.nextInt();
      arr[i] = new Brick(area, h, w);
    }

    System.out.println(solution(arr));
  }

  private static int solution(Brick[] arr) {
    int answer;
    Arrays.sort(arr);
    dy[0] = arr[0].h;
    answer = dy[0];
    for (int i = 1; i < arr.length; i++) {
      int max = 0;
      for (int j = i - 1; j >= 0; j--) {
        if (arr[j].w > arr[i].w && dy[j] > max) {
          max = dy[j];
        }
      }
      dy[i] = max + arr[i].h;
      answer = Math.max(answer, dy[i]);
    }

    return answer;
  }
}
