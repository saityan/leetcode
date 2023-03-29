package leetcode

private class ReducingDishes {
    fun maxSatisfaction(satisfaction: IntArray): Int {
        if (satisfaction.isEmpty())
            return 0

        val dishes = IntArray(satisfaction.size)
        satisfaction.copyInto(dishes)
        dishes.sort()

        var currentSum = 0
        var sum = 0
        var index = dishes.lastIndex

        while (index >= 0 && dishes[index] + currentSum > 0) {
            currentSum += dishes[index]
            sum += currentSum
            index--
        }
        return sum
    }
}
