package leetcode.number1to100.number51to60.number56;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import org.junit.jupiter.api.Test;

// 전형적인 그리디 문제
public class MergeIntervalsTest {

    @Test
    void test1() {
        int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};

        assertThat(merge(intervals)).isEqualTo(new int[][]{
            {1, 6},
            {8, 10},
            {15, 18}
        });

        int[][] intervals2 = {{1, 4}, {4, 5}};
        assertThat(merge(intervals2)).isEqualTo(new int[][]{{1, 5}});
    }

    public int[][] merge(int[][] intervals) {
        List<int[]> answers = new ArrayList<>();
        Arrays.sort(intervals, (Comparator.comparingInt(o -> o[0])));

        int start = intervals[0][0];
        int end = intervals[0][1];

        for (int[] interval : intervals) {
            if (interval[0] <= end) {
                end = Math.max(end, interval[1]);
            } else {
                answers.add(new int[]{start, end});
                start = interval[0];
                end = interval[1];
            }
        }
        answers.add(new int[]{start, end});
        return answers.toArray(new int[0][]);
    }
}
