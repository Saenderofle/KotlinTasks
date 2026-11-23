package Hw_1_3

import kotlin.random.Random

fun main() {
    val numbers = Array(100) { Random.nextInt(-100, 101) }
    val processed = numbers
        .filter { it > 0 }            // лише додатні
        .filter { it % 5 == 0 }       // діляться на 5 без остачі
        .map { it * it }              // піднесення до квадрату
        .sortedDescending()           // сортування за спаданням

    if (processed.isNotEmpty()) {
        println("Найбільше число: ${processed.max()}")
        println("Найменше число: ${processed.min()}")
    } else {
        println("Колекція після фільтрації порожня.")
    }
    
    val stringCollection: List<String> = processed.map { it.toString() }
    val joinedString: String = stringCollection.joinToString(separator = " ")

    println("Результат: $joinedString")
}