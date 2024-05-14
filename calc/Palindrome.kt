package leetcode.calc

// https://leetcode.com/problems/palindrome-number

private class Palindrome {
    fun isPalindrome(x: Int): Boolean = x.toString() == x.toString().reversed()
}