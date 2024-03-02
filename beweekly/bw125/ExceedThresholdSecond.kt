package leetcode.beweekly.bw125

import java.util.*

/**
 * https://leetcode.com/contest/biweekly-contest-125/problems/minimum-operations-to-exceed-threshold-value-ii/
 */

private class ExceedThresholdSecond {
    fun minOperations(nums: IntArray, k: Int): Int {

        val queue = PriorityQueue<Long>()
        for (n in nums) {
            if (n < k) queue.add(n.toLong())
        }

        var result = 0
        while (queue.size > 1) {
            val first = queue.poll()
            val second = queue.poll()
            result++
            val n = minOf(first, second) * 2 + maxOf(first, second)
            if (n < k) queue.add(n)
        }

        if (!queue.isEmpty()) result++
        return result
    }
}
