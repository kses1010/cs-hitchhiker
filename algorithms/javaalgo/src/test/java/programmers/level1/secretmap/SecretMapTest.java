package programmers.level1.secretmap;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class SecretMapTest {

    @Test
    void test1() {
        int n = 5;
        int[] arr1 = {9, 20, 28, 18, 11};
        int[] arr2 = {30, 1, 21, 17, 28};

        assertThat(solution(n, arr1, arr2)).isEqualTo(new String[]{
                "#####",
                "# # #",
                "### #",
                "#  ##",
                "#####"
            }
        );
    }

    @Test
    void test2() {
        int n = 6;
        int[] arr1 = {46, 33, 33, 22, 31, 50};
        int[] arr2 = {27, 56, 19, 14, 14, 10};

        assertThat(solution(n, arr1, arr2)).isEqualTo(new String[]{
                "######",
                "###  #",
                "##  ##",
                " #### ",
                " #####",
                "### # "
            }
        );
    }

    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];

        for (int i = 0; i < n; i++) {
            String map = Integer.toBinaryString(arr1[i] | arr2[i]);
            while (map.length() < n) {
                map = "0" + map;
            }
            map = map.replaceAll("0", " ");
            map = map.replaceAll("1", "#");
            answer[i] = map;
        }

        return answer;
    }
}
