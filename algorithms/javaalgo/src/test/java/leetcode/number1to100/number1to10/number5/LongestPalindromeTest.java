package leetcode.number1to100.number1to10.number5;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class LongestPalindromeTest {

  int start;
  int maxLen;

  public String longestPalindrome(String s) {
    int length = s.length();
    if (length < 2) {
      return s;
    }
    for (int i = 0; i < length - 1; i++) {
      expand(s, i, i);
      expand(s, i, i + 1);
    }
    return s.substring(start, start + maxLen);
  }

  public void expand(String s, int lt, int rt) {
    while (lt >= 0 && rt < s.length() && s.charAt(lt) == s.charAt(rt)) {
      lt--;
      rt++;
    }
    if (maxLen < rt - lt - 1) {
      start = lt + 1;
      maxLen = rt - lt - 1;
    }
  }

  @Test
  void test01() {
    String s = "babad";

    assertThat(longestPalindrome(s)).isEqualTo("bab");
  }
}
