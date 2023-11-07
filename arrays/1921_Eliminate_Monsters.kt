package leetcode.arrays

import kotlin.math.ceil

/**
 * https://leetcode.com/problems/eliminate-maximum-number-of-monsters/
 *
 * Return the maximum number of monsters that you can eliminate before you lose,
 * or n if you can eliminate all the monsters before they reach the city.
 */

private class Eliminate {
    fun eliminateMaximum(dist: IntArray, speed: IntArray): Int {

        if (dist.size != speed.size)
            return -1

        val timeLeft = IntArray(dist.size)
        for (i in timeLeft.indices) {
            if (dist[i] == 0)
                return 0
            else if(speed[i] <= 0)
                timeLeft[i] = Int.MAX_VALUE
            else if (dist[i] % speed[i] == 0)
                timeLeft[i] = dist[i] / speed[i]
            else
                timeLeft[i] = ceil( dist[i].toFloat() / speed[i]).toInt()
        }
        timeLeft.sort()

        var result = 0
        var timePast = 0
        for (i in timeLeft.indices) {
            if (i == timeLeft.lastIndex)
                return if (timeLeft[i] > 0)
                    timeLeft.size
                else
                    result
            else if (timeLeft[i] <= 0)
                return result
            else {
                result++
                timePast++
                timeLeft[i + 1] -= timePast
            }
        }
        return result
    }
}
