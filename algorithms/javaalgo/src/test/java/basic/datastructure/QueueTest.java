package basic.datastructure;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class QueueTest {

    @Test
    @DisplayName("스택으로 큐 구현")
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

    @Test
    @DisplayName("순환 큐 구현")
    void circularQueueTest() {
        CircularQueue queue = new CircularQueue(5);
        assertAll(
            () -> assertThat(queue.isEmpty()).isTrue(),
            () -> assertThat(queue.isFull()).isFalse()
        );

        queue.enQueue(1);
        queue.enQueue(10);
        queue.enQueue(20);
        queue.enQueue(30);
        queue.enQueue(40);
        assertAll(
            () -> assertThat(queue.isFull()).isTrue(),
            () -> assertThat(queue.enQueue(100)).isFalse(),
            () -> assertThat(queue.front()).isEqualTo(40),
            () -> assertThat(queue.rear()).isEqualTo(1)
        );

        queue.deQueue();
        queue.deQueue();
        assertThat(queue.rear()).isEqualTo(20);

        queue.enQueue(50);
        queue.enQueue(60);
        assertThat(queue.front()).isEqualTo(60);

        queue.deQueue();
        queue.deQueue();
        queue.deQueue();
        queue.deQueue();
        queue.deQueue();
        assertAll(
            () -> assertThat(queue.isEmpty()).isTrue(),
            () -> assertThat(queue.front()).isEqualTo(-1),
            () -> assertThat(queue.rear()).isEqualTo(-1)
        );
    }
}
