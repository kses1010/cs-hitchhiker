package programmers.level2.binarychangerepeat;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import org.junit.jupiter.api.Test;

public class BinaryScaleChangeRepeatTest {

    @Test
    void test() {
        String s1 = "110010101001";
        String s2 = "01110";
        String s3 = "1111111";

        assertAll(
            () -> assertThat(solution(s1)).isEqualTo(new int[]{3, 8}),
            () -> assertThat(solution(s2)).isEqualTo(new int[]{3, 3}),
            () -> assertThat(solution(s3)).isEqualTo(new int[]{4, 1})
        );
    }

    public int[] solution(String s) {
        int[] answer = new int[2];

        while (s.length() > 1) {
            int oneCount = 0;

            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '0') {
                    answer[1]++;
                } else {
                    oneCount++;
                }
            }
            s = Integer.toBinaryString(oneCount);
            answer[0]++;
        }
        return answer;
    }
}
