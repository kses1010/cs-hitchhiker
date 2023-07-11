package programmers.level2.discountevent;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Test;

public class DiscountEventTest {

    @Test
    void test() {
        String[] want1 = {"banana", "apple", "rice", "pork", "pot"};
        int[] number1 = {3, 2, 2, 2, 1};
        String[] discount1 = {"chicken", "apple", "apple", "banana", "rice", "apple", "pork", "banana", "pork", "rice",
            "pot", "banana", "apple", "banana"};

        String[] want2 = {"apple"};
        int[] number2 = {10};
        String[] discount2 = {"banana", "banana", "banana", "banana", "banana", "banana", "banana", "banana", "banana",
            "banana"};

        assertAll(
            () -> assertThat(solution(want1, number1, discount1)).isEqualTo(3),
            () -> assertThat(solution(want2, number2, discount2)).isEqualTo(0)
        );
    }

    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        Map<String, Integer> wantMap = new HashMap<>();
        for (int i = 0; i < want.length; i++) {
            wantMap.put(want[i], number[i]);
        }

        Map<String, Integer> discountMap = new HashMap<>();
        int left = 0;
        int right = 9;
        for (int i = left; i <= right; i++) {
            discountMap.put(discount[i], discountMap.getOrDefault(discount[i], 0) + 1);
        }

        if (isEqual(wantMap, discountMap)) {
            answer++;
        }

        while (right < discount.length) {
            discountMap.put(discount[left], discountMap.get(discount[left]) - 1);
            left++;
            right++;
            if (right == discount.length) {
                break;
            }
            discountMap.put(discount[right], discountMap.getOrDefault(discount[right], 0) + 1);

            if (isEqual(wantMap, discountMap)) {
                answer++;
            }
        }

        return answer;
    }

    public boolean isEqual(Map<String, Integer> wantMap, Map<String, Integer> discountMap) {
        for (String want : wantMap.keySet()) {
            if (!discountMap.containsKey(want) || wantMap.get(want) != discountMap.get(want)) {
                return false;
            }
        }
        return true;
    }
}
