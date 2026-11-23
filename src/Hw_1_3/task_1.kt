package Hw_1_3

fun multiplyWithRepeat(a: Int, b: Int): Int {
    var result = 0
    repeat(b) {
        result += a
    }
    return result
}

fun multiplyWithForEach(a: Int, b: Int): Int {
    var result = 0
    (1..b).forEach {
        result += a
    }
    return result
}

fun main() {
    val a = 6
    val b = 4
    println("Через repeat: ${multiplyWithRepeat(a, b)}")   // 24
    println("Через forEach: ${multiplyWithForEach(a, b)}") // 24
}