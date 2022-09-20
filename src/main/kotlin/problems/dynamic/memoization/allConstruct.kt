package dynamic.solutions.memoization

/**                 `       allConstruct
 *
 * Write a function `allConstruct(target, wordBank)` that accepts a
 * target string and an array of strings as arguments.
 *
 * The function should return a 2D array containing all the ways that
 * the `target` can be constructed by concatenating elements of the
 * `wordBank` array. Each element of the 2D array should represent
 * on combination that constructs the `target`.
 *
 * You may reuse elements of the wordBank as many times as needed.
 * */

fun main() {
    println(allConstruct("purple", arrayOf("purp","p","ur","le","purpl"), hashMapOf()).contentDeepToString())
    // [
    //      [ "purp", "le" ],
    //      [ "p", "ur", "p", "le" ]
    // ]
    val abcdef = allConstruct("abcdef", arrayOf("ab","abc","cd","abcd","ef","c"), hashMapOf())
    // [
    //      [ "ab", "cd", "ef" ],
    //      [ "ab", "c", "def" ],
    //      [ "abc", "def" ],
    //      [ "abcd", "ef" ],
    // ]
    val skateboard = allConstruct("skateboard", arrayOf("bo","rd","ate","t","sk","boar"), hashMapOf())
    // [[]]
    // println(allConstruct("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaz",
    //                                    arrayOf("a","aa","aaa","aaaa","aaaaa","aaaaaaa")).contentToString())
    // [[]]


}

fun allConstruct(target: String, wordBank: Array<String>, bank: HashMap<String, Array<Array<String>>>) : Array<Array<String>> {
    if (target in bank) return bank[target]!!
    if (target == "") return emptyArray()

    var result: Array<Array<String>> = emptyArray()

    for (word in wordBank) {
        if (target.indexOf(word) == 0) {
            val suffix = target.substring(word.length)
            val suffixWays = allConstruct(suffix, wordBank, bank)
            suffixWays.forEach { it.plus(word) }
            result = arrayOf(*suffixWays)

        }
    }
    bank[target] = result
    return result
}