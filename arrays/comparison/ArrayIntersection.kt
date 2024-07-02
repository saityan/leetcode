package leetcode.arrays.comparison

// https://leetcode.com/problems/intersection-of-two-arrays-ii

private class ArrayIntersection {
    fun intersect(nums1: IntArray, nums2: IntArray): IntArray {
        val firstMap = nums1.asIterable().groupingBy { it }.eachCount()
        val secondMap = nums2.asIterable().groupingBy { it }.eachCount()

        val result = mutableListOf<Int>()

        for ((k, v) in firstMap) {
            secondMap[k]?.let {
                repeat(minOf(it, v)) {
                    result.add(k)
                }
            }
        }

        return result.toIntArray()
    }
}
