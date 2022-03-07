package inflearn.chapter2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 11. 임시반장 정하기
//5
//2 3 1 7 3
//4 1 9 6 8
//5 5 2 4 4
//6 5 2 6 7
//8 4 2 2 2
public class Solution11 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int[][] arr = new int[n][n];

    for (int i = 0; i < n; i++) {
      String[] str = br.readLine().split(" ");
      for (int j = 0; j < n; j++) {
        arr[i][j] = Integer.parseInt(str[j]);
      }
    }

    System.out.println(solution2(n, arr));
  }

  private static int solution2(int n, int[][] arr) {
    int answer = 0;
    int max = Integer.MIN_VALUE;
    for (int i = 0; i < n; i++) {
      int count = 0;
      for (int j = 0; j < n; j++) {
        for (int k = 0; k < n; k++) {
          if (arr[i][k] == arr[j][k]) {
            count++;
            break;
          }
        }
      }
      if (count > max) {
        max = count;
        answer = i + 1;
      }
    }
    return answer;
  }

//  // 문제풀이 실패
//  private static int solution(int[][] arr) {
//    int answer = 0;
//    int n = arr[0].length;
//    int[] students = new int[n];
//
//    for (int j = 0; j < n; j++) {
//      Map<Integer, Boolean> banMap = new HashMap<>();
//      for (int i = 0; i < n; i++) {
//        for (int k = i + 1; k < n; k++) {
//          if (arr[i][j] == arr[k][j]) {
//            if (banMap.get(arr[i][j]) == null) {
//              banMap.put(arr[i][j], true);
//              students[i]++;
//              students[k]++;
//            } else if (banMap.get(arr[k][j])) {
//              students[k]++;
//            } else {
//              break;
//            }
//          }
//        }
//      }
//    }
//
//    for (int i = 0; i < students.length; i++) {
//      answer = students[i] > students[answer] ? i : answer;
//    }
//
//    return answer;
//  }
}
