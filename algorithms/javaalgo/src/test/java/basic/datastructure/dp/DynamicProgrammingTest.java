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

        assertAll(
            () -> assertThat(fiboNumber1).isEqualTo(5),
            () -> assertThat(fiboNumber2).isEqualTo(8)
        );
    }
}
