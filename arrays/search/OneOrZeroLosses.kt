package leetcode.arrays.search

/**
 * https://leetcode.com/problems/find-players-with-zero-or-one-losses/description/
 */

private class OneOrZeroLosses {
    fun findWinners(matches: Array<IntArray>): List<List<Int>> {
        if (matches.isEmpty()) return emptyList()

        val winners = matches.groupBy { it.first() }
        val losers = matches.groupBy { it[1] }

        val totalWinners = winners.keys - losers.keys
        val almostWinners = losers.filterValues { it.size == 1 }.keys

        return listOf(totalWinners.sorted(), almostWinners.sorted())
    }
}
