package inflearn.chapter10;

import java.util.Scanner;

// 3. 최대 부분 증가수열
//8
//5 3 7 8 6 2 9 4
public class Solution3 {

  static int[] dy;

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int[] arr = new int[n];
    dy = new int[n];

    for (int i = 0; i < n; i++) {
      arr[i] = sc.nextInt();
    }

    System.out.println(solution(arr));
  }

  private static int solution(int[] arr) {
    int answer = 0;
    int n = arr.length;
    dy[0] = 1;
    for (int i = 1; i < n; i++) {
      int max = 0;
      for (int j = i - 1; j >= 0; j--) {
        if (arr[j] < arr[i] && dy[j] > max) {
          max = dy[j];
        }
        dy[i] = max + 1;
        answer = Math.max(answer, dy[i]);
      }
    }

    return answer;
  }
}
