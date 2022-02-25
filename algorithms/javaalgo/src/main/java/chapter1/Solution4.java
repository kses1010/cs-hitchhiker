package chapter1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution4 {

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int count = in.nextInt();
    String[] strs = new String[count];
    for (int i = 0; i < count; i++) {
      strs[i] = in.next();
    }

    for (String s : solution2(strs)) {
      System.out.println(s);
    }

    for (String s : solution1(strs)) {
      System.out.println(s);
    }
  }

  public static List<String> solution1(String[] strs) {
    List<String> answers = new ArrayList<>();
    for (String str : strs) {
      StringBuilder sb = new StringBuilder(str);
      answers.add(sb.reverse().toString());
    }
    return answers;
  }

  public static List<String> solution2(String[] str) {
    List<String> answers = new ArrayList<>();
    for (String s : str) {
      char[] charArray = s.toCharArray();
      int lt = 0;
      int rt = charArray.length - 1;
      while(lt < rt) {
        char tmp = charArray[lt];
        charArray[lt] = charArray[rt];
        charArray[rt] = tmp;
        lt++;
        rt--;
      }
      String tmp = String.valueOf(charArray);
      answers.add(tmp);
    }

    return answers;
  }
}
