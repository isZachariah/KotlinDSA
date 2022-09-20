package dynamic.solutions.memoization

/**     howSum
 * Write a function `howSum(targetSum: Int, numbers: Array<Int>) : Int`
 * that takes in a targetSum and an array of numbers as arguments.
 *
 * The function should return an array containing any combination of
 * elements that add up to exactly the targetSum. If there is no
 * combination that adds up to the targetSum, then return null.
 *
 * However,  if there are multiple combinations possible,
 * return any single one.
 * */

fun main() {
    println(howSum(7, arrayOf(2,3), hashMapOf()).contentToString())        // [3,2,2]
    println(howSum(7, arrayOf(5,3,4,7), hashMapOf()).contentToString())    // [4,3]
    println(howSum(7, arrayOf(2,4), hashMapOf()).contentToString())        // null
    println(howSum(8, arrayOf(2,3,5), hashMapOf()).contentToString())      // [2,2,2,2]
    println(howSum(300, arrayOf(7,14), hashMapOf()).contentToString())     // null
}

// m = target sum, n = array length
// memoization = time: O(n*m^2), space: O(m^2) // no longer exponential, polynomial
fun howSum(targetSum: Int, numbers: Array<Int>, cached: HashMap<Int, Array<Int?>?>) : Array<Int?>? {
    if (targetSum in cached) return cached[targetSum]
    if (targetSum == 0) return emptyArray()
    if (targetSum < 0) return null

    for (number in numbers) {
        val remainder = targetSum - number
        val result = howSum(remainder, numbers, cached)
        result ?.let {
            cached[targetSum] = result.plus(number)
            return cached[targetSum]
        }
    }
    cached[targetSum] = null
    return null
}


// m = target sum, n = array length
// pre-memoization = time: O(n^m * m), space: O(m)
fun bruteForceHowSum(targetSum: Int, numbers: Array<Int>) : Array<Int?>? {
    if (targetSum == 0) return emptyArray()
    if (targetSum < 0) return null

    for (number in numbers) {
        val remainder = targetSum - number
        val result = bruteForceHowSum(remainder, numbers)
        if (result != null) {
            return result.plus(number)
        }
    }
    return null
}




