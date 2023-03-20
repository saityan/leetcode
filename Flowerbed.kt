package leetcode

/**
 * You have a long flowerbed in which some plots are planted, and some are not.
 * However, flowers cannot be planted in adjacent plots.
 * Given an integer array flowerbed containing 0's and 1's, where 0 means empty and 1 means not empty, and an integer n,
 * return if n new flowers can be planted in the flowerbed without violating the no-adjacent-flowers rule.
 */

private fun canPlaceFlowers(flowerbed: IntArray, n: Int): Boolean {
    if (n < 0)
        return false
    if (n == 0)
        return true
    if (flowerbed.isEmpty())
        return false
    if (flowerbed.size < 2 * n - 1)
        return false
    if (flowerbed.size == 1)
        return flowerbed[0] == 0
    if (flowerbed.size == 2)
        return flowerbed[0] == 0 && flowerbed[1] == 0

    var i = 1
    var k = n
    if (flowerbed[0] == 0 && flowerbed[1] == 0) {
        flowerbed[0] = 1
        k--
    }
    while (k > 0 && i < flowerbed.size - 1) {
        if (flowerbed[i] == 0 && flowerbed[i - 1] == 0 && flowerbed[i + 1] == 0) {
            flowerbed[i] = 1
            i += 2
            k--
        } else
            i++
    }
    if (k == 0)
        return true
    if (flowerbed[flowerbed.size - 2] == 0 && flowerbed[flowerbed.size - 1] == 0)
        k--
    return k == 0
}
