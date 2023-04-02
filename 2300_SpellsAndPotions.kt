package leetcode

/**
 * https://leetcode.com/problems/successful-pairs-of-spells-and-potions/
 *
 * You are given two positive integer arrays spells and potions, of length n and m respectively,
 * where spells[i] represents the strength of the ith spell and potions[j] represents the strength of the jth potion.

 * You are also given an integer success.
 * A spell and potion pair is considered successful if the product of their strengths is at least success.

 * Return an integer array pairs of length n,
 * where pairs[i] is the number of potions that will form a successful pair with the ith spell.
 */

private class `2300_SpellsAndPotions` {
    fun successfulPairs(spells: IntArray, potions: IntArray, success: Long): IntArray {

        val pairs = ArrayList<Int>()
        val size = potions.size
        val sortedPotions = potions.sorted().toIntArray()

        for (spell in spells) {
            var counter = 0
            val minPotion = success.toDouble() / spell.toDouble()
            val minIndex = findFirstSuccess(sortedPotions, minPotion)
            if (minIndex != -1) {
                counter = size - minIndex
            }
            pairs.add(counter)
        }
        return pairs.toIntArray()
    }

    private fun findFirstSuccess(arr: IntArray, target: Double) : Int {

        if (arr.isEmpty())
            return -1
        if (arr.last() < target)
            return -1

        var low = 0
        var high = arr.lastIndex
        while (low != high) {
            val mid = (low + high) / 2
            if (arr[mid] < target)
                low = mid + 1
            else
                high = mid
        }
        return low
    }
}
