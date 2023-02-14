package programmers.level2.nextbignumber;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import org.junit.jupiter.api.Test;

public class NextBigNumberTest {

    @Test
    void test() {
        assertAll(
            () -> assertThat(solution(78)).isEqualTo(83),
            () -> assertThat(solution(15)).isEqualTo(23)
        );
    }

    public int solution(int n) {
        int bitCount = Integer.bitCount(n);
        for (int i = n + 1; i < Integer.MAX_VALUE; i++) {
            int greaterNumberCount = Integer.bitCount(i);
            if (bitCount == greaterNumberCount) {
                return i;
            }
        }
        return 0;
    }
}
