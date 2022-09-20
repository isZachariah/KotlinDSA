package sorts.mergesort

fun <T : Comparable<T>> List<T>.mergeSort() : List<T> {
    if (this.size < 2) return this
    val middle = this.size / 2
    val left = this.subList(0, middle).mergeSort()
    val right = this.subList(middle, this.size).mergeSort()
    return merge(left, right)
}

private fun <T : Comparable<T>> merge(left: List<T>, right: List<T>) : List<T> {
    var leftIndex = 0
    var rightIndex = 0

    val result = mutableListOf<T>()

    while (leftIndex < left.size && rightIndex < right.size) {
        val leftElement = left[leftIndex]
        val rightElement = right[rightIndex]

        if (leftElement < rightElement) {
            result.add(leftElement)
            leftIndex++
        } else if (leftElement > rightElement) {
            result.add(rightElement)
            rightIndex++
        } else {
            result.add(leftElement)
            leftIndex++
            result.add(rightElement)
            rightIndex++
        }
    }
    if (leftIndex < left.size) {
        result.addAll(left.subList(leftIndex, left.size))
    }
    if (rightIndex < right.size) {
        result.addAll(right.subList(rightIndex, right.size))
    }
    return result
}

fun <T : Comparable<T>> merge(
    first: Iterable<T>,
    second: Iterable<T>
): Iterable<T> {
    val result = mutableListOf<T>()
    val firstIterator = first.iterator()
    val secondIterator = second.iterator()

    if (!firstIterator.hasNext()) return second
    if (!secondIterator.hasNext()) return first

    var firstElement = firstIterator.nextOrNull()
    var secondElement = secondIterator.nextOrNull()

    while (firstElement != null && secondElement != null) {
        when {
            firstElement < secondElement -> {
                result.add(firstElement)
                firstElement = firstIterator.nextOrNull()
            }
            secondElement < firstElement -> {
                result.add(secondElement)
                secondElement = secondIterator.nextOrNull()
            }
            else -> {
                result.add(firstElement)
                result.add(secondElement)
                firstElement = firstIterator.nextOrNull()
                secondElement = secondIterator.nextOrNull()
            }
        }
    }
    while (firstElement != null) {
        result.add(firstElement)
        firstElement = firstIterator.nextOrNull()
    }
    while (secondElement != null) {
        result.add(secondElement)
        secondElement = firstIterator.nextOrNull()
    }
    return result
}

private fun <T> Iterator<T>.nextOrNull() : T? {
    return if (this.hasNext()) this.next() else null
}