package leetcode.number1to100.number11to20.number15

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll

// 15. 3Sum
class ThreeSumTest {

    @Test
    fun test() {
        val nums1 = intArrayOf(-1, 0, 1, 2, -1, 4)
        val nums2 = intArrayOf(0, 1, 1)
        val nums3 = intArrayOf(0, 0, 0)

        assertAll(
            { assertThat(threeSum(nums1)).isEqualTo(listOf(listOf(-1, -1, 2), listOf(-1, 0, 1))) },
            {
                val emptyList = emptyList<Any>()
                assertThat(threeSum(nums2)).isEqualTo(emptyList)
            },
            { assertThat(threeSum(nums3)).isEqualTo(listOf(listOf(0, 0, 0))) }
        )
    }

    fun threeSum(nums: IntArray): List<List<Int>> {
        val answerList: MutableList<List<Int>> = mutableListOf()
        nums.sort()

        if (nums.size <= 2) {
            return answerList
        }

        for (i in 0..nums.size - 2) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue
            }

            var left = i + 1
            var right = nums.size - 1

            while (left < right) {
                val threeSum = nums[i] + nums[left] + nums[right]

                if (threeSum < 0) {
                    left++
                } else if (threeSum > 0) {
                    right--
                } else {
                    answerList.add(listOf(nums[i], nums[left], nums[right]))

                    while (left < right && nums[left] == nums[left + 1]) {
                        left++
                    }
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--
                    }
                    left++
                    right--
                }
            }
        }

        return answerList
    }
}
