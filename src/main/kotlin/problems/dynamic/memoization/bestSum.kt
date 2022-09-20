package dynamic.solutions.memoization

/**                          bestSum
 *
 * Write a function `bestSum(targetSum, numbers)` that takes in a
 * targetSum and an array of numbers as arguments.
 *
 * The function should return an array containing the ** shortest **
 * combination of numbers that add up to exactly the targetSum
 *
 * if there is a tie for the shortest combination, you may return
 * any of the shortest.
 *
 * */

fun main() {
    println(bestSum(7, arrayOf(5,3,4,7), hashMapOf()).contentToString())    // [7]
    println(bestSum(8, arrayOf(2,3,5), hashMapOf()).contentToString())      // [3,5]
    println(bestSum(8, arrayOf(1,4,5), hashMapOf()).contentToString())      // [4,4]
    println(bestSum(100, arrayOf(1,2,5,25), hashMapOf()).contentToString())    // [25,25,25,25]
}


// m = target sum, n = array length
// memoization = time: O(m^2 * n), space: O(m^2) // no longer exponential, polynomial
fun bestSum(targetSum: Int, numbers: Array<Int>, cacheMemo: HashMap<Int, Array<Int?>?>) : Array<Int?>? {
    if (targetSum in cacheMemo) return cacheMemo[targetSum]
    if (targetSum == 0) return emptyArray()
    if (targetSum < 0) return null

    var shortestCombination : Array<Int?>? = null

    for (number in numbers) {
        val remainder = targetSum - number
        val remainResult = bestSum(remainder, numbers, cacheMemo)
        remainResult ?.let {
            val combination = remainResult.plus( number)
            if (shortestCombination == null || combination.size < shortestCombination!!.size) {
                shortestCombination = combination
            }
        }
    }
    cacheMemo[targetSum] = shortestCombination
    return shortestCombination
}


// m = target sum, n = array length
// pre-memoization = time: O(n^m * m), space: O(m^2)
fun bruteBestSum(targetSum: Int, numbers: Array<Int>) : Array<Int?>? {
    if (targetSum == 0) return emptyArray()
    if (targetSum < 0) return null

    var shortestCombination : Array<Int?>? = null

    for (number in numbers) {
        val remainder = targetSum - number
        val remainResult = bruteBestSum(remainder, numbers)
        remainResult ?.let {
            val combination = remainResult.plus( number)
            if (shortestCombination == null || combination.size < shortestCombination!!.size) {
                shortestCombination = combination
            }
        }
    }

    return shortestCombination
}


