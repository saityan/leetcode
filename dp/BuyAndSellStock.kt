package leetcode.dp

import kotlin.math.max
import kotlin.math.min

/**
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
 */

private class BuyAndSellStock {
    fun maxProfit(prices: IntArray): Int {
        if (prices.isEmpty()) return 0

        var minPrice = prices[0]
        var maxProfit = 0

        for (price in prices) {
            minPrice = min(minPrice, price)
            maxProfit = max(maxProfit, price - minPrice)
        }

        return maxProfit
    }
}
