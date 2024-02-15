package leetcode.arrays.sums

/**
 * https://leetcode.com/problems/find-polygon-with-the-largest-perimeter/
 */

class LargestPerimeter {
    fun largestPerimeter(nums: IntArray): Long {
        if (nums.size < 3) return -1L

        val sortedNums = nums.sorted()
        var remainder = 0L
        for (num in sortedNums) {
            remainder += num
        }

        for (i in sortedNums.lastIndex downTo 2) {
            val number = sortedNums[i]
            remainder -= number
            if (number >= remainder) {
                continue
            } else {
                return remainder + number
            }
        }

        return -1L
    }
}
