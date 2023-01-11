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
        System.out.println(lru); // [7, 3, 2, 1]
        System.out.println("================");

        lru.add(3);
        System.out.println(lru); // [3, 7, 2, 1]
        System.out.println("================");

        lru.add(8);
        System.out.println(lru); // [8, 3, 7, 2]
        System.out.println("================");

        lru.add(1);
        System.out.println(lru); // [1, 8, 3, 7]
    }
}
