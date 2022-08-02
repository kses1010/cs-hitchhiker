package leetcode.number7;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import org.junit.jupiter.api.Test;

// 7. Reverse Integer
public class ReverseIntegerTest {

  @Test
  void test() {
    int x1 = 123;
    int x2 = -123;
    int x3 = 120;

    assertAll(
        () -> assertThat(reverse(x1)).isEqualTo(321),
        () -> assertThat(reverse(x2)).isEqualTo(-321),
        () -> assertThat(reverse(x3)).isEqualTo(21)
    );
  }

  public int reverse(int x) {
    long r = 0;
    while (x != 0) {
      r = r * 10 + x % 10;
      x /= 10;
    }
    if (r >= Integer.MIN_VALUE && r <= Integer.MAX_VALUE) {
      return (int) r;
    }
    return 0;
  }
}
