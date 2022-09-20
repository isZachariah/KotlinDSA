package linkedlist.doublylinkedlist

class DoublyLinkedList<T> {

    private var head: Node<T>? = null
    private var tail: Node<T>? = null
    var size = 0

    fun isEmpty() : Boolean {
        return size == 0
    }

    fun size() = size

    fun getFirst() = head?.value
    fun getLast() = tail?.value

    fun removeFirst() = unlinkHead()

    fun removeLast() = unlinkTail()

    fun addFirst(element: T) {
        linkHead(element)
    }

    fun addLast(element: T) {
        linkTail(element)
    }

    fun add(element: T) {
        linkTail(element)
    }

    fun <E> addAll(index: Int, arr: Array<T>) : Boolean where E : T {
        validatePositionIndex(index)

        val arrSize = arr.size

        if (arrSize == 0) return false

        var pred: Node<T>?
        var succ: Node<T>?

        when (index) {
            0 -> {
                succ = head
                pred = tail
            }
            else -> {
                succ = node(index)
                pred = succ.previous
            }
        }
        for (item in arr) {
            val e = item as T
            val newNode = Node<T>(e, pred, null)
            if (pred == null) head = newNode
            else pred.next = newNode
            pred = newNode
        }
        if (succ == null) {
            tail = pred
        } else {
            pred!!.next = succ
            succ.previous = pred
        }
        size += arrSize
        return true
    }

    fun remove(element: T): Boolean {
        var current = head
        while (current != null) {
            if (current.value == element) {
                unlink(current)
                return true
            }
            current = current.next
        }
        return true
    }

    fun clear() {
        var current = head
        while (current != null) {
            val next = current.next
            current.next = null
            current.previous = null

            current = next
        }
        tail = null
        head = tail
        size = 0
    }

    operator fun contains(element: T) = indexOf(element) != -1

    fun get(index: Int): T {
        validateElementIndex(index)
        return node(index).value
    }

    fun set(index: Int, element: T): T {
        validateElementIndex(index)
        val x = node(index)
        val oldVal = x.value
        x.value = element
        return oldVal
    }

    fun add(index: Int, element: T) {
        validatePositionIndex(index)
        if (index == size) {
            linkTail(element)
        } else {
            linkBefore(element, node(index))
        }
    }

    fun remove(index: Int): T {
        validateElementIndex(index)
        return unlink(node(index))
    }

    fun indexOf(element: T): Int {
        var index = 0
        var x = head
        while (x != null) {
            if (element == x.value)
                return index
            index++
            x = x.next
        }
        return -1
    }

    private fun linkHead(element: T) {
        val h = head
        val newNode = Node<T>(element,null, h)
        head = newNode
        if (h == null) {
            tail = newNode
        } else {
            h.previous = newNode
        }
        size++
    }

    private fun linkTail(element: T) {
        val t = tail
        val newNode = Node<T>(element, t, null)
        tail = newNode
        if (t == null) {
            head = newNode
        } else {
            t.next = newNode
        }
        size++
    }

    private fun linkBefore(element: T, succ: Node<T>) {
        val pred = succ.previous
        val newNode = Node( element, pred, succ)
        succ.previous = newNode
        if (pred == null) {
            head = newNode
        } else {
            pred.next = newNode
        }
        size++
    }

    private fun unlinkHead() {
        head?.let {
            val next = it.next
            it.next = null
            head = next
            if (next == null) {
                tail = null
            } else {
                next.previous = null
            }
            size--
        }
    }

    private fun unlinkTail() {
        tail?.let {
            val prev = it.previous
            it.previous = null
            tail = prev
            if (prev == null) {
                head = null
            } else {
                prev.next = null
            }
            size--
        }
    }

    private fun unlink(curr: Node<T>): T {
        val element = curr.value
        val next = curr.next
        val prev = curr.previous

        if (prev == null) {
            head = next
        } else {
            prev.next = next
            curr.previous = null
        }

        if (next == null) {
            tail = prev
        } else {
            next.previous = prev
            curr.next = null
        }

        size--
        return element
    }

    private fun node(index: Int): Node<T> {
        if (index < size shr 1) {
            var x = head
            for (i in 0 until index)
                x = x!!.next
            return x!!
        } else {
            var x = tail
            for (i in size - 1 downTo index + 1)
                x = x!!.previous
            return x!!
        }
    }

    private fun validateElementIndex(index: Int) {
        if (index < 0 || index >= size)
            throw IndexOutOfBoundsException(outOfBoundsMsg(index))
    }

    private fun validatePositionIndex(index: Int) {
        if (index in (size + 1)..-1)
            throw IndexOutOfBoundsException(outOfBoundsMsg(index))
    }

    private fun outOfBoundsMsg(index: Int): String {
        return "Index: $index, Size: $size"
    }



}