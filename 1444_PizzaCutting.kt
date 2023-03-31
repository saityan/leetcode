package leetcode

private class PizzaCutting {
    fun ways(pizza: Array<String>, k: Int): Int {

        if (pizza.isEmpty() || pizza[0].isEmpty())
            return 0

        val rows = pizza.size
        val columns = pizza[0].length
        val apples = Array(rows + 1) {
            IntArray(columns + 1)
        }
        val dp = Array(k) {
            Array(rows) {
                IntArray(columns)
            }
        }

        for (row in rows - 1 downTo 0) {
            for (column in columns - 1 downTo 0) {
                apples[row][column] = when {
                    pizza[row][column] == 'A' -> 1
                    else -> 0
                }
                apples[row][column] += apples[row + 1][column] + apples[row][column + 1] - apples[row + 1][column + 1]
                dp[0][row][column] = when {
                    apples[row][column] > 0 -> 1
                    else -> 0
                }
            }
        }

        val mod = 1000000007
        for (remainder in 1 until k) {
            for (row in 0 until rows) {
                for (column in 0 until columns) {
                    for (rowNext in row + 1 until rows) {
                        if (apples[row][column] - apples[rowNext][column] > 0) {
                            dp[remainder][row][column] += dp[remainder - 1][rowNext][column]
                            dp[remainder][row][column] %= mod
                        }
                    }

                    for(columnNext in column + 1 until columns) {
                        if (apples[row][column] - apples[row][columnNext] > 0) {
                            dp[remainder][row][column] += dp[remainder - 1][row][columnNext]
                            dp[remainder][row][column] %= mod
                        }
                    }
                }
            }
        }
        return dp[k - 1][0][0]
    }
}
