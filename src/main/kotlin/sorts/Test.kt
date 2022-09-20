package sorts

import sorts.bubblesort.bubbleSort
import sorts.insertionsort.insertionSort
import sorts.radixsort.lexicographicalSort
import sorts.radixsort.radixSort
import sorts.selectionsort.selectionSort

fun main() {
//    val  list = arrayListOf(1,45,3,600,7,67,9,908,10,2)
//    val  list2 = arrayListOf(1,45,3,6,7,67,9,9,10,2)
//    val  list3 = arrayListOf(1,45,3,6,7,67,9,9,10,2)
//
//    println("Original: $list")
//    list.bubbleSort(true)
//    println("Bubble sorted: $list\n")
//
//    println("Original: $list2")
//    list2.selectionSort(true)
//    println("Bubble sorted: $list2\n")
//
//    println("Original: $list3")
//    list3.insertionSort(true)
//    println("Bubble sorted: $list3\n")
//    list rightAlign 9
//    list.radixSort()
//    println("Radix Sort: $list")
    val list= (0..10).map { (Math.random() *
            10000).toInt() }.toMutableList()
    println("Original: $list")
    list.lexicographicalSort()
    println("Radix sorted: $list")
}