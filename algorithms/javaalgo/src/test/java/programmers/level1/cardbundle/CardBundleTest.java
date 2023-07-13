package programmers.level1.cardbundle;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import org.junit.jupiter.api.Test;

public class CardBundleTest {

    @Test
    void test() {
        String[] cards1 = {"i", "drink", "water"};
        String[] cards2 = {"want", "to"};
        String[] goal1 = {"i", "want", "to", "drink", "water"};

        String[] cards3 = {"i", "water", "drink"};
        String[] cards4 = {"want", "to"};
        String[] goal2 = {"i", "want", "to", "drink", "water"};

        assertAll(
            () -> assertThat(solution(cards1, cards2, goal1)).isEqualTo("Yes"),
            () -> assertThat(solution(cards3, cards4, goal2)).isEqualTo("No")
        );
    }

    public String solution(String[] cards1, String[] cards2, String[] goal) {
        int card1Index = 0;
        int card2Index = 0;
        for (String goalWord : goal) {
            if (card1Index < cards1.length && cards1[card1Index].equals(goalWord)) {
                card1Index++;
            } else if (card2Index < cards2.length && cards2[card2Index].equals(goalWord)) {
                card2Index++;
            } else {
                return "No";
            }
        }
        return "Yes";
    }
}
