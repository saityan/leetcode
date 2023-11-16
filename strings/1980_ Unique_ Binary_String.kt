package leetcode.strings

/**
 * https://leetcode.com/problems/find-unique-binary-string/
 *
 * Given an array of strings nums containing n unique binary strings each of length n,
 * return a binary string of length n that does not appear in nums.
 * If there are multiple answers,you may return any of them.
 *
 */

private class `1980_ Unique_ Binary_String` {
    fun findDifferentBinaryString(nums: Array<String>): String {
        val set = nums.toMutableSet()
        for (i in 0..(2 shl nums[0].length)) {
            val binaryString = i.toString(2).padStart(nums[0].length, '0')
            if(!set.contains(binaryString))
                return binaryString
        }
        return "Set is complete"
    }
}
