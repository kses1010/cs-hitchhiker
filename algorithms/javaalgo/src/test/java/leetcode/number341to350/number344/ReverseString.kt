package leetcode.number341to350.number344

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class ReverseString {

    @Test
    fun test() {
        val s1 = charArrayOf('h', 'e', 'l', 'l', 'o')

        assertThat(reverseString(s1)).isEqualTo(charArrayOf('o', 'l', 'l', 'e', 'h'))
    }

    fun reverseString(s: CharArray): CharArray {
        var left = 0
        var right = s.size - 1

        while (left < right) {
            val temp = s[left]
            s[left] = s[right]
            s[right] = temp
            left++
            right--
        }

        return s
    }
}
