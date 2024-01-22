package leetcode.arrays.search

/**
 * https://leetcode.com/problems/set-mismatch
 */

private class SetMismatch {

    fun findErrorNums(nums: IntArray): IntArray {

        if (nums.isEmpty()) return emptyArray<Int>().toIntArray()

        val res = arrayOf(0, 0).toIntArray()
        val set = HashSet<Int>()

        for (n in nums) {
            if (!set.add(n)) {
                res[0] = n
            }
        }

        for (i in nums.indices) {
            if (!set.contains(i + 1)) {
                res[1] = i + 1
                break
            }
        }

        return res
    }
}
