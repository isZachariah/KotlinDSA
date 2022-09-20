package stack

class Stack<Element>() : StackInterface<Element> {
    private val storage = arrayListOf<Element>()

    override val size: Int
        get() = storage.size

    override val isEmpty: Boolean
        get() = super.isEmpty

    override fun push(element: Element) : Stack<Element> {
        storage.add(element)
        return this
    }

    override fun pushAll(vararg elements: Element) {
        storage.addAll(elements)
    }

    override fun pop(): Element? {
        return if (isEmpty) null
        else storage.removeAt(size -1)
    }

    override fun pop(count: Int) : Boolean {
        if (isEmpty || size < count) return false
        for (i in 0 until count) {
            storage.removeAt(size - 1)
        }
        return true
    }

    override fun peek(): Element? {
        return storage.lastOrNull()
    }

    override fun shuffle() : Boolean {
        return if (isEmpty) false
        else {
            storage.shuffle()
            true
        }
    }

    companion object {
        fun <Element> create(items: Iterable<Element>) :
                Stack<Element> {
            val stack = Stack<Element>()
            items.forEach {
                stack.push(it)
            }
            return stack
        }
    }


    override fun toString() = buildString {
        appendLine("----top----")
        storage.asReversed().forEach {
            appendLine("    $it")
        }
        appendLine("-----------")
    }
}

fun <Element> stackOf(vararg elements: Element) : Stack<Element>
{
    return Stack.create(elements.asList())
}
