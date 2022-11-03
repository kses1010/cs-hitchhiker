package basic.datastructure.dp;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.List;
import org.junit.jupiter.api.Test;

public class DynamicProgrammingTest {

    @Test
    void fibonacciTest() {
        Fibonacci fibonacci = new Fibonacci(10);
        int fiboNumber1 = fibonacci.getFiboNumber(5);
        int fiboNumber2 = fibonacci.getFiboNumber(6);

        Fibonacci fibonacci1 = new Fibonacci(10);
        int fiboNumberIter1 = fibonacci1.getFiboNumberIter(5);
        int fiboNumberIter2 = fibonacci1.getFiboNumberIter(6);

        Fibonacci fibonacci2 = new Fibonacci(10);
        int fibo1 = fibonacci2.getFiboShortMemory(5);
        int fibo2 = fibonacci2.getFiboShortMemory(6);

        assertAll(
            () -> assertThat(fiboNumber1).isEqualTo(5),
            () -> assertThat(fiboNumber2).isEqualTo(8),
            () -> assertThat(fiboNumberIter1).isEqualTo(5),
            () -> assertThat(fiboNumberIter2).isEqualTo(8),
            () -> assertThat(fibo1).isEqualTo(5),
            () -> assertThat(fibo2).isEqualTo(8)
        );
    }

    @Test
    void primeNumberTest() {
        PrimeNumber primeNumber = new PrimeNumber(100);
        List<Integer> primeList = primeNumber.getPrimeList(10);

        assertThat(primeList).isEqualTo(List.of(2, 3, 5, 7));
    }

    @Test
    void stairDyTest() {
        int firstStep = 1;
        int secondStep = 2;

        assertAll(
            () -> assertThat(stairDy(firstStep, secondStep, 1)).isEqualTo(1),
            () -> assertThat(stairDy(firstStep, secondStep, 2)).isEqualTo(2),
            () -> assertThat(stairDy(firstStep, secondStep, 3)).isEqualTo(3),
            () -> assertThat(stairDy(firstStep, secondStep, 7)).isEqualTo(21)
        );
    }

    private int stairDy(int firstStep, int secondStep, int n) {
        int[] dy = new int[n + 1];
        dy[1] = firstStep;
        if (n == 1) {
            return dy[n];
        }
        dy[2] = secondStep;
        if (n == 2) {
            return dy[n];
        }
        for (int i = 3; i <= n; i++) {
            dy[i] = dy[i - 2] + dy[i - 1];
        }

        return dy[n];
    }
}
