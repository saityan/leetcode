package leetcode.arrays

/**
 * https://leetcode.com/problems/element-appearing-more-than-25-in-sorted-array/
 */

private class QuarterTimesElement {
    fun findSpecialInteger(arr: IntArray): Int {
        if (arr.isEmpty()) return 0

        if (arr.size <= 3) return arr[0]

        val quarter = arr.size / 4
        var counter = 1

        for (i in 0 until arr.size - 1) {
            if (arr[i] == arr[i + 1]) {
                counter++
                if (counter > quarter) return arr[i]
            } else counter = 1
        }

        return 0
    }
}
