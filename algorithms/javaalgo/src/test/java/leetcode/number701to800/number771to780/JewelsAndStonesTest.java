package leetcode.number701to800.number771to780;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Test;

public class JewelsAndStonesTest {

    @Test
    void test() {
        String jewels = "aA";
        String stones = "aAAbbbb";

        assertThat(numJewelsInStones(jewels, stones)).isEqualTo(3);
    }

    public int numJewelsInStones(String jewels, String stones) {
        int answer = 0;
        Map<Character, Integer> maps = new HashMap<>();
        for (char c : jewels.toCharArray()) {
            maps.put(c, maps.getOrDefault(c, 0) + 1);
        }

        for (Character stone : stones.toCharArray()) {
            if (maps.containsKey(stone)) {
                answer += maps.get(stone);
            }
        }
        return answer;
    }
}
