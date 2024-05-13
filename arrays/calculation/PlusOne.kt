package leetcode.arrays.calculation

// https://leetcode.com/problems/plus-one

private class PlusOne {
    fun plusOne(digits: IntArray): IntArray {
        if (digits.isEmpty()) return intArrayOf()

        val result = digits.toMutableList()
        var remainder = 1
        var i = digits.lastIndex
        while (remainder == 1 && i > -1) {
            if (i == 0 && result[i] == 9) {
                result[0] = 1
                result.add(0)
                break
            } else if (result[i] == 9) {
                result[i] = 0
                i--
            } else {
                result[i]++
                remainder = 0
            }
        }

        return result.toIntArray()
    }
}
