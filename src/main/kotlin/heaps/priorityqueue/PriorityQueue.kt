package heaps.priorityqueue

import heaps.ComparableHeapImpl
import heaps.ComparatorHeapImpl
import heaps.Heap
import queue.Queue

abstract class AbstractPriorityQueue<T> : Queue<T> {
    abstract val heap: Heap<T>
        get

    override val size: Int
        get() = heap.count

    override fun enqueue(element: T): Boolean {
        heap.insert(element)
        return true
    }

    override fun enqueueAll(vararg elements: T): Boolean {
        elements.forEach { heap.insert(it) }
        return true
    }

    override fun dequeue(): T? {
        return heap.remove()
    }

    override fun dequeue(count: Int): Boolean {
        return if (size < count) false
        else {
            for (i in 0 until count) {
                heap.remove(0)
            }
            true
        }
    }

    override fun peek(): T? {
        return heap.peek()
    }
}

class ComparablePriorityQueueImpl<T : Comparable<T>> :
    AbstractPriorityQueue<T>() {
    override val heap = ComparableHeapImpl<T>()
}

class ComparatorPriorityQueueImpl<T>(private val comparator: Comparator<T>
) : AbstractPriorityQueue<T>() {
    override val heap = ComparatorHeapImpl(comparator)
}