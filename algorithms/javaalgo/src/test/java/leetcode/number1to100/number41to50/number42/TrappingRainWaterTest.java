package leetcode.number1to100.number41to50.number42;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class TrappingRainWaterTest {

  @Test
  void test() {
    int[] height1 = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
    int[] height2 = {4, 2, 0, 3, 2, 5};

    assertThat(trap(height1)).isEqualTo(6);
    assertThat(trap(height2)).isEqualTo(9);
  }

  public int trap(int[] height) {
    int answer = 0;

    int length = height.length;
    if (length == 0) {
      return answer;
    }
    int lt = 0;
    int rt = length - 1;
    int ltMax = height[lt];
    int rtMax = height[rt];

    while (lt < rt) {
      ltMax = Math.max(ltMax, height[lt]);
      rtMax = Math.max(rtMax, height[rt]);

      if (ltMax <= rtMax) {
        answer += ltMax - height[lt];
        lt++;
      } else {
        answer += rtMax - height[rt];
        rt--;
      }
    }
    return answer;
  }
}
