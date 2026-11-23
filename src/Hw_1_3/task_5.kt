package Hw_1_3
fun stringFilter(strings: Iterable<String>, predicate: (String) -> Boolean): List<String> {
    val result = mutableListOf<String>()
    for (item in strings) {
        if (predicate(item)) {
            result.add(item)
        }
    }
    return result
}

fun stringFilter(strings: Array<String>, predicate: (String) -> Boolean): List<String> =
    stringFilter(strings.asIterable(), predicate)

fun main() {
    val items = listOf("apple", "banana", "apricot", "cherry", "avocado")
    val startsWithA = stringFilter(items) { it.startsWith("a") }

    println(startsWithA)
}