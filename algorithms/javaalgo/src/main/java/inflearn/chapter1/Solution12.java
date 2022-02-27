package inflearn.chapter1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

// 12. 암호
//4
//#****###**#####**#####**##**
public class Solution12 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int strLength = Integer.parseInt(br.readLine());
    String str = br.readLine();

    System.out.println(solution(str, strLength));
    System.out.println(solution2(strLength, str));
  }

  private static String solution(String str, int strLength) {
    String answer = "";
    String replaceStr = str.replaceAll("#", "1").replaceAll("\\*", "0");
    List<String> splits = new ArrayList<>();
    int index = 0;
    int count = 0;
    while (count < strLength) {
      splits.add(replaceStr.substring(index, Math.min(index + 7, replaceStr.length())));
      index += 7;
      count++;
    }
    
    for (String s : splits) {
      int num = Integer.valueOf(s, 2);
      char c = (char) num;
      answer += c;
    }
    return answer;
  }

  private static String solution2(int n, String s) {
    String answer = "";
    for (int i = 0; i < n; i++) {
      String tmp = s.substring(0, 7).replace("#", "1").replace("*", "0");
      int num = Integer.valueOf(tmp, 2);
      answer += (char) num;
      s = s.substring(7);
    }

    return answer;
  }
}
