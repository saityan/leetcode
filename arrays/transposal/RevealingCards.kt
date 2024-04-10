package leetcode.arrays.transposal

/**
 * https://leetcode.com/problems/reveal-cards-in-increasing-order
 *
 * Return an ordering of the deck that would reveal the cards in increasing order.
 */

private class RevealingCards {
    fun deckRevealedIncreasing(deck: IntArray): IntArray {
        if (deck.isEmpty()) return deck

        val steps = deck.size
        val sortedDeck = deck.sorted()

        val result = ArrayDeque<Int>(steps)
        for (i in steps - 1 downTo 0) {
            if (result.isNotEmpty()) {
                result.addFirst(result.removeLast())
            }
            result.addFirst(sortedDeck[i])
        }

        return result.toIntArray()
    }
}
