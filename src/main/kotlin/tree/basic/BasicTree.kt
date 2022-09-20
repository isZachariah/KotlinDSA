package tree.basic

import tree.basic.TreeNode

/**                     Basic Tree
 *
 *                            1
 *                   2               3
 *              1   4   5         2   1   6
 *                              1
 *
 * */


fun main() {
    val leftChild = TreeNode(
        value = 2,
        children = mutableListOf(
            TreeNode(1), TreeNode(4), TreeNode(5)
        )
    )
    val rightChild = TreeNode(
        value = 3,
        children = mutableListOf(
            TreeNode(value = 2, children = mutableListOf(TreeNode(1))),
            TreeNode(1), TreeNode(6)
        )
    )
    val root = TreeNode(
        value = 1,
        children = mutableListOf(leftChild, rightChild)
    )

    val findAllOnesTest = findOccurrencesOf(root, 1)
    val findNonExistentTest = findOccurrencesOf(root, 17)

    val answerOne = 4
    val answerNonExistent = 0
    val success = "Success"

    if (findAllOnesTest == answerOne) println(success) else println(findAllOnesTest)
    if (findNonExistentTest == answerNonExistent) println(success) else println(findNonExistentTest)






}

fun findOccurrencesOf(current: TreeNode, value: Int): Int {
    val hasOccurrence = if (value == current.value) 1 else 0

    return if (current.children.isEmpty()) {
        hasOccurrence
    } else {
        var occurrenceCounter = 0
        current.children.forEach { treeNode ->
            occurrenceCounter += findOccurrencesOf(treeNode, value)
        }
        hasOccurrence + occurrenceCounter
    }
}


//class Tree(
//    val root: TreeNode? = null
//) {
//    fun addChildren(
//        root: TreeNode,
//        branches: MutableList<TreeNode>
//    ) {
//        root.children += branches
//    }
//
//    override fun toString(): String {
//        return root.toString()
//    }
//}

data class TreeNode(
    var value: Int,
    var children: MutableList<TreeNode> = mutableListOf()
) {
    override fun toString(): String {
        return if (children.isEmpty()) {
            "$value"
        } else {
            "Root: $value -> "

        }
    }
}