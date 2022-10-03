package leetcode.number101to200.number121to130.number125

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll

class ValidPalindrome {

    @Test
    fun test() {
        val s1 = "A man, a plan, a canal: Panama"
        val s2 = "0P"
        val s3 = " "

        assertAll(
            { assertThat(isPalindrome(s1)).isTrue() },
            { assertThat(isPalindrome(s2)).isFalse() },
            { assertThat(isPalindrome(s3)).isTrue() },
        )
    }

    fun isPalindrome(s: String): Boolean {
        if (s.isEmpty()) {
            return true
        }
        val chars = s.lowercase().toCharArray()
        val charList: MutableList<Char> = mutableListOf()
        for (c in chars) {
            if (c.isLetterOrDigit()) charList.add(c)
        }

        var left = 0
        var right = charList.size - 1

        while (left <= right) {
            if (charList[left] != charList[right]) {
                return false
            }
            if (charList[left] == charList[right]) {
                left++
                right--
            }
        }
        return true
    }
}
