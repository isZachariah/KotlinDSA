package tries

class Trie<Key> {
    private val root = TrieNode<Key>(key = null, parent = null)

    private val storedLists: MutableSet<List<Key>> = mutableSetOf()
    val lists: List<List<Key>>
        get() = storedLists.toList()

    val count: Int
        get() = storedLists.count()

    val isEmpty: Boolean
        get() = storedLists.isEmpty()

    fun insert(list: List<Key>) {
        var current = root

        list.forEach { element ->
            if (current.children[element] == null) {
                current.children[element] = TrieNode(element, current)
            }
            current = current.children[element]!!
        }
        current.isTerminating = true
        storedLists.add(list)
    }

    fun contains(list: List<Key>) : Boolean {
        var current = root

        list.forEach { element ->
            val child = current.children[element] ?: return false
            current = child
        }
        return current.isTerminating
    }

    fun remove(list: List<Key>) {
        var current = root

        list.forEach { element ->
            val child = current.children[element] ?: return
            current = child
        }

        if (!current.isTerminating) return
        current.isTerminating = false
        storedLists.remove(list)

        val parent = current.parent
        while (parent != null && current.children.isEmpty() && !current.isTerminating) {
            parent.children.remove(current.key)
            current = parent
        }
    }

    fun collections(prefix: List<Key>) : List<List<Key>> {
        var current = root

        prefix.forEach { element ->
            val child = current.children[element] ?: return emptyList()
            current = child
        }
        return collections(prefix, current)
    }

    private fun collections(prefix: List<Key>, node: TrieNode<Key>?) : List<List<Key>> {
        val results = mutableListOf<List<Key>>()
        if (node?.isTerminating == true) {
            results.add(prefix)
        }
        node?.children?.forEach { (key, node) ->
            results.addAll(collections(prefix + key, node))
        }
        return results
    }

}