package leetcode.number401to500.number401to410.number409;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Test;

public class LongPalindromeTest {

    @Test
    void test1() {
        String s1 = "abccccdd";
        String s2 = "a";
        String s3 = "civilwartestingwhetherthatnaptionoranynartionsoconceivedandsodedicatedcanlongendureWeareqmetonagreatbattlefiemldoftzhatwarWehavecometodedicpateaportionofthatfieldasafinalrestingplaceforthosewhoheregavetheirlivesthatthatnationmightliveItisaltogetherfangandproperthatweshoulddothisButinalargersensewecannotdedicatewecannotconsecratewecannothallowthisgroundThebravelmenlivinganddeadwhostruggledherehaveconsecrateditfaraboveourpoorponwertoaddordetractTgheworldadswfilllittlenotlenorlongrememberwhatwesayherebutitcanneverforgetwhattheydidhereItisforusthelivingrathertobededicatedheretotheulnfinishedworkwhichtheywhofoughtherehavethusfarsonoblyadvancedItisratherforustobeherededicatedtothegreattdafskremainingbeforeusthatfromthesehonoreddeadwetakeincreaseddevotiontothatcauseforwhichtheygavethelastpfullmeasureofdevotionthatweherehighlyresolvethatthesedeadshallnothavediedinvainthatthisnationunsderGodshallhaveanewbirthoffreedomandthatgovernmentofthepeoplebythepeopleforthepeopleshallnotperishfromtheearth";

        assertAll(
            () -> assertThat(longPalindrome(s1)).isEqualTo(7),
            () -> assertThat(longPalindrome(s2)).isEqualTo(1),
            () -> assertThat(longPalindrome(s3)).isEqualTo(983)
        );
    }

    public int longPalindrome(String s) {
        int answer = 0;
        Map<Character, Integer> maps = new HashMap<>();
        for (char c : s.toCharArray()) {
            int count = maps.getOrDefault(c, 0);
            count++;
            maps.put(c, count);
            if (count % 2 == 0) {
                answer += 2;
            }
        }
        for (int size : maps.values()) {
            if (size % 2 != 0) {
                return answer + 1;
            }
        }

        return answer;
    }

    @Test
    void test2() {
        String s1 = "abccccdd";
        String s2 = "a";
        String s3 = "civilwartestingwhetherthatnaptionoranynartionsoconceivedandsodedicatedcanlongendureWeareqmetonagreatbattlefiemldoftzhatwarWehavecometodedicpateaportionofthatfieldasafinalrestingplaceforthosewhoheregavetheirlivesthatthatnationmightliveItisaltogetherfangandproperthatweshoulddothisButinalargersensewecannotdedicatewecannotconsecratewecannothallowthisgroundThebravelmenlivinganddeadwhostruggledherehaveconsecrateditfaraboveourpoorponwertoaddordetractTgheworldadswfilllittlenotlenorlongrememberwhatwesayherebutitcanneverforgetwhattheydidhereItisforusthelivingrathertobededicatedheretotheulnfinishedworkwhichtheywhofoughtherehavethusfarsonoblyadvancedItisratherforustobeherededicatedtothegreattdafskremainingbeforeusthatfromthesehonoreddeadwetakeincreaseddevotiontothatcauseforwhichtheygavethelastpfullmeasureofdevotionthatweherehighlyresolvethatthesedeadshallnothavediedinvainthatthisnationunsderGodshallhaveanewbirthoffreedomandthatgovernmentofthepeoplebythepeopleforthepeopleshallnotperishfromtheearth";

        assertAll(
            () -> assertThat(longPalindrome2(s1)).isEqualTo(7),
            () -> assertThat(longPalindrome2(s2)).isEqualTo(1),
            () -> assertThat(longPalindrome2(s3)).isEqualTo(983)
        );
    }

    public int longPalindrome2(String s) {
        int answer = 0;
        Map<Character, Integer> maps = new HashMap<>();
        for (char c : s.toCharArray()) {
            maps.put(c, maps.getOrDefault(c, 0) + 1);
        }
        boolean isOdd = false;
        for (int count : maps.values()) {
            if (count % 2 == 0) {
                answer += count;
            } else {
                answer += count - 1;
                isOdd = true;
            }
        }
        if (isOdd) {
            return answer + 1;
        }
        return answer;
    }
}
