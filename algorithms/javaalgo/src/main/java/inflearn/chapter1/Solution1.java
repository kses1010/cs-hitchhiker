package inflearn.chapter1;

import java.util.Scanner;

public class Solution1 {

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    String str = in.next();
    char c = in.next().toLowerCase().charAt(0);

    char[] chars = str.toLowerCase().toCharArray();
    int count = 0;
    for (char c1 : chars) {
      if (c1 == c) {
        count++;
      }
    }
    System.out.println(count);
  }
}
