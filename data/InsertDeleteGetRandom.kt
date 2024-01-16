package leetcode.data

import kotlin.random.Random

/**
 * https://leetcode.com/problems/insert-delete-getrandom-o1/description/
 */

private class InsertDeleteGetRandom {
    private val map = HashMap<Int, Int>()
    private val list = ArrayList<Int>()

    fun insert(`val`: Int): Boolean {
        if (map.containsKey(`val`)) {
            return false
        }

        list.add(`val`)
        map[`val`] = list.size - 1

        return true
    }

    fun remove(`val`: Int): Boolean {
        if (!map.containsKey(`val`)) {
            return false
        }

        val indexToRemove = map[`val`]!!
        val lastElement = list[list.size - 1]

        list[indexToRemove] = lastElement
        map[lastElement] = indexToRemove

        list.removeAt(list.size - 1)
        map.remove(`val`)

        return true
    }

    fun getRandom(): Int {
        val randomIndex = Random.nextInt(list.size)
        return list[randomIndex]
    }
}
