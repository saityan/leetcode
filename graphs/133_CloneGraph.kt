package leetcode.graphs

/**
 * https://leetcode.com/problems/clone-graph/
 */

private class Node(var `val`: Int) {
    var neighbors: ArrayList<Node?> = ArrayList()
}

private class `133_CloneGraph` {
    fun cloneGraph(node: Node?): Node? {
        if (node == null)
            return null

        val copiedGraph = Array<Node?>(101) {
            null
        }

        fun traverse(node: Node) : Node {

            copiedGraph[node.`val`]?.let {
                return it
            }

            val copiedNode = Node(node.`val`)
            copiedGraph[node.`val`] = copiedNode

            if (node.neighbors.isNotEmpty()) {
                for (next in node.neighbors) {
                    val nextNode = traverse(next!!)
                    copiedNode.neighbors.add(nextNode)
                }
            }
            return copiedNode
        }
        return traverse(node)
    }
}
