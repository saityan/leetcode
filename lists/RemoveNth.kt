package leetcode.lists

/**
 * https://leetcode.com/problems/remove-nth-node-from-end-of-list/
 */

private class RemoveNth {
    fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {
        head ?: return null

        val dummy = ListNode(Integer.MIN_VALUE)
        dummy.next = head

        var firstPointer: ListNode? = dummy
        var secondPointer: ListNode? = dummy

        repeat(n + 1) {
            firstPointer = firstPointer?.next
        }

        while (firstPointer != null) {
            firstPointer = firstPointer?.next
            secondPointer = secondPointer?.next
        }

        secondPointer?.next = secondPointer?.next?.next

        return dummy.next
    }
}
