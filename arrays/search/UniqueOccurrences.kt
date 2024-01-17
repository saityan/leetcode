package leetcode.arrays.search

/**
 * https://leetcode.com/problems/unique-number-of-occurrences/description/
 */

private class UniqueOccurrences {
    fun uniqueOccurrences(arr: IntArray): Boolean {
        if (arr.isEmpty()) return false

        val frequencyMap = arr.asList().groupingBy { it }.eachCount()
        val uniqueFrequencies = HashSet<Int>()

        for (frequency in frequencyMap.values) {
            if (!uniqueFrequencies.add(frequency)) {
                return false
            }
        }

        return true
    }
}
