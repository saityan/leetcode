package leetcode

/**
 * https://leetcode.com/problems/minimum-cost-for-tickets
 *
 * You have planned some train traveling one year in advance.
 * The days of the year in which you will travel are given as an integer array days.
 * Each day is an integer from 1 to 365.
 * Train tickets are sold in three different ways:
 *
 * a 1-day pass is sold for costs[0] dollars,
 * a 7-day pass is sold for costs[1] dollars, and
 * a 30-day pass is sold for costs[2] dollars.
 * The passes allow that many days of consecutive travel.
 *
 * Return the minimum number of dollars you need to travel every day in the given list of days.
 */

private class MinimumTicketsCost {
    fun minCostTickets(days: IntArray, costs: IntArray): Int {
        val map = IntArray(365 + 30 + 1)
        val set = HashSet<Int>()
        for (day in days)
            set.add(day)
        for(day in 365 downTo 1) {
            if (!set.contains(day)) {
                map[day] = map[day + 1]
                continue
            }
            map[day] = minOf(map[day + 1] + costs[0], map[day + 7] + costs[1], map[day + 30] + costs[2])
        }
        return map[1]
    }
}
