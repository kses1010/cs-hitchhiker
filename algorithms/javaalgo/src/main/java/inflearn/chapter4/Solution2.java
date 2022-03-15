package inflearn.chapter4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

// 2. 아나그램
//AbaAeCe
//baeeACA
//
//abaCC
//Caaab
public class Solution2 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String str1 = br.readLine();
    String str2 = br.readLine();

    System.out.println(solution(str1, str2));
  }

  private static String solution(String str1, String str2) {
    Map<Character, Integer> map1 = new HashMap<>();
    Map<Character, Integer> map2 = new HashMap<>();
    for (char c : str1.toCharArray()) {
      map1.put(c, map1.getOrDefault(c, 0) + 1);
    }
    for (char c : str2.toCharArray()) {
      map2.put(c, map2.getOrDefault(c, 0) + 1);
    }

    for (Entry<Character, Integer> entry : map1.entrySet()) {
      if (map2.get(entry.getKey()) != entry.getValue()) {
        return "NO";
      }
    }
    return "YES";
  }

  private static String solution2(String str1, String str2) {
    Map<Character, Integer> map = new HashMap<>();
    for (char c : str1.toCharArray()) {
      map.put(c, map.getOrDefault(c, 0) + 1);
    }
    for (char c : str2.toCharArray()) {
      if (!map.containsKey(c) || map.get(c) == 0) {
        return "NO";
      }
      map.put(c, map.get(c) - 1);
    }
    return "YES";
  }
}
