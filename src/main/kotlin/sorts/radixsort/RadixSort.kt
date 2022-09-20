package sorts.radixsort

import java.lang.Math.pow
import kotlin.math.pow

fun MutableList<Int>.radixSort(showPasses: Boolean = false) {
    val base = 10
    var done = false
    var digits  = 1
    while (!done) {
        if (showPasses) println(this)
        done = true
        val buckets = arrayListOf<MutableList<Int>>().apply {
            for (i in 0..9) {
                this.add(arrayListOf())
            }
        }
        this.forEach { number ->
            val remainingPart = number / digits
            val digit = remainingPart % base
            buckets[digit].add(number)

            if (remainingPart > 0) {
                done = false
            }
        }
        digits *= base

        this.clear()
        this.addAll(buckets.flatten())
    }
}


fun MutableList<Int>.lexicographicalSort() {
    this.clear()
    this.addAll(msdRadixSorted(this, 0))
}

private fun msdRadixSorted(list: MutableList<Int>, position: Int) : MutableList<Int> {
    if (position > list.maxDigits()) return list
    val buckets = arrayListOf<MutableList<Int>>().apply {
        for (i in 0..9) {
            this.add(arrayListOf())
        }
    }
    val priorityBucket = arrayListOf<Int>()
    list.forEach { number ->
        val digit = number.digit(position)
        if (digit == null) {
            priorityBucket.add(number)
            return@forEach
        }
        buckets[digit].add(number)
    }
    priorityBucket.addAll(
        buckets.reduce { result, bucket ->
            if (bucket.isEmpty()) return@reduce result
            result.addAll(msdRadixSorted(bucket, position + 1))
            result
        }
    )
    return priorityBucket
}


fun Int.digits() : Int {
    var count = 0
    var num = this
    while (num != 0) {
        count += 1
        num /= 10
    }
    return count
}

fun Int.digit(atPosition: Int) : Int? {
    if (atPosition > digits()) return null
    var num = this
    val correctedPosition = (atPosition + 1).toDouble()
    while (num / (10.0.pow(correctedPosition).toInt()) != 0) {
        num /= 10
    }
    return num % 10
}

private fun MutableList<Int>.maxDigits() : Int {
    return this.max().digits() ?: 0
}