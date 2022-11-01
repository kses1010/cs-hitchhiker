package basic.datastructure.dp;

import java.util.ArrayList;
import java.util.List;

public class PrimeNumber {

    private int[] checks;

    public PrimeNumber(int n) {
        this.checks = new int[n + 1];
    }

    public List<Integer> getPrimeList(int n) {
        List<Integer> primes = new ArrayList<>();
        for (int i = 2; i < n; i++) {
            if (checks[i] == 0) {
                primes.add(i);
                for (int j = i; j < n; j += i) {
                    checks[j] = 1;
                }
            }
        }
        return primes;
    }
}
