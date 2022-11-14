package leetcode.number901to1000.number931to940.number937

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class ReorderLogFiles {

    @Test
    fun test() {
        val logs1 = arrayOf("dig1 8 1 5 1", "let1 art can", "dig2 3 6", "let2 own kit dig", "let3 art zero")
        val logs2 = arrayOf("a1 9 2 3 1", "g1 act car", "zo4 4 7", "ab1 off key dog", "a8 act zoo")

        assertThat(reorderLogFiles(logs1)).isEqualTo(
            arrayOf(
                "let1 art can",
                "let3 art zero",
                "let2 own kit dig",
                "dig1 8 1 5 1",
                "dig2 3 6"
            )
        )

        assertThat(reorderLogFiles(logs2)).isEqualTo(
            arrayOf(
                "g1 act car", "a8 act zoo", "ab1 off key dog", "a1 9 2 3 1", "zo4 4 7"
            )
        )
    }

    fun reorderLogFiles(logs: Array<String>): Array<String> {
        val stringLogs: MutableList<String> = mutableListOf()
        val numberLogs: MutableList<String> = mutableListOf()

        for (log in logs) {
            val logCheck = log.split(" ")[1]
            if (logCheck.all { Character.isDigit(it) }) {
                numberLogs.add(log)
            } else {
                stringLogs.add(log)
            }
        }

        val comparator: Comparator<String> =
            Comparator<String> { o1, o2 ->
                o1.substring(o1.indexOf(" ")).compareTo(o2.substring(o2.indexOf(" ")))
            }
                .thenComparing { o1, o2 ->
                    o1.split(" ")[0].compareTo(o2.split(" ")[0])
                }
        val stringSort = stringLogs.sortedWith(comparator)
        return stringSort.plus(numberLogs).toTypedArray()
    }
}
