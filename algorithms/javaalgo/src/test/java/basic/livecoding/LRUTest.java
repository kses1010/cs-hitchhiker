package basic.livecoding;

import org.junit.jupiter.api.Test;

public class LRUTest {

    @Test
    void test() {
        // {1, 2, 3, 7, 3, 8, 1};
        LRUArray lru = new LRUArray(4);
        lru.add(1);
        lru.add(2);
        lru.add(3);
        lru.add(7);
        System.out.println(lru);
        System.out.println("================");

        lru.add(3);
        System.out.println(lru);
        System.out.println("================");

        lru.add(8);
        System.out.println(lru);
        System.out.println("================");

        lru.add(1);
        System.out.println(lru);
    }
}
