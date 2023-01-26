package leetcode.number701to800.number771to780.number777;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import org.junit.jupiter.api.Test;

public class SwapAdjacentInLRStringTest {

    @Test
    void test() {
        String start1 = "RXXLRXRXL";
        String end1 = "XRLXXRRLX";

        assertAll(
            () -> assertThat(canTransform(start1, end1)).isTrue(),
            () -> assertThat(canTransform("X", "L")).isFalse()
        );
    }

    public boolean canTransform(String start, String end) {
        int s = 0;
        int e = 0;
        char[] startArray = start.toCharArray();
        char[] endArray = end.toCharArray();

        while (s < startArray.length || e < endArray.length) {
            // X 가 아닌 문자까지 이동
            while (s < startArray.length && startArray[s] == 'X') {
                s++;
            }
            while (e < endArray.length && endArray[e] == 'X') {
                e++;
            }

            if (s >= startArray.length || e >= endArray.length) {
                break;
            }

            // 바꿔야 할 문자열이 서로 다른 경우
            if (startArray[s] != endArray[e]) {
                return false;
            }
            // RX XR 아닌 RRX XR 일 경우
            if (startArray[s] == 'R' && s > e) {
                return false;
            }
            // XL LX 아닌 LX XL 일 경우
            if (startArray[s] == 'L' && s < e) {
                return false;
            }
            s++;
            e++;
        }
        return s == e;
    }
}
