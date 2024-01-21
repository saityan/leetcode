package leetcode.arrays.sorting

/**
 * https://leetcode.com/problems/merge-sorted-array/
 */

private class MergeSortedArray {
    fun merge(nums1: IntArray, m: Int, nums2: IntArray, n: Int) {
        val res = IntArray(m + n)

        for (i in 0 until m) {
            res[i] = nums1[i]
        }
        for (i in 0 until n) {
            res[i + m] = nums2[i]
        }

        res.sort()
        for (i in nums1.indices) {
            nums1[i] = res[i]
        }
    }
}
