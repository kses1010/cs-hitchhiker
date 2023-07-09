package programmers.level2.tuple;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.Set;
import org.junit.jupiter.api.Test;

public class TupleTest {

    @Test
    void test() {
        String s1 = "{{2},{2,1},{2,1,3},{2,1,3,4}}";
        String s2 = "{{1,2,3},{2,1},{1,2,4,3},{2}}";
        String s3 = "{{20,111},{111}}";
        String s4 = "{{123}}";
        String s5 = "{{4,2,3},{3},{2,3,4,1},{2,3}}";

        assertAll(
            () -> assertThat(solution(s1)).isEqualTo(new int[]{2, 1, 3, 4}),
            () -> assertThat(solution(s2)).isEqualTo(new int[]{2, 1, 3, 4}),
            () -> assertThat(solution(s3)).isEqualTo(new int[]{111, 20}),
            () -> assertThat(solution(s4)).isEqualTo(new int[]{123}),
            () -> assertThat(solution(s5)).isEqualTo(new int[]{3, 2, 4, 1})
        );
    }

    public int[] solution(String s) {
        Set<Integer> answer = new LinkedHashSet<>();
        s = s.substring(2);
        s = s.substring(0, s.length() - 2).replace("},{", "-");
        String[] splits = s.split("-");
        Arrays.sort(splits, Comparator.comparingInt(String::length));

        for (String str : splits) {
            String[] strArr = str.split(",");
            for (String num : strArr) {
                answer.add(Integer.parseInt(num));
            }
        }

        return answer.stream().mapToInt(i -> i).toArray();
    }
}
