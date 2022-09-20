package sorts

import sorts.selectionsort.selectionSort

fun <T> MutableList<T>.swapAt(first: Int, second: Int) : Boolean {
    val aux = this[first]
    this[first] = this[second]
    this[second] = aux
    return true
}

infix fun<T : Comparable<T>> MutableList<T>.rightAlign(element: T) {
    if (this.size < 2) return
    var searchIndex = this.size - 2
    while (searchIndex >= 0) {
        if (this[searchIndex] == element) {
            var moveIndex = searchIndex
            while (moveIndex < this.size - 1 && this[moveIndex + 1] != element) {
                swapAt(moveIndex, moveIndex + 1)
                moveIndex++
            }
        }
        searchIndex--
    }
}

fun <T: Comparable<T>> MutableList<T>.biggestDuplicate() : T? {
    this.selectionSort()
    for (i in (1 until this.size).reversed()) {
        if (this[i] == this[i - 1]) {
            return this[i]
        }
    }
    return null
}