package dynamic.solutions.memoization

/**                     countConstruct
 *
 * Write a function `countConstruct(target, wordBank)` that accepts
 * a target string and an array of strings as arguments.
 *
 * The function should return the number of ways that the `target`
 * can be constructed by concatenating elements of the `wordBank` array.
 *
 * You may reuse elements of `wordBank` as many times as needed.
 * */

fun main() {
    println(countConstruct("purple", arrayOf("purp","p","ur","le","purpl"), hashMapOf()))                    // 2
    println(countConstruct("abcdef", arrayOf("ab","abc","cd","def","abcd"), hashMapOf()))                    // 1
    println(countConstruct("skateboard", arrayOf("bo","rd","ate","t","ska","sk","boar"), hashMapOf()))       // 0
    println(countConstruct("enterapotentpot", arrayOf("a","p","ent","enter","ot","o","t"), hashMapOf()))     // 4
    println(countConstruct("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeef", arrayOf(
                                                    "e","ee","eee","eeee","eeeeee","eeeeeeeeeeee"), hashMapOf()))   // 0
}


fun countConstruct(target: String, wordBank: Array<String>, bank: HashMap<String, Int>) : Int {
    if (target in bank) return bank[target]!!
    if (target == "") return 1

    var totalCount = 0

    for (word in wordBank) {
        if (target.indexOf(word) == 0) {
            val numWays = countConstruct(target.substring(word.length), wordBank, bank)
            totalCount += numWays
        }
    }
    bank[target] = totalCount
    return totalCount
}




fun bruteCountConstruct(target: String, wordBank: Array<String>): Int {
    if (target == "") return 1

    var totalCount = 0

    for (word in wordBank) {
        if (target.indexOf(word) == 0) {
            val numWays = bruteCountConstruct(target.substring(word.length), wordBank)
            totalCount += numWays
        }
    }

    return totalCount
}