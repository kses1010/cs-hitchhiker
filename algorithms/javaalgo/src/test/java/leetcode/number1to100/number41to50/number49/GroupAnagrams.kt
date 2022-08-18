package leetcode.number1to100.number41to50.number49

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class GroupAnagrams {

    @Test
    fun test() {
        val strs1 = arrayOf("eat", "tea", "tan", "ate", "nat", "bat")

        assertThat(groupAnagrams(strs1)).isEqualTo(
            listOf(
                listOf("ate", "eat", "tea"),
                listOf("nat", "tan"),
                listOf("bat")
            )
        )
    }

    fun groupAnagrams(strs: Array<String>): List<List<String>> {
        strs.sort()
        val strMap: MutableMap<String, MutableList<String>> = mutableMapOf()

        for (str in strs) {
            val sortStr = String(str.toCharArray().apply { sort() })
            if (!strMap.containsKey(sortStr)) strMap[sortStr] = mutableListOf()
            strMap[sortStr]!!.add(str)
        }

        val answers: MutableList<List<String>> = mutableListOf()
        for (value in strMap.values) {
            answers.add(value)
        }
        return answers.sortedBy { it.size }.reversed()
    }
}
