package leetcode.arrays.path

private class LongestSequence {
    fun longestConsecutive(nums: IntArray): Int {
        if(nums.isEmpty()) return 0

        val set = HashSet<Int>()
        for (n in nums) {
            set.add(n)
        }

        var result = 0
        for (n in nums) {
            if (!set.contains(n - 1)) {
                var currentLength = 1
                var currentNum = n

                while (set.contains(currentNum + 1)) {
                    currentLength++
                    currentNum++
                }

                result = maxOf(result, currentLength)
            }
        }

        return result
    }
}
