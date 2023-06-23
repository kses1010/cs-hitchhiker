package programmers.level2.nlcm;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.Arrays;
import org.junit.jupiter.api.Test;

public class NLCMTest {

    @Test
    void test() {
        int[] arr1 = {2, 6, 8, 14};
        int[] arr2 = {1, 2, 3};

        assertAll(
            () -> assertThat(solution(arr1)).isEqualTo(168),
            () -> assertThat(solution(arr2)).isEqualTo(6)
        );
    }

    public int solution(int[] arr) {
        if (arr.length == 1) {
            return arr[0];
        }
        Arrays.sort(arr);

        int gcd = gcd(arr[0], arr[1]);
        int lcm = (arr[0] * arr[1]) / gcd;

        for (int i = 2; i < arr.length; i++) {
            gcd = gcd(lcm, arr[i]);
            lcm = (lcm * arr[i]) / gcd;
        }
        return lcm;
    }

    public int gcd(int num1, int num2) {
        if (num1 % num2 == 0) {
            return num2;
        }
        return gcd(num2, num1 % num2);
    }
}
