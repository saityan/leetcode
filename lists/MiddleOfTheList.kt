package leetcode.lists

private class MiddleOfTheList {
    fun middleNode(head: ListNode?): ListNode? {
        head ?: return null

        var hare = head
        var tort = head

        while (hare?.next != null) {
            tort = tort?.next
            hare = hare.next?.next
        }

        return tort
    }
}
