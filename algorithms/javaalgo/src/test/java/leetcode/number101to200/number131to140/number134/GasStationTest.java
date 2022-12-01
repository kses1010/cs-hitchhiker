package leetcode.number101to200.number131to140.number134;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class GasStationTest {

    @Test
    void test() {
        int[] gas = {1, 2, 3, 4, 5};
        int[] cost = {3, 4, 5, 1, 2};

        assertThat(canCompleteCircuit(gas, cost)).isEqualTo(3);
    }

    public int canCompleteCircuit(int[] gas, int[] cost) {
        int tanks = 0;
        for (int i = 0; i < gas.length; i++) {
            tanks += gas[i] - cost[i];
        }
        if (tanks < 0) {
            return -1;
        }

        int start = 0;
        int fuel = 0;
        for (int i = 0; i < gas.length; i++) {
            if (gas[i] + fuel < cost[i]) {
                start = i + 1;
                fuel = 0;
            } else {
                fuel += gas[i] - cost[i];
            }
        }
        return start;
    }
}
