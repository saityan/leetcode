package leetcode.lists

import java.util.Stack

/**
 * https://leetcode.com/problems/palindrome-linked-list/
 */

private class PalindromeList {
    fun isPalindrome(head: ListNode?): Boolean {
        head ?: return false

        val nodes = mutableListOf<Int>()
        var current = head

        while (current != null) {
            nodes.add(current.`val`)
            current = current.next
        }

        var i = 0
        var j = nodes.lastIndex
        while (i < j) {
            if (nodes[i] != nodes[j]) {
                return false
            }

            i++
            j--
        }

        return true
    }
}
