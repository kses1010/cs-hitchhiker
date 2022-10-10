package leetcode.number301to400.number331to340.number332;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

public class ReconstructItineraryTest {

    @Test
    void test() {
        List<List<String>> tickets = List.of(
            List.of("MUC", "LHR"),
            List.of("JFK", "MUC"),
            List.of("SFO", "SJC"),
            List.of("LHR", "SFO")
        );

        Solution sol = new Solution();
        assertThat(sol.findItinierary(tickets)).isEqualTo(List.of("JFK", "MUC", "LHR", "SFO", "SJC"));
    }
}
