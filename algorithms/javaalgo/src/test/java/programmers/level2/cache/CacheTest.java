package programmers.level2.cache;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;
import org.junit.jupiter.api.Test;

public class CacheTest {

    @Test
    void test() {
        int cacheSize1 = 3;
        String[] cities1 = {"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "Jeju", "Pangyo", "Seoul", "NewYork", "LA"};

        int cacheSize2 = 3;
        String[] cities2 = {"Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul"};

        int cacheSize3 = 2;
        String[] cities3 = {"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "SanFrancisco", "Seoul", "Rome", "Paris",
            "Jeju", "NewYork", "Rome"};

        int cacheSize4 = 5;
        String[] cities4 = {"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "SanFrancisco", "Seoul", "Rome", "Paris",
            "Jeju", "NewYork", "Rome"};

        int cacheSize5 = 2;
        String[] cities5 = {"Jeju", "Pangyo", "NewYork", "newyork"};

        int cacheSize6 = 0;
        String[] cities6 = {"Jeju", "Pangyo", "Seoul", "NewYork", "LA"};

        assertAll(
            () -> assertThat(solution(cacheSize1, cities1)).isEqualTo(50),
            () -> assertThat(solution(cacheSize2, cities2)).isEqualTo(21),
            () -> assertThat(solution(cacheSize3, cities3)).isEqualTo(60),
            () -> assertThat(solution(cacheSize4, cities4)).isEqualTo(52),
            () -> assertThat(solution(cacheSize5, cities5)).isEqualTo(16),
            () -> assertThat(solution(cacheSize6, cities6)).isEqualTo(25)
        );
    }

    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        if (cacheSize == 0) {
            return cities.length * 5;
        }
        Deque<String> cache = new LinkedList<>();
        Set<String> cacheSet = new HashSet<>();
        for (String s : cities) {
            String city = s.toLowerCase();
            if (cacheSet.contains(city)) {
                cache.remove(city);
                cache.addFirst(city);
                answer += 1;
            } else {
                if (cache.size() == cacheSize) {
                    cacheSet.remove(cache.pollLast());
                }
                cache.addFirst(city);
                cacheSet.add(city);
                answer += 5;
            }
        }

        return answer;
    }
}
