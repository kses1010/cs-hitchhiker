package basic.datastructure;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import org.junit.jupiter.api.Test;

public class StackQueueTest {

    @Test
    void queueTest() {
        StackQueue<Integer> queue = new StackQueue<>();
        queue.add(10);
        queue.add(20);
        queue.add(30);

        assertAll(
            () -> assertThat(queue.size()).isEqualTo(3),
            () -> assertThat(queue.poll()).isEqualTo(10),
            () -> assertThat(queue.poll()).isEqualTo(20)
        );

        queue.add(99);
        queue.add(80);

        assertThat(queue.poll()).isEqualTo(30);
    }
}
