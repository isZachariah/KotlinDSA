package sorts.bubblesort

import sorts.swapAt

fun <T : Comparable<T>> MutableList<T>.bubbleSort(showPasses: Boolean = false) {
    if (this.size < 2) return

    for (end in (1 until this.size).reversed()) {
        var swapped = false
        for (current in 0 until end) {
            if  (this[current] > this[current + 1]) {
                swapped = this.swapAt(current, current + 1)
            }
        }
        if (showPasses) println(this)
        if (!swapped) return
    }
}