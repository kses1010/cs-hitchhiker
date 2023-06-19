package boostcamp.solution1;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import org.junit.jupiter.api.Test;

public class Solution1Test {

    @Test
    void test() {
        int[] arr1 = {1, 2, 3, 3, 3, 3, 4, 4};
        int[] arr2 = {3, 2, 4, 4, 2, 5, 2, 5, 5};
        int[] arr3 = {3, 5, 7, 9, 1};

        assertAll(
            () -> assertThat(solution(arr1)).isEqualTo(new int[]{4, 2}),
            () -> assertThat(solution(arr2)).isEqualTo(new int[]{3, 2, 3}),
            () -> assertThat(solution(arr3)).isEqualTo(new int[]{-1})
        );
    }

    public int[] solution(int[] arr) {
        // 배열의 길이가 2미만일 경우
        if (arr.length < 2) {
            return new int[]{-1};
        }
        // 배열 오름차순으로 정렬
        Arrays.sort(arr);
        List<Integer> answerList = new ArrayList<>();
        Map<Integer, Integer> maps = new HashMap<>();
        for (int i : arr) {
            maps.put(i, maps.getOrDefault(i, 0) + 1);
        }
        for (Entry<Integer, Integer> entry : maps.entrySet()) {
            if (entry.getValue() > 1) {
                answerList.add(entry.getValue());
            }
        }

        // 정답 리스트가 비어있다면 -1 리턴
        if (answerList.isEmpty()) {
            return new int[]{-1};
        }

        return answerList.stream().mapToInt(i -> i).toArray();
    }
}
