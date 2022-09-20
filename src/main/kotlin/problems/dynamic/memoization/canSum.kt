package dynamic.solutions.memoization

/** canSum
 *
 * Write a function `canSum(targetSum: Int, numbers: Array<Int>) : Boolean`
 * that takes in a targetSum and an array of numbers as arguments.
 *
 * The function should return a boolean indicating whether it
 * is possible to generate the targetSum using numbers from the array.
 *
 * You may use an element of the array as many times as needed.
 *
 * You may assume that all input numbers are non-negative.
 *
 * */

fun main() {
    println(canSum(7, arrayOf(2,3), hashMapOf()))      // true
    println(canSum(7, arrayOf(5,3,4,7), hashMapOf()))  // true
    println(canSum(7, arrayOf(2,4), hashMapOf()))      // false
    println(canSum(8, arrayOf(2,3,5), hashMapOf()))    // true
    println(canSum(300, arrayOf(7,14), hashMapOf()))   // false
}

// m = target sum, n = array length
// memoization = time: O(m * n), space: O(m)
//val cache = hashMapOf<Int, Boolean>() || Because each cache needs to be different it
// must be passed as a parameter instead of created outside the function
fun canSum(targetSum: Int, numbers: Array<Int>, cache: HashMap<Int, Boolean>) : Boolean {
    if (targetSum in cache) return cache[targetSum]!!
    if (targetSum == 0) return true
    if (targetSum < 0) return false

    for (number in numbers) {
        val remainder = targetSum - number
        if (canSum(remainder, numbers, cache)) {
            cache[targetSum] = true
            return true
        }
    }
    cache[targetSum] = false
    return false
}

// m = target sum, n = array length
// pre-memoization = time: O(n^m), space: O(m)
fun subOptimalCanSum(targetSum: Int, numbers: Array<Int>) : Boolean {
    if (targetSum == 0) return true
    if (targetSum < 0) return false

    for (number in numbers) {
        val remainder = targetSum - number
        if (subOptimalCanSum(remainder, numbers)) {
            return true
        }
    }
    return false
}






















