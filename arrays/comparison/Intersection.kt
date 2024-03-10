package leetcode.arrays.comparison

private class Intersection {
    fun intersection(nums1: IntArray, nums2: IntArray): IntArray {

        if (nums1.isEmpty() || nums2.isEmpty()) {
            return intArrayOf()
        }

        val firstSet = nums1.toHashSet()
        val secondSet = nums2.toHashSet()
        val result = mutableListOf<Int>()

        for (n in firstSet) {
            if (secondSet.contains(n)) {
                result.add(n)
            }
        }

        return result.toIntArray()
    }
}
