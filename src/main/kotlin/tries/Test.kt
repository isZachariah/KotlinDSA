package tries

fun main() {
    val trie = Trie<Char>().apply {
        insert("car")
        insert("card")
        insert("care")
        insert("cared")
        insert("cars")
        insert("carbs")
        insert("carapace")
        insert("cargo")
    }
    println("\nCollections starting with \"car\"")
    val prefixedWithCar = trie.collections("car")
    println(prefixedWithCar)
    println("\nCollections starting with \"care\"")
    val prefixedWithCare = trie.collections("care")
    println(prefixedWithCare)
    println()
    println(trie)

}