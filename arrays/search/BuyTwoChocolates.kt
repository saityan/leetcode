package leetcode.arrays.search

/**
 * https://leetcode.com/problems/buy-two-chocolates/
 */

private class BuyTwoChocolates {
    fun buyChoco(prices: IntArray, money: Int): Int {

        if (prices.size < 2) return money

        var firstCheap = Integer.MAX_VALUE
        var secondCheap = Integer.MAX_VALUE

        for (price in prices)
            if (price < firstCheap) {
                secondCheap = firstCheap
                firstCheap = price
            } else if (price < secondCheap)
                secondCheap = price

        val res = money - firstCheap - secondCheap

        return if (res >= 0) res else money
    }
}
