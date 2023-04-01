package leetcode

/**
 * Given two arrays of unique digits nums1 and nums2,
 * return the smallest number that contains at least one digit from each array.
 *
 * Examples:
 * Input: nums1 = [4,1,3], nums2 = [5,7]
 * Output: 15
 *
 * Input: nums1 = [3,5,2,6], nums2 = [3,1,7]
 * Output: 3
 *
 * Constraints:
 * 1 <= nums1.length, nums2.length <= 9
 * 1 <= nums1[i], nums2[i] <= 9
 * All digits in each array are unique.
 */

private class TwoDigitArrays {
    fun minNumber(nums1: IntArray, nums2: IntArray): Int {
        var minFirst = 10
        var minSecond = 10

        for (n in 1..9)
            if (nums1.contains(n) && nums2.contains(n))
                return n

        for (num in nums1) {
            if (num < minFirst)
                minFirst = num
        }

        for (num in nums2) {
            if (num < minSecond)
                minSecond = num
        }
        if (minFirst == minSecond)
            return minFirst
        if (minFirst > minSecond)
            return minSecond * 10 + minFirst
        return minFirst * 10 + minSecond
    }
}
