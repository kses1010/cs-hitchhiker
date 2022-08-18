package leetcode.number1to100.number1to10.number4;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

// 5.Longest Palindromic Substring
public class LongestPalindromicSubStringTest {

  private int start;
  private int maxLen;

  @Test
  void test() {
    String s1 = "babad";
    String s2 = "cbbd";

    assertThat(longestPalindrome(s1)).isEqualTo("bab");
    start = 0;
    maxLen = 0;
    assertThat(longestPalindrome(s2)).isEqualTo("bb");
  }

  private String longestPalindrome(String s) {
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

  private void expand(String s, int lt, int rt) {
    while (lt >= 0 && rt < s.length() && s.charAt(lt) == s.charAt(rt)) {
      lt--;
      rt++;
    }
    if (maxLen < rt - lt - 1) {
      start = lt + 1;
      maxLen = rt - lt - 1;
    }
  }
}
