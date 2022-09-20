package queue

class ArrayListQueue<T> : Queue<T> {

    private val list = arrayListOf<T>()
    override val isEmpty: Boolean
        get() = super.isEmpty

    override val size: Int
        get() = list.size

    companion object {
        fun <T> create(items: Iterable<T>) : ArrayListQueue<T> {
            val queue = ArrayListQueue<T>()
            items.forEach {
                queue.enqueue(it)
            }
            return queue
        }
    }

    override fun enqueue(element: T): ArrayListQueue<T> {
        list.add(element)
        return this
    }

    override fun enqueueAll(vararg elements: T): Boolean {
        list.addAll(elements)
        return true
    }

    override fun dequeue(): T? =
        if (isEmpty) null else list.removeAt(0)

    override fun dequeue(count: Int): Boolean {
        return if (isEmpty || size < count) false
        else {
            for (i in 0 until count) {
                val removed = list.removeAt(0)
            }
            true
        }
    }

    override fun peek(): T? = list.getOrNull(0)

    override fun toString(): String = list.toString()
}

fun <T> queueOf(vararg elements: T) : ArrayListQueue<T>
{
    return ArrayListQueue.create(elements.asList())
}

fun main() {
    val queue = queueOf(1,2,3,4,5,6,7,8,9,0)
    println(queue)
    println(queue.peek())
    println(queue.dequeue())
    println(queue)
    println(queue.dequeue(4))
    println(queue)
    queue.enqueueAll(1,2,3,4,5)
    println(queue)
    queue
        .enqueue(6)
        .enqueue(7)

    println(queue)

}