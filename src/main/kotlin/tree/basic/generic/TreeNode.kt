package tree.basic.generic

import queue.ArrayListQueue

fun main() {
    val tree = TreeNode<Int>(15)
    val one1 = TreeNode(1)
    val sevenTeen = TreeNode(17)
    val twenty = TreeNode(20)
    val one2 = TreeNode(1)
    val five1 = TreeNode(5)
    val zero = TreeNode(0)
    val two = TreeNode(2)
    val five2 = TreeNode(5)
    val seven = TreeNode(7)

    tree.addChildren(listOf(one1,sevenTeen,twenty))

    one1.addChildren(listOf(one2,five1,zero))
    sevenTeen.add(two)
    twenty.addChildren(listOf(five2,seven))

    val queue = ArrayListQueue<TreeNode<Int>>()



}

//fun makeBeverageTree(): TreeNode<String> {
//    val tree = TreeNode("Beverages")
//    val hot = TreeNode("hot")
//    val cold = TreeNode("cold")
//    val tea = TreeNode("tea")
//    val coffee = TreeNode("coffee")
//    val chocolate = TreeNode("cocoa")
//    val blackTea = TreeNode("black")
//    val greenTea = TreeNode("green")
//    val chaiTea = TreeNode("chai")
//    val soda = TreeNode("soda")
//    val milk = TreeNode("milk")
//    val gingerAle = TreeNode("ginger ale")
//    val bitterLemon = TreeNode("bitter lemon")
//    tree.add(hot)
//    tree.add(cold)
//    hot.add(tea)
//    hot.add(coffee)
//    hot.add(chocolate)
//    cold.add(soda)
//    cold.add(milk)
//    tea.add(blackTea)
//    tea.add(greenTea)
//    tea.add(chaiTea)
//    soda.add(gingerAle)
//    soda.add(bitterLemon)
//    return tree
//}


class TreeNode<T>(val value: T) {
    private val children: MutableList<TreeNode<T>> =
        mutableListOf()

    fun add(child: TreeNode<T>) = children.add(child)

    fun addChildren(addChildren: List<TreeNode<T>> = listOf<TreeNode<T>>()) =
        addChildren.forEach {
            children.add(it)
        }

    fun forEachDepthFirst(visit: Visitor<T>) {
        visit(this)
        children.forEach {
            it.forEachDepthFirst(visit)
        }
    }

    fun forEachLevelOrder(visit: Visitor<T>) {
        visit(this)
        val queue = ArrayListQueue<TreeNode<T>>()
        children.forEach { queue.enqueue(it) }

        var node = queue.dequeue()

        while (node != null) {
            visit(node)
            node.children.forEach { queue.enqueue(it) }
            node = queue.dequeue()
        }
    }

    fun search(value: T): TreeNode<T>? {
        var result: TreeNode<T>? = null
        forEachLevelOrder {
            if (it.value == value) {
                result = it }
        }
        return result
    }

}

typealias Visitor<T> = (TreeNode<T>) -> Unit

