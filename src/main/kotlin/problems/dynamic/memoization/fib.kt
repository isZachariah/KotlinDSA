package dynamic.solutions.memoization

import java.math.BigInteger


fun main() {
    println(fib1(1000))
}


fun fib1(n: Int) : BigInteger {
    return fib3(n, BigInteger.ZERO, BigInteger.ONE)
}

tailrec fun fib3(n: Int, a: BigInteger, b: BigInteger) : BigInteger {
    // println("fib($n, $a, $b)")
    if (n == 0) {
        countStackFrames()
        return a
    } else {
        return fib3(n - 1, b, a + b)
    }
}

fun countStackFrames() {
    val trace = Thread.currentThread().stackTrace
    println(trace.size)
    for (entry in trace.groupingBy { it }.eachCount()) {
        println(entry)
    }
}




class FibonacciChain {
    // memoization
    val chainCache = mutableMapOf(0 to BigInteger.ZERO, 1 to BigInteger.ONE)
    fun fibChain2(n: Int, chain: String): BigInteger {
        val chain = "$chain $n"
        println(chain)
        return chainCache.getOrPut(n) {
            val a = fibChain2(n - 2, chain)
            val b = fibChain2(n - 1, chain)
            println(chain)
            a + b
        }
    }

    // bruteforce
    fun fibChain(n: Int, chain: String): BigInteger {
        val chain = "$chain $n"
        println(chain)
        return when (n) {
            0 -> BigInteger.ZERO
            1 -> BigInteger.ONE
            else -> {
                val a = fibChain(n - 2, chain)
                val b = fibChain(n - 1, chain)
                println(chain)
                a + b
            }
        }
    }
}
class Fibonacci1 {

    // memoization
// hashmap: keys will be arg to fun, value will be the return value
    val memo: HashMap<Int, Int> = HashMap()

    // time: O(n), space: O(n)
    fun fibs(n: Int): Int {
        if (n in memo) {
            return memo[n]!!
        }
        if (n <= 2) {
            return 1
        }
        memo[n] = fibs(n - 1) + fibs(n - 2)
        return memo[n]!!
    }


    // time: O(n^2)
    fun fibonacci(n: Int): Int {
        return if (n <= 2) {
            1
        } else {
            fibonacci(n - 1) + fibonacci(n - 2)
        }
    }

    fun fib(n: Int): Int = if (n <= 2) {
        1
    } else {
        fib(n - 1) + fib(n - 2)
    }
}



