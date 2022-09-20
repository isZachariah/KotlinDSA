package tree.avl

fun main()
{
    val tree = AVLTree<Int>()
    tree.insert(15)
    tree.insert(10)
    tree.insert(16)
    tree.insert(18)
    print(tree)
    println("\n-------------------\n")
    tree.remove(10)
    print(tree)

    println(tree leafNodes tree.root!!.height)



}

