package inflearn.chapter4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

// 3. 매출액의 종류
//7 4
//20 12 20 10 23 17 10
public class Solution3 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] str = br.readLine().split(" ");
    String[] strs = br.readLine().split(" ");
    int n = Integer.parseInt(str[0]);
    int k = Integer.parseInt(str[1]);

    int[] incomes = new int[n];
    for (int i = 0; i < n; i++) {
      incomes[i] = Integer.parseInt(strs[i]);
    }

    List<Integer> answers = solution2(n, k, incomes);
    for (Integer answer : answers) {
      System.out.print(answer + " ");
    }
  }

  private static List<Integer> solution(int n, int k, int[] arr) {
    List<Integer> answer = new ArrayList<>();
    Set<Integer> sets = new HashSet<>();

    int lt = 0;

    for (int rt = k - 1; rt < n; rt++) {
      for (int i = lt; i < rt + 1; i++) {
        sets.add(arr[i]);
      }
      int size = sets.size();
      answer.add(size);
      sets.clear();
      lt++;
    }
    return answer;
  }

  private static List<Integer> solution2(int n, int k, int[] arr) {
    List<Integer> answer = new ArrayList<>();
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < k - 1; k++) {
      map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
    }
    int lt = 0;
    for (int rt = k - 1; rt < n; rt++) {
      map.put(arr[rt], map.getOrDefault(arr[rt], 0) + 1);
      answer.add(map.size());
      map.put(arr[lt], map.get(arr[lt]) - 1);
      if (map.get(arr[lt]) == 0) {
        map.remove(arr[lt]);
      }
      lt++;
    }
    return answer;
  }
}
