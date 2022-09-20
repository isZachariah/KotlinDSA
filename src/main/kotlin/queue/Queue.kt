package queue

interface Queue<T> {
    val size: Int
    val isEmpty: Boolean
        get() = size == 0
    fun enqueue(element: T): Any?
    fun enqueueAll(vararg elements: T) : Boolean
    fun dequeue(): T?
    fun dequeue(count: Int) : Boolean
    fun peek(): T?
}

/**
            The core operations for a queue are:

• enqueue: Inserts an element at the back of the queue and
  returns true if the operation is successful.
• dequeue: Removes the element at the front of the queue
  and returns it.
• isEmpty: Checks if the queue is empty using the count property
• peek: Returns the element at the front of the queue without
  removing it.

 */