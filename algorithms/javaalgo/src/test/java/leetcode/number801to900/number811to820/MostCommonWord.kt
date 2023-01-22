package leetcode.number801to900.number811to820

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class MostCommonWord {

    @Test
    fun test() {
        val paragraph = "Bob hit a ball, the hit BALL flew far after it was hit."
        val banned = arrayOf("hit")

        assertThat(mostCommonWord(paragraph, banned)).isEqualTo("ball")
    }

    fun mostCommonWord(paragraph: String, banned: Array<String>): String {
        val wordMap: MutableMap<String, Int> = mutableMapOf<String, Int>().withDefault { 0 }
        val regex = Regex("[^a-zA-Z]")
        val str = paragraph.replace(regex, " ").lowercase()
        val split: List<String> = str.split(" ")
        val bannedSet = banned.toSet()

        for (word in split) {
            if (!bannedSet.contains(word) && word.isNotBlank()) {
                wordMap[word] = wordMap.getValue(word) + 1
            }
        }
        val max: Map.Entry<String, Int> = wordMap.maxByOrNull { it.value }!!
        return max.key
    }
}
