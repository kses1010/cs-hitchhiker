package leetcode.number11to20.number11

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll
import kotlin.math.max
import kotlin.math.min

// 11. Container With Most Water
class ContainerWithMostWaterTest {

    @Test
    fun test() {
        val height1: IntArray = intArrayOf(1, 8, 6, 2, 5, 4, 8, 3, 7)
        val height2 = intArrayOf(1, 1)

        assertAll(
            { assertThat(maxArea(height1)).isEqualTo(49) },
            { assertThat(maxArea(height2)).isEqualTo(1) },
        )
    }

    private fun maxArea(height: IntArray): Int {
        var left = 0
        var right = height.size - 1
        var max = 0
        while (left < right) {
            val width = right - left
            val h = min(height[left], height[right])
            val area = width * h
            max = max(max, area)

            if (height[left] < height[right]) left++
            else if (height[left] > height[right]) right--
            else {
                left++
                right--
            }
        }
        return max
    }
}
