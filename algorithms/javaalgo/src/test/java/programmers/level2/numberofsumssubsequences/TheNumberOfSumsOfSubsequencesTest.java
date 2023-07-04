package programmers.level2.numberofsumssubsequences;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.Test;

public class TheNumberOfSumsOfSubsequencesTest {

    @Test
    void test() {
        int[] elements = {7, 9, 1, 1, 4};

        assertThat(solution(elements)).isEqualTo(18);
    }

    public int solution(int[] elements) {
        Set<Integer> answers = new HashSet<>();
        int length = elements.length;
        for (int size = 1; size <= length; size++) {
            for (int i = 0; i < length; i++) {
                int sum = 0;
                for (int j = i; j < i + size; j++) {
                    sum += elements[j % length];
                }
                answers.add(sum);
            }
        }

        return answers.size();
    }
}
