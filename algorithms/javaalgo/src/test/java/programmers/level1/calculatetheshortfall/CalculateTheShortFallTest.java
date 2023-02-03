package programmers.level1.calculatetheshortfall;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class CalculateTheShortFallTest {

    @Test
    void test() {
        assertThat(solution(3, 20, 4)).isEqualTo(10);
    }

    public long solution(int price, int money, int count) {
        long totalPrice = 0;
        for (int i = 1; i <= count; i++) {
            totalPrice += (long) price * i;
        }
        long rest = totalPrice - money;
        return Math.max(rest, 0);
    }
}
