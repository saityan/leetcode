package leetcode.lists

/**
 * https://leetcode.com/problems/reverse-linked-list
 */

private class ReversedLinkedList {
    fun reverseList(head: ListNode?): ListNode? {

        if (head == null) return null
        if (head.next == null) return head

        var result: ListNode? = null

        fun traverse(currentNode: ListNode?, previousNode: ListNode?) {
            if (currentNode == null) {
                result = previousNode
                return
            }

            val temp = currentNode.next
            currentNode.next = previousNode

            traverse(temp, currentNode)
        }

        traverse(head, null)

        return result
    }
}
