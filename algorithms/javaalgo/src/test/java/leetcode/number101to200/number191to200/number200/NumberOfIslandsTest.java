package leetcode.number101to200.number191to200.number200;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class NumberOfIslandsTest {

    @Test
    void test() {
        char[][] grid = {
            {'1', '1', '0', '0', '0'},
            {'1', '1', '0', '0', '0'},
            {'0', '0', '1', '0', '0'},
            {'0', '0', '0', '1', '1'}
        };
        Solution sol = new Solution();
        assertThat(sol.numIslands(grid)).isEqualTo(3);
    }


}
