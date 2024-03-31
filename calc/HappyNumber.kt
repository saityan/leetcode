package leetcode.calc

/**
 * https://leetcode.com/problems/happy-number
 *
 * Write an algorithm to determine if a number n is happy.
 */

private class HappyNumber {
    fun isHappy(n: Int): Boolean {
        val encounters = HashSet<Int>()
        var k = n
        while (k != 1) {
            if (!encounters.add(k)) return false
            k = k.toString().sumOf {
                it.toString().toInt() * it.toString().toInt()
            }
        }

        return true
    }
}
