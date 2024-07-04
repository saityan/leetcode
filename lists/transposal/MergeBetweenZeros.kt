package leetcode.lists.transposal

import leetcode.lists.ListNode

// https://leetcode.com/problems/merge-nodes-in-between-zeros/

private class MergeBetweenZeros {
    fun mergeNodes(head: ListNode?): ListNode? {
        head ?: return null
        val dummy = ListNode(0)
        var memo = 0
        var current = head.next
        var currentNew = dummy
        while (current != null) {
            if (current.`val` == 0) {
                currentNew.next = ListNode(memo)
                currentNew.next?.let { currentNew = it }
                memo = 0
                current = current.next
            } else {
                memo += current.`val`
                current = current.next
            }
        }

        return dummy.next
    }
}
