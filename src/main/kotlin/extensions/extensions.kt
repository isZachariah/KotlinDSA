package extensions

fun readInt() = readln().toInt() // single int
fun readStrings() = readln().split(" ") // list of strings
fun readInts() = readStrings().map { it.toInt() } // list of ints


fun <T> swap(list: MutableList<T>, i: Int, j: Int) {
    val t = list[i]
    list[i] = list[j]
    list[j] = t
}

fun <T> swap(arr: Array<T>, i: Int, j: Int) {
    val t = arr[i]
    arr[i] = arr[j]
    arr[j] = t
}

fun <T> swap(arrayList: ArrayList<T>, a: Int, b: Int) {
    val c = arrayList[a]
    arrayList[a] = arrayList[b]
    arrayList[b] = c
}