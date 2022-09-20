package linkedlist.singlylinkedlist


fun main(args: Array<String>) {

    val list = LinkedList<Int>()
    list.push(1).push(2).push(3).push(5).push(15)
    println(list)

    list.insertWithIndex(45, 1)

    println(list)


}





