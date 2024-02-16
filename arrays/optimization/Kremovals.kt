package leetcode.arrays.optimization

/**
 * https://leetcode.com/problems/least-number-of-unique-integers-after-k-removals/
 */

private class Kremovals {
    fun findLeastNumOfUniqueInts(arr: IntArray, k: Int): Int {
        if (arr.isEmpty()) return 0
        if (k < 1) return arr.toSet().size

        val valueCount = arr
            .toMutableList()
            .groupingBy { it }
            .eachCount()
            .values
            .sortedDescending()

        var remainder = k
        var result = valueCount.size
        for (i in valueCount.indices.reversed()) {
            remainder -= valueCount[i]
            if (remainder >= 0) {
                result--
            } else {
                break
            }
        }

        return result
    }
}
