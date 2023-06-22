package programmers.level1.smallsubstring;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import org.junit.jupiter.api.Test;

public class SmallSubStringTest {

    @Test
    void test() {
        String t1 = "3141592";
        String t2 = "500220839878";
        String t3 = "10203";

        String p1 = "271";
        String p2 = "7";
        String p3 = "15";

        assertAll(
            () -> assertThat(solution(t1, p1)).isEqualTo(2),
            () -> assertThat(solution(t2, p2)).isEqualTo(8),
            () -> assertThat(solution(t3, p3)).isEqualTo(3)
        );
    }

    public int solution(String t, String p) {
        int len = p.length();
        long num = Long.parseLong(p);
        int result = 0;

        for (int i = 0; i < t.length() - len + 1; i++) {
            long diff = Long.parseLong(t.substring(i, i + len));
            if (diff <= num) {
                result++;
            }
        }
        return result;
    }
}
