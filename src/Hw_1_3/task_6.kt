package Hw_1_3

fun countCharacters(input: String): Map<Char, Int> {
    val frequencies = mutableMapOf<Char, Int>()
    for (char in input) {
        frequencies[char] = frequencies.getOrDefault(char, 0) + 1
    }
    return frequencies
}

fun main() {
    print("Введіть рядок: ")
    val text = readln()

    val charCounts = countCharacters(text)
    charCounts.forEach { (char, count) ->
        println("'$char' -> $count")
    }
}