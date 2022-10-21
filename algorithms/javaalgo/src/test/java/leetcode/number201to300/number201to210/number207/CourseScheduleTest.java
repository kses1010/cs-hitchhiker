package leetcode.number201to300.number201to210.number207;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class CourseScheduleTest {

    @Test
    void test() {
        int numCourses = 2;
        int[][] prerequisites1 = {{1, 0}};
        int[][] prerequisites2 = {{1, 0}, {0, 1}};

        Solution sol = new Solution();
        assertThat(sol.canFinish(numCourses, prerequisites1)).isTrue();
        assertThat(sol.canFinish(numCourses, prerequisites2)).isFalse();
    }
}
