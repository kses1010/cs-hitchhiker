package leetcode.number1to100.number1to10.number5

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll

class LongestPalindrome {

    @Test
    fun test01() {
        val s1 = "babad"
        val s2 = "cbbd"

        assertAll(
            { assertThat(longestPalindrome(s1)).isEqualTo("bab") },
            { assertThat(longestPalindrome(s2)).isEqualTo("bb") },
        )
    }

    private var start = 0
    private var maxLen = 0

    fun longestPalindrome(s: String): String? {
        val length = s.length
        if (length < 2) {
            return s
        }
        for (i in 0 until length - 1) {
            expand(s, i, i)
            expand(s, i, i + 1)
        }
        return s.substring(start, start + maxLen)
    }

    private fun expand(s: String, lt: Int, rt: Int) {
        var lt = lt
        var rt = rt
        while (lt >= 0 && rt < s.length && s[lt] == s[rt]) {
            lt--
            rt++
        }
        if (maxLen < rt - lt - 1) {
            start = lt + 1
            maxLen = rt - lt - 1
        }
    }
}
