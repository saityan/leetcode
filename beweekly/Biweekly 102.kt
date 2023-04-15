package leetcode

private class `Biweekly 102` {
    fun findColumnWidth(grid: Array<IntArray>): IntArray {
        val m = grid.size
        val n = grid[0].size
        val result = IntArray(n)
        for (i in 0 until n) {
            var max = 0
            for (j in 0 until m) {
                if (grid[j][i].toString().length > max)
                    max = grid[j][i].toString().length
            }
            result[i] = max
        }
        return result
    }

    fun findPrefixScore(nums: IntArray): LongArray {
        val conver = LongArray(nums.size)
        val result = LongArray(nums.size)
        var max = nums[0]
        var sum = 0L
        for (i in conver.indices) {
            if (nums[i] > max)
                max = nums[i]
            conver[i] = nums[i].toLong() + max.toLong()
            sum += conver[i]
            result[i] = sum
        }
        return result
    }
}
