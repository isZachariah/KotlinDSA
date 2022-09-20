package dynamic.solutions.memoization

/**                         canConstruct
 *
 * Write a function `canConstruct(target, wordBank)` that accepts
 * a target string and an array of strings as arguments.
 *
 * The function should return a boolean indicating whether the
 * `target` can be constructed by concatenating elements of
 * the `wordBank` array.
 *
 * You may reuse elements of `wordBank` as many times as needed
 *
 * */

fun main() {
    println(canConstruct("abcdef", arrayOf("ab", "abc", "cd", "def", "abcd"), hashMapOf()))               // true
    println(canConstruct("skateboard", arrayOf("bo", "rd", "ate", "t", "ska", "boar"), hashMapOf()))      // false
    println(canConstruct("", arrayOf("cat", "dog", "mouse"), hashMapOf()))                                // true
    println(canConstruct("enterapotentpot", arrayOf("a","p","ent","enter","ot","o","t"), hashMapOf()))    // true
    println(canConstruct("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeef", arrayOf(
                                "e","ee","eee","eeee","eeeeee","eeeeeeeeeeee"), hashMapOf()))                    // false
}


// m = target length, n = wordBank length
// memoization = time: O(n * m^2), space: O(m^2)
fun canConstruct(target: String, wordBank: Array<String>, bank: HashMap<String, Boolean>) : Boolean {
    if (target in bank) return bank[target]!!
    if (target == "") return true

    for (word in wordBank) {
        if (target.indexOf(word) == 0) {
            val suffix = target.substring(word.length)
           if (canConstruct(suffix, wordBank, bank)) {
               bank[target] = true
               return true
           }
        }
    }
    bank[target] = false
    return false
}


// m = target length, n = wordBank length
// pre-memoization = time: O(n^m * m), space: O(m^2)
fun bruteCanConstruct(target: String, wordBank: Array<String>) : Boolean {
    if (target == "") return true

    for (word in wordBank) {
        if (target.indexOf(word) == 0) {
            val suffix = target.substring(word.length)
            if (bruteCanConstruct(suffix, wordBank)) {
                return true
            }
        }
    }
    return false
}