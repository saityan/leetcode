package leetcode.matrix

/**
 * https://leetcode.com/problems/image-smoother/
 */

import kotlin.math.min
import kotlin.math.max

private class ImageSmoother {
    fun imageSmoother(img: Array<IntArray>): Array<IntArray> {
        if (img.isEmpty() || img[0].isEmpty()) return emptyArray()

        val rows = img.size
        val cols = img[0].size
        val res = Array(rows) { IntArray(cols) }

        for (i in 0 until rows)
            for (j in 0 until cols) {
                var sum = img[i][j]
                var nums = 1

                for (x in max(0, i - 1)..min(rows - 1, i + 1))
                    for (y in max(0, j - 1)..min(cols - 1, j + 1)) {
                        if (x == i && y == j) continue
                        sum += img[x][y]
                        nums++
                    }

                res[i][j] = sum / nums
            }

        return res
    }
}
