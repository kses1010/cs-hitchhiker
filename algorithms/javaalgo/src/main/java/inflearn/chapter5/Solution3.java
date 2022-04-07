package inflearn.chapter5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

// 3. 크레인 인형뽑기(카카오)
//5
//0 0 0 0 0
//0 0 1 0 3
//0 2 5 0 1
//4 2 4 4 2
//3 5 1 3 1
//8
//1 5 3 5 1 2 1 4
public class Solution3 {

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

    int m = Integer.parseInt(br.readLine());
    String[] splits = br.readLine().split(" ");
    int[] moves = new int[m];
    for (int i = 0; i < m; i++) {
      moves[i] = Integer.parseInt(splits[i]);
    }

    System.out.println(solution(arr, moves));
  }

  private static int solution(int[][] board, int[] moves) {
    int answer = 0;
    int n = board.length;
    Stack<Integer> basket = new Stack<>();
    basket.push(0);

    for (int move : moves) {
      for (int x = 0; x < n; x++) {
        if (board[x][move - 1] != 0) {
          if (basket.peek() == board[x][move - 1]) {
            basket.pop();
            answer += 2;
          } else {
            basket.push(board[x][move - 1]);
          }
          board[x][move - 1] = 0;
          break;
        }
      }
    }

    return answer;
  }
}
