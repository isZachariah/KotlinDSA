package tree.avl

import kotlin.math.pow

class AVLTree<T: Comparable<T>> {

    var root: AVLNode<T>? = null

    fun insert(value: T) {
        root = insert(root, value)
    }

    private fun insert(node: AVLNode<T>?, value: T): AVLNode<T> {
        node ?: return AVLNode(value)

        if (value < node.value) {
            node.leftChild = insert(node.leftChild, value)
        } else {
            node.rightChild = insert(node.rightChild, value)
        }
        val balancedNode = balanced(node)
        balancedNode?.height =
            (balancedNode?.leftHeight ?: 0) max (balancedNode?.rightHeight ?: 0) +1

        return balancedNode
    }

    fun remove(value: T) {
        root = remove(root, value)
    }

    private fun remove(node: AVLNode<T>?, value: T): AVLNode<T>? {
        node ?: return null

        when {
            value == node.value -> {

                if (node.leftChild == null && node.rightChild == null) return null
                if (node.leftChild == null) return node.rightChild
                if (node.rightChild == null) return node.leftChild

                node.rightChild?.min?.value?.let { node.value = it }

                node.rightChild = remove(node.rightChild, node.value)
            }
            value < node.value -> node.leftChild = remove(node.leftChild, value)
            else -> node.rightChild = remove(node.rightChild, value)
        }

        val balancedNode = balanced(node)
        balancedNode.height =
            balancedNode.leftHeight max balancedNode.rightHeight +1
        return balancedNode
    }

    fun contains(value: T): Boolean {
        // 1
        var current = root

        // 2
        while (current != null) {
            // 3
            if (current.value == value) {
                return true
            }

            // 4
            current = if (value < current.value) {
                current.leftChild
            } else {
                current.rightChild
            }
        }

        return false
    }

    private fun leftRotate(node: AVLNode<T>) : AVLNode<T> {
        val pivot = node.rightChild!!

        node.rightChild = pivot.leftChild
        pivot.leftChild = node

        node.height = node.leftHeight max node.rightHeight +1
        pivot.height = pivot.leftHeight max pivot.rightHeight +1

        return pivot
    }

    private fun rightRotate(node: AVLNode<T>) : AVLNode<T> {
        val pivot = node.leftChild!!
        node.leftChild = pivot.rightChild
        pivot.rightChild = node
        node.height = node.leftHeight max node.rightHeight +1
        pivot.height = pivot.leftHeight max pivot.rightHeight +1
        return pivot
    }

    private fun rightLeftRotate(node: AVLNode<T>) : AVLNode<T> {
        val rightChild = node.rightChild ?: return node
        node.rightChild = rightRotate(rightChild)
        return leftRotate(node)
    }

    private fun leftRightRotate(node: AVLNode<T>): AVLNode<T> {
        val leftChild = node.leftChild ?: return node
        node.leftChild = rightRotate(leftChild)
        return rightRotate(node)
    }

    private fun balanced(node: AVLNode<T>) : AVLNode<T> {
        return when (node.balanceFactor) {
            2 -> {
                if (node.leftChild?.balanceFactor == -1) {
                    leftRightRotate(node)
                }
                else rightRotate(node)

            }
            -2 -> {
                if (node.rightChild?.balanceFactor == 1) {
                    rightLeftRotate(node)
                }
                else leftRotate(node)
            }
            else -> node
        }
    }


    override fun toString() = root?.toString() ?: "empty tree"
}

infix fun <T : Comparable<T>> AVLTree<T>.leafNodes(height: Int) : Int {
    return 2.0.pow(height).toInt()
}