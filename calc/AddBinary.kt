package leetcode.calc

// https://leetcode.com/problems/add-binary

private class AddBinary {
    fun addBinary(a: String, b: String): String = (a.toBigInteger(2) + b.toBigInteger(2)).toString(2)
}
