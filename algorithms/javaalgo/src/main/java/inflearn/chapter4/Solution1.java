package inflearn.chapter4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

// 1. 학급 회장
//15
//BACBACCACCBDEDE
public class Solution1 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    String str = br.readLine();

    System.out.println(solution(str));
  }

  private static String solution(String candidates) {
    String answer = "";
    Map<Character, Integer> votes = new HashMap<>();
    char[] chars = candidates.toCharArray();
    for (char c : chars) {
      Integer count = votes.get(c);
      if (count == null) {
        votes.put(c, 1);
      } else {
        votes.put(c, count + 1);
      }
    }
    int maxVotes = Collections.max(votes.values());
    for (Entry<Character, Integer> entry : votes.entrySet()) {
      if (entry.getValue() == maxVotes) {
        answer = String.valueOf(entry.getKey());
      }
    }
    return answer;
  }

  private static char solution2(int n, String s) {
    char answer = ' ';
    Map<Character, Integer> map = new HashMap<>();
    for (char c : s.toCharArray()) {
      map.put(c, map.getOrDefault(c, 0) + 1);
    }
    int max = -1;
    for (Character key : map.keySet()) {
      if (map.get(key) > max) {
        max = map.get(key);
        answer = key;
      }
    }
    return answer;
  }
}
