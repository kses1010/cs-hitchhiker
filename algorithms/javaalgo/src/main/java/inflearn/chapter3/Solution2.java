package inflearn.chapter3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 2. 공통원소 구하기
//5
//1 3 9 5 2
//5
//3 2 5 7 8
public class Solution2 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    String[] str = br.readLine().split(" ");
    int[] nArr = new int[n];
    for (int i = 0; i < n; i++) {
      nArr[i] = Integer.parseInt(str[i]);
    }

    int m = Integer.parseInt(br.readLine());
    String[] str2 = br.readLine().split(" ");
    int[] mArr = new int[m];
    for (int i = 0; i < m; i++) {
      mArr[i] = Integer.parseInt(str2[i]);
    }

    List<Integer> nums = solution(nArr, mArr);
    for (Integer num : nums) {
      System.out.print(num + " ");
    }
  }

  private static List<Integer> solution(int[] nArr, int[] mArr) {
    int n = nArr.length;
    int m = mArr.length;
    int p1 = 0;
    int p2 = 0;
    Arrays.sort(nArr);
    Arrays.sort(mArr);

    List<Integer> answers = new ArrayList<>();
    while (p1 < n && p2 < m) {
      if (nArr[p1] == mArr[p2]) {
        answers.add(nArr[p1]);
        p1++;
        p2++;
      } else if (nArr[p1] < mArr[p2]) {
        p1++;
      } else {
        p2++;
      }
    }

    return answers;
  }
}
