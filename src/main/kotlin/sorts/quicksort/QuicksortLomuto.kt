package sorts.quicksort

import sorts.swapAt

fun <T :  Comparable<T>> MutableList<T>.quicksortLomuto(
    low: Int,
    high: Int
) {
    if (low < high) {
        val pivot = this.partitionLomuto(low, high)
        this.quicksortLomuto(low, pivot - 1)
        this.quicksortLomuto(pivot + 1, high)
    }
}

fun <T : Comparable<T>> MutableList<T>.partitionLomuto(
    low: Int,
    high: Int
) : Int {
    val pivot = this[high]
    var i = low
    for (j in low until high) {
        if (this[j] <= pivot) {
            this.swapAt(i, j)
            i++
        }
    }
    this.swapAt(i, high)
    return i
}