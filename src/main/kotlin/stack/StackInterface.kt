package stack

interface StackInterface<Element> {
    val size: Int
    val isEmpty: Boolean
        get() = size == 0

    fun push(element: Element) : Stack<Element>
    fun pushAll(vararg elements: Element)
    fun pop(): Element?
    fun pop(count: Int) : Boolean
    fun peek(): Element?
    fun shuffle() : Boolean

}

fun main() {
    val stack = stackOf(1,2,3,4,5,6,7,8,9,10,11,12)
    print(stack)
    println("Popped: ${stack.pop()}")
}

