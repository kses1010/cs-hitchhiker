package basic.datastructure.dp;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

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

        assertAll(
            () -> assertThat(fiboNumber1).isEqualTo(5),
            () -> assertThat(fiboNumber2).isEqualTo(8),
            () -> assertThat(fiboNumberIter1).isEqualTo(5),
            () -> assertThat(fiboNumberIter2).isEqualTo(8)
        );
    }
}
