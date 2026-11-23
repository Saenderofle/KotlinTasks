package Hw_1_6

fun processRawScores(rawInputs: List<String?>): List<Int> {
    return rawInputs
        .filterNotNull()
        .mapNotNull { it.trim().toIntOrNull() }
        .filter { it in 0..100 }
}

fun main() {
    val inputs = listOf("85", null, "  92 ", "invalid", "-5", "100", "150", null, "74")
    val validScores = processRawScores(inputs)

    println("Валідні оцінки: $validScores")
    println("Середній бал: ${validScores.average()}")
}