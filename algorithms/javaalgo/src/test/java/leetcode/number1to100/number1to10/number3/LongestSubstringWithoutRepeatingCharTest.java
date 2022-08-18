package leetcode.number1to100.number1to10.number3;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.LinkedHashMap;
import java.util.Map;
import org.junit.jupiter.api.Test;

// 3. Longest Substring Without Repeating Characters
public class LongestSubstringWithoutRepeatingCharTest {

  @Test
  void test() {
    String s1 = "abcabcbb";
    String s2 = "bbbb";
    String s3 = "pwwkew";

    assertAll(
        () -> assertThat(lengthOfLongestSubstring(s1)).isEqualTo(3),
        () -> assertThat(lengthOfLongestSubstring(s2)).isEqualTo(1),
        () -> assertThat(lengthOfLongestSubstring(s3)).isEqualTo(3)
    );
  }

  private int lengthOfLongestSubstring(String s) {
    Map<Character, Integer> wordMap = new LinkedHashMap<>();
    int start = 0;
    int result = 0;

    char[] charArray = s.toCharArray();

    for (int i = 0; i < charArray.length; i++) {
      char c = charArray[i];
      if (wordMap.get(c) != null && start <= wordMap.get(c)) {
        start = wordMap.get(c) + 1;
      } else {
        result = Math.max(result, i - start + 1);
      }
      wordMap.put(c, i);
    }

    return result;
  }
}
