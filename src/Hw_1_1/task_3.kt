package Hw_1_1
import java.util.Scanner


fun main() {
    val a: Int = 1000
    val b: String = "log message"
    val c: Double = 3.14
    val d: Long = 100_000_000_000_000
    val e: Boolean = false
    val f: Char = '\n'

    val scan = Scanner(System.`in`)
    val n = scan.nextLine().trim().toInt()
    var fact = 1
    for (i in 2..n) {
        fact *= i
    }
    println(fact)
}