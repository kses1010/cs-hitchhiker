package programmers.level3.network;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import org.junit.jupiter.api.Test;

public class NetworkTest {

    static boolean[] visited;

    @Test
    void test() {
        int[][] computers1 = {
            {1, 1, 0},
            {1, 1, 0},
            {0, 0, 1}
        };
        int[][] computers2 = {
            {1, 1, 0},
            {1, 1, 1},
            {0, 1, 1}
        };

        assertAll(
            () -> assertThat(solution(3, computers1)).isEqualTo(2),
            () -> assertThat(solution(3, computers2)).isEqualTo(1)
        );
    }

    public int solution(int n, int[][] computers) {
        int answer = 0;
        visited = new boolean[computers.length];
        for (int i = 0; i < computers.length; i++) {
            if (!visited[i]) {
                answer++;
                dfs(i, computers);
            }
        }

        return answer;
    }

    public void dfs(int start, int[][] computers) {
        visited[start] = true;
        for (int i = 0; i < computers.length; i++) {
            if (!visited[i] && computers[start][i] == 1) {
                dfs(i, computers);
            }
        }
    }
}
