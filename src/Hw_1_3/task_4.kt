package Hw_1_3

fun countMatching(strings: Iterable<String>, predicate: (String) -> Boolean): Int {
    var count = 0
    for (item in strings) {
        if (predicate(item)) {
            count++
        }
    }
    return count
}
fun countMatching(strings: Array<String>, predicate: (String) -> Boolean): Int =
    countMatching(strings.asIterable(), predicate)

fun main() {
    val wordsList = listOf("Kotlin", "Java17", "Android", "Version2026", "Code")
    val wordsArray = arrayOf("test1", "hello", "99problems")

    val hasDigit: (String) -> Boolean = { str -> str.any { it.isDigit() } }

    println("У списку слів з цифрами: ${countMatching(wordsList, hasDigit)}") // 2
    println("У масиві слів з цифрами: ${countMatching(wordsArray, hasDigit)}") // 2
}