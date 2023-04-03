package leetcode

/**
 * https://leetcode.com/problems/boats-to-save-people/
 *
 * You are given an array people where people[i] is the weight of the ith person,
 * and an infinite number of boats where each boat can carry a maximum weight of limit.
 * Each boat carries at most two people at the same time,
 * provided the sum of the weight of those people is at most limit.
 *
 * Return the minimum number of boats to carry every given person.
 */

private class `881_Boats` {
    fun numRescueBoats(people: IntArray, limit: Int): Int {
        val sortedPeople = people.sorted()
        var result = 0
        var start = 0
        var end = sortedPeople.lastIndex
        while (start <= end) {
            if (sortedPeople[start] + sortedPeople[end] <= limit)
                start++
            end--
            result++
        }
        return result
    }
}
