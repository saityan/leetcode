package leetcode.lists

/**
 * https://leetcode.com/problems/delete-node-in-a-linked-list
 */

private class DeletedNode {
    fun deleteNode(node: ListNode?) {
        if (node?.next == null) return

        var current: ListNode? = node

        while (current?.next?.next != null) {
            current.`val` = current.next?.`val` ?: 0
            current = current.next
        }

        current?.`val` = current?.next?.`val` ?: 0

        current?.next = null
    }
}
