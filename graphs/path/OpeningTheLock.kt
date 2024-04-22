package leetcode.graphs.path

import java.util.*

/**
 * https://leetcode.com/problems/open-the-lock/
 *
 * return the minimum total number of turns required to open the lock, or -1 if it is impossible.
 */

private class OpeningTheLock {
    fun openLock(deadends: Array<String>, target: String): Int {
        if (target.length != 4 || target !in "0000".."9999") {
            return -1
        }

        val deadSet = deadends.toHashSet()
        if ("0000" in deadSet) return -1
        if (target == "0000") return 0

        val visited = mutableSetOf<String>()
        val queue: Queue<Pair<String, Int>> = LinkedList()
        queue.add("0000" to 0)

        while (queue.isNotEmpty()) {
            val (current, result) = queue.poll()
            for (i in 0 until 4) {
                for (j in listOf(-1, 1)) {
                    val newDigit = (current[i] - '0' + j + 10) % 10
                    val newChar = (newDigit + '0'.code).toChar()
                    val newCombination = current.substring(0, i) + newChar + current.substring(i + 1)
                    if (newCombination == target) return result + 1
                    if (newCombination !in deadSet && newCombination !in visited) {
                        visited.add(newCombination)
                        queue.add(newCombination to result + 1)
                    }
                }
            }
        }

        return -1
    }
}
