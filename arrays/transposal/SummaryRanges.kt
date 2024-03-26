package leetcode.arrays.transposal

/**
 * https://leetcode.com/problems/summary-ranges
 *
 * Return the smallest sorted list of ranges that cover all the numbers in the array exactly.
 */

private class SummaryRanges {
    fun summaryRanges(nums: IntArray): List<String> {
        if (nums.isEmpty()) return emptyList()

        val result = mutableListOf<String>()
        var start = nums[0]
        var end = nums[0]

        for (i in 1 until nums.size) {
            if (nums[i] == end + 1) {
                end = nums[i]
            } else {
                if (start == end) {
                    result.add("$start")
                } else {
                    result.add("$start->$end")
                }
                start = nums[i]
                end = nums[i]
            }
        }

        if (start == end) {
            result.add("$start")
        } else {
            result.add("$start->$end")
        }

        return result
    }
}
