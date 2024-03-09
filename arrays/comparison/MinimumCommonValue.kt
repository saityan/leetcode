package leetcode.arrays.comparison

private class MinimumCommonValue {
    fun getCommon(nums1: IntArray, nums2: IntArray): Int {
        val sizeFirst = nums1.size
        val sizeSecond = nums2.size

        if (sizeFirst == 0 || sizeSecond == 0) {
            return -1
        }

        var i = 0
        var j = 0
        while (i < sizeFirst && j < sizeSecond) {
            if (nums1[i] == nums2[j]) {
                return nums1[i]
            } else if (nums1[i] > nums2[j]) {
                while (j < sizeSecond && nums2[j] < nums1[i]) {
                    j++
                }
            } else {
                while (i < sizeFirst && nums1[i] < nums2[j]) {
                    i++
                }
            }

        }

        return -1
    }
}