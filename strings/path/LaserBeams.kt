package leetcode.strings.path

import java.util.LinkedList

/**
 * https://leetcode.com/problems/number-of-laser-beams-in-a-bank/
 */

private class LaserBeams {
    fun numberOfBeams(bank: Array<String>): Int {
        if (bank.size < 2) return 0

        val list = LinkedList<Int>()
        var res = 0

        for (i in bank.indices) {
            var sum = 0
            for (j in bank[i].indices) {
                if (bank[i][j] != '0') {
                    sum++
                }
            }
            if (sum > 0) {
                list.add(sum)
            }
        }

        for (i in 0 until list.size - 1) {
            val current = list[i]
            val next = list[i + 1]
            res += current * next
        }

        return res
    }
}
