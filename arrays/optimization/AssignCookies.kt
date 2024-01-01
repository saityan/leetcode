package leetcode.arrays.optimization

/**
 * https://leetcode.com/problems/assign-cookies/
 */

private class AssignCookies {
    fun findContentChildren(g: IntArray, s: IntArray): Int {
        val children = g.sorted()
        val cookies = s.sorted()

        var res = 0
        var cookieIndex = 0

        for (childSize in children) {
            while (cookieIndex < cookies.size && cookies[cookieIndex] < childSize) {
                cookieIndex++
            }

            if (cookieIndex < cookies.size) {
                res++
                cookieIndex++
            } else {
                break
            }
        }

        return res
    }
}
