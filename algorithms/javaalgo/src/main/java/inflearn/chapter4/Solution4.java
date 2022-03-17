package inflearn.chapter4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

// 4. 모든 아나그램 찾기
//bacaAacba
//abc
public class Solution4 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String str1 = br.readLine();
    String str2 = br.readLine();

    System.out.println(solution(str1, str2));
  }

  private static int solution(String str1, String str2) {
    int answer = 0;
    Map<Character, Integer> map1 = new HashMap<>();
    Map<Character, Integer> map2 = new HashMap<>();
    for (char c : str2.toCharArray()) {
      map2.put(c, map2.getOrDefault(c, 0) + 1);
    }
    int length = str2.length() - 1;
    for (int i = 0; i < length; i++) {
      map1.put(str1.charAt(i), map1.getOrDefault(str1.charAt(i), 0) + 1);
    }

    int lt = 0;
    for (int rt = length; rt < str1.length(); rt++) {
      char rtChar = str1.charAt(rt);
      map1.put(rtChar, map1.getOrDefault(rtChar, 0) + 1);
      if (map1.equals(map2)) {
        answer++;
      }

      char ltChar = str1.charAt(lt);
      map1.put(ltChar, map1.get(ltChar) - 1);
      if (map1.get(ltChar) == 0) {
        map1.remove(ltChar);
      }
      lt++;
    }

    return answer;
  }
}
