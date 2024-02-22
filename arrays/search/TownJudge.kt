package leetcode.arrays.search

/**
 *
 */

private class TownJudge {
    fun findJudge(n: Int, trust: Array<IntArray>): Int {
        if (n < 1) return -1

        val cleanedTrust = trust.toSet()
        val possibleJudge = BooleanArray(n) { true }
        val accTrust = IntArray(n) { 0 }

        for (i in cleanedTrust.indices) {
            possibleJudge[trust[i][0] - 1] = false
            accTrust[trust[i][1] - 1]++
        }

        for (i in possibleJudge.indices) {
            if (possibleJudge[i] && accTrust[i] == n - 1) {
                return i + 1
            }
        }

        return -1
    }
}
