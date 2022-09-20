package dynamic.solutions.memoization

/**Say that you are a traveler on a 2D grid. You begin in the
 * top-left corner and your goal is to travel to the bottom-right
 * corner. You may only move down  or right.
 *
 * In how many ways can you travel to the  goal  on a grid  with
 * dimensions m * n?
 *
 * Write a function `gridTraveler(m, n)` that calculates this. */

fun main() {
    println(gridTraveler(1,1)) // 1
    println(gridTraveler(2,3)) // 3
    println(gridTraveler(3,2)) // 3
    println(gridTraveler(3,3)) // 6
    println(gridTraveler(18,18)) // 2333606220, (Int) -1961261076
}

// notice that gridTraveler(a,b) = gridTraveler(b/a)

// memoization = time: O(m*n), space: O(n+m)
// create hashmap of function parameters and returns

val map = hashMapOf<Pair<Int, Int>, Int>() // alternatively: val map = hashMapOf<String, Int>()

fun gridTraveler(m: Int, n: Int) : Int {
    val key: Pair<Int, Int> = Pair(m, n) //alternatively: val key: String = "$m,$n"
    if (key in map) { return map[key]!! }
    if (m == 1 && n == 1) return 1
    if (m == 0 || n == 0) return 0
    map[key] = gridTraveler(m-1, n) + gridTraveler(m, n-1)
    return map[key]!!
}

//----------------------------------------------------------------------------------------
// pre-memoization = time: O(2^n+m), space: O(n+m)
fun gridTrav(m: Int, n:  Int) : Int {
    if (m == 1 && n == 1) return 1
    if (m == 0 || n == 0) return 0
    return gridTrav(m-1, n) + gridTrav(m, n-1)
}



/**             Memoization Recipe
 *
 *    1. Make it work.
 *      - visualize the problem as a tree
 *      - implement the tree using recursion
 *      - test it
 *    2. Make it efficient.
 *      - add a memo object
 *      - add a base case to return memo values
 *      - store return values into the memo
 *
 **/