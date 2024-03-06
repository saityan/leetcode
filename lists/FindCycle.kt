package leetcode.lists

/**
 * https://leetcode.com/problems/linked-list-cycle/
 */

private class FindCycle {
    fun hasCycle(head: ListNode?): Boolean {

        var hare = head
        var tort = head

        while (hare?.next != null) {
            tort = tort?.next
            hare = hare.next?.next

            if (tort === hare) {
                return true
            }
        }

        return false
    }
}
