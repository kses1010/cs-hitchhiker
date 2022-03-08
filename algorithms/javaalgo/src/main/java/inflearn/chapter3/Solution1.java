package inflearn.chapter3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Solution1 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    String[] str = br.readLine().split(" ");
    List<Integer> nArr = new ArrayList<>();
    for (String num : str) {
      nArr.add(Integer.parseInt(num));
    }

    int m = Integer.parseInt(br.readLine());
    String[] str2 = br.readLine().split(" ");
    List<Integer> mArr = new ArrayList<>();
    for (String num : str2) {
      mArr.add(Integer.parseInt(num));
    }

//    List<Integer> answers = solution(nArr, mArr);
//    for (Integer num : answers) {
//      System.out.print(num + " ");
//    }
    List<Integer> answers2 = solution2(nArr, mArr);
    for (Integer num : answers2) {
      System.out.print(num + " ");
    }
  }

  private static List<Integer> solution(List<Integer> nArr, List<Integer> mArr) {
    nArr.addAll(mArr);
    nArr.sort(null);
    return nArr;
  }

  // two pointer
  private static List<Integer> solution2(List<Integer> nArr, List<Integer> mArr) {
    List<Integer> answers = new ArrayList<>();
    int n = nArr.size();
    int m = mArr.size();
    int p1 = 0;
    int p2 = 0;
    while (p1 < n && p2 < m) {
      if (nArr.get(p1) < mArr.get(p2)) {
        answers.add(nArr.get(p1));
        p1++;
      } else {
        answers.add(mArr.get(p2));
        p2++;
      }
    }
    while (p1 < n) {
      answers.add(nArr.get(p1));
      p1++;
    }
    while (p2 < m) {
      answers.add(mArr.get(p2));
      p2++;
    }

    return answers;
  }
}
