package leetcode.number1to100.number71to80.number79;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import org.junit.jupiter.api.Test;

public class WordSearchTest {

    int[] dx = {-1, 0, 1, 0};
    int[] dy = {0, -1, 0, 1};

    @Test
    void test() {
        char[][] board = {
            {'A', 'B', 'C', 'E'},
            {'S', 'F', 'C', 'S'},
            {'A', 'D', 'E', 'E'}
        };

        assertAll(
            () -> assertThat(exist(board, "ABCCED")).isTrue(),
            () -> assertThat(exist(board, "SEE")).isTrue(),
            () -> assertThat(exist(board, "ABCB")).isFalse()
        );
    }

    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0) && dfs(board, word, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, String word, int x, int y, int index) {
        if (index == word.length()) {
            return true;
        }
        if (x < 0 || y < 0 || x >= board.length || y >= board[0].length || board[x][y] != word.charAt(index)) {
            return false;
        }
        if (board[x][y] == '#') {
            return false;
        }

        char tmp = board[x][y];
        board[x][y] = '#';
        boolean found = false;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (dfs(board, word, nx, ny, index + 1)) {
                found = true;
                break;
            }
        }
        board[x][y] = tmp;
        return found;
    }
}
