package programmers.level2.kprimenumber;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import org.junit.jupiter.api.Test;

public class KPrimeNumberTest {

    @Test
    void test() {
        int n1 = 437674;
        int k1 = 3;

        int n2 = 110011;
        int k2 = 10;

        assertAll(
            () -> assertThat(solution(n1, k1)).isEqualTo(3),
            () -> assertThat(solution(n2, k2)).isEqualTo(2)
        );
    }

    public int solution(int n, int k) {
        int answer = 0;
        String kNum = Integer.toString(n, k); // K 진수 만드는 함수
        String[] splits = kNum.split("0");

        for (String s : splits) {
            if (!s.equals("")) {
                long pNum = Long.parseLong(s);
                if (isPrime(pNum)) {
                    answer++;
                }
            }
        }
        return answer;
    }

    // k 진수 만들기
    public String convertKNum(int n, int k) {
        String num = "";
        while (n != 0) {
            num = n % k + num;
            n /= k;
        }
        return num;
    }

    // 소수 판별(에라토스테네스 체)
    public boolean isPrime(long num) {
        if (num < 2) {
            return false;
        }

        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
