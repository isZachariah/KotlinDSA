package tree.binarysearch

fun main(args: Array<String>) {
    val tree = binarySearchTreeOf(1, 8, 6, 3, 44, 9, 15, 22, 34, 0, 16, 97, 45, 100, 17, 12, 21, 7, 80)
//    val tree = Node(5)
//    val keys = arrayOf(1, 8, 6, 3, 9, 15, 22, 34, 0, 97, 45, 17, 12, 21, 7, 80)
//    for (key in keys) {
//        tree.insert(key)
//    }
//    val node = tree.find(22)!!
//
    println(tree)


}


data class Node(
    var key: Int,
    var left: Node? = null,
    var right: Node? = null,
) {

    fun find(value: Int): Node? = when {
        this.key > value -> left?.find(value)
        this.key < value -> right?.find(value)
        else -> this
    }

    fun insert(value: Int) {
        if (value > this.key) {
            if (this.right == null) {
                this.right = Node(value)
            } else {
                this.right?.insert(value)
            }
        } else if (value < this.key) {
            if (this.left == null) {
                this.left = Node(value)
            } else {
                this.left?.insert(value)
            }
        }
    }

    companion object {
        fun create(nodes: Iterable<Int>) : Node {
            val tree = Node(nodes.first())
            nodes.forEach {
                tree.insert(it)
            }
            return tree
        }
    }

    fun delete(value: Int) {
        when {
            value > this.key -> scan(value, this.right, this)
            value < this.key -> scan(value, this.left, this)
            else -> removeNode(this, null)
        }
    }

    private fun scan(value: Int, node: Node?, parent: Node?) {
        if (node == null) {
            println("value $value seems not to be present in the tree")
            return
        }
        when {
            value > node.key -> scan(value, node.right, node)
            value < node.key -> scan(value, node.left, node)
            value == node.key -> removeNode(node, parent)
        }
    }

    private fun removeNode(node: Node, parent: Node?) {
        node.left?.let { leftChild ->
            run {
                node.right?.let {
                    removeTwoChildNode(node)
                } ?: removeSingleChildNode(node, leftChild)
            }
        } ?: run {
            node.right?.let { rightChild ->
                removeSingleChildNode(node, rightChild)
            } ?: removeNoChildNode(node, parent)
        }
    }

    private fun removeNoChildNode(node: Node, parent: Node?) {
        parent?.let { p ->
            if (node == p.left) {
                p.left = null
            } else if (node == p.right) {
                p.right = null
            }
        } ?: throw IllegalStateException("Can not remove the root node without child nodes")
    }

    private fun removeTwoChildNode(node: Node) {
        val leftChild = node.left!!
        leftChild.right?.let {
            val maxParent = findParentOfMaxChild(leftChild)
            maxParent.right?.let {
                node.key = it.key
                maxParent.right = null
            }?: throw IllegalStateException("Node with max child must have the right child!")
        } ?: run {
            node.key = leftChild.key
            node.left = leftChild.left
        }
    }

    private fun findParentOfMaxChild(node: Node): Node {
        return node.right?.let { r -> r.right?.let { findParentOfMaxChild(r) } ?: node }
            ?: throw IllegalArgumentException("Right child must be non-null")
    }

    private fun removeSingleChildNode(parent: Node, child: Node) {
        parent.key = child.key
        parent.left = child.left
        parent.right = child.right
    }

    fun visit(): Array<Int> {
        val a = left?.visit() ?: emptyArray()
        val b = right?.visit() ?: emptyArray()
        return a + arrayOf(key) + b
    }

    override fun toString() = diagram(this)

    private fun diagram(
        node: Node?,
        top: String = "",
        root: String = "",
        bottom: String = "",
    ) : String {
        return node?.let {
            if (node.left == null && node.right == null) {
                "$root${node.key}\n"
            } else {
                diagram(
                    node.right,
                    "$top ",
                    "$top┌──",
                    "$top│ "
                ) + root + "${node.key}\n" +
                        diagram(
                            node.left,
                            "$bottom│ ",
                            "$bottom└──",
                            "$bottom ")
            }
        } ?: "${root}null\n"
    }
}

fun binarySearchTreeOf(vararg elements: Int) : Node
{
    return Node.create(elements.asList())
}

