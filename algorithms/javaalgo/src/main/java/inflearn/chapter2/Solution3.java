package inflearn.chapter2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

// 3. 가위바위보
//5
//2 3 3 1 3
//1 1 2 2 3
public class Solution3 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    String a = br.readLine();
    String b = br.readLine();

    List<String> solution = solution(n, a, b);
    for (String s : solution) {
      System.out.println(s);
    }
  }

  private static List<String> solution(int n, String a, String b) {
    String[] splitA = a.split(" ");
    int[] numA = new int[splitA.length];
    for (int i = 0; i < splitA.length; i++) {
      numA[i] = Integer.parseInt(splitA[i]);
    }

    String[] splitB = b.split(" ");
    int[] numB = new int[splitB.length];
    for (int i = 0; i < splitB.length; i++) {
      numB[i] = Integer.parseInt(splitB[i]);
    }

    List<String> answers = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      if (numA[i] == numB[i]) {
        answers.add("D");
      } else if ((numA[i] == 1 && numB[i] == 2) || (numA[i] == 2 && numB[i] == 3) || (numA[i] == 3 && numB[i] == 1)) {
        answers.add("B");
      } else {
        answers.add("A");
      }
    }

    return answers;
  }
}
