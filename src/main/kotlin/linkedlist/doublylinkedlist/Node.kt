package linkedlist.doublylinkedlist


data class Node<T>(
    var value: T,
    var previous: Node<T>? = null,
    var next: Node<T>? = null
) {
    override fun toString(): String {
        return if (next != null) {
            "$value -> ${next.toString()}"
        } else {
            "$value"
        }
    }
}

