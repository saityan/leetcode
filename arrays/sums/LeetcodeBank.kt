package leetcode.arrays.sums

/**
 * https://leetcode.com/problems/calculate-money-in-leetcode-bank/description/
 */

class LeetcodeBank {
    fun totalMoney(n: Int): Int {
        val weeks : Int = n / 7
        val remainder = n % 7
        var counter = 0
        var result = 0
        while (counter < weeks) {
            result += (7 + counter) * (7 + counter + 1) / 2 - counter * (counter + 1) / 2
            counter++
        }
        result += remainder * counter + remainder * (remainder + 1) / 2
        return result
    }
}
