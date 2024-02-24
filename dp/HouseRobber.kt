package leetcode.dp

/**
 * https://leetcode.com/problems/house-robber
 */

private class HouseRobber {
    fun rob(nums: IntArray): Int {
        var firstWay = 0
        var secondWay = 0

        for (n in nums) {
            val currentBest = maxOf(firstWay, secondWay + n )
            secondWay = firstWay
            firstWay = currentBest
        }

        return firstWay
    }
}
