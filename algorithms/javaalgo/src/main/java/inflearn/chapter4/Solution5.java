package inflearn.chapter4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.Set;
import java.util.TreeSet;

// 5. K번쨰 큰 수
//10 3
//13 15 34 23 45 65 33 11 26 42
public class Solution5 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] splits = br.readLine().split(" ");
    int n = Integer.parseInt(splits[0]);
    int k = Integer.parseInt(splits[1]);
    int[] arr = new int[n];

    String[] strNums = br.readLine().split(" ");
    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(strNums[i]);
    }

    System.out.println(solution(k, arr));
  }

  private static int solution(int k, int[] arr) {
    int answer = -1;
    int n = arr.length;
    Set<Integer> sumSet = new TreeSet<>(Collections.reverseOrder());
    for (int i = 0; i < n; i++) {
      for (int j = i + 1; j < n; j++) {
        for (int h = j + 1; h < n; h++) {
          sumSet.add(arr[i] + arr[j] + arr[h]);
        }
      }
    }

    int count = 0;
    for (Integer sum : sumSet) {
      count++;
      if (count == k) {
        return sum;
      }
    }
    return answer;
  }
}
