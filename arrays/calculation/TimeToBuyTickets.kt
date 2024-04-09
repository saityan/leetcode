package leetcode.arrays.calculation

/**
 * https://leetcode.com/problems/time-needed-to-buy-tickets
 *
 * Return the time taken for the person at position k (0-indexed) to finish buying tickets.
 */

private class TimeToBuyTickets {
    fun timeRequiredToBuy(tickets: IntArray, k: Int): Int {
        val minTime = tickets[k]
        var result = 0

        for (i in tickets.indices) {
            result += if (tickets[i] < minTime) {
                tickets[i]
            } else {
                minTime
            }

            //When k person bought their tickets, we no longer need to reach the end of the queue
            if (i > k && tickets[i] >= minTime) {
                result--
            }
        }

        return result
    }
}
