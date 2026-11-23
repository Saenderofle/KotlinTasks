package Hw_1_4

import kotlin.math.sqrt
import kotlin.random.Random

sealed interface Roots {
    data class TwoRoots(val x1: Double, val x2: Double) : Roots
    data class OneRoot(val x: Double) : Roots
    data object NoRealRoots : Roots
}

class QuadraticEquation(a: Double, var b: Double, var c: Double) {

    // Властивість 'a' з кастомним сетером та backing field
    var a: Double = a
        set(value) {
            require(value != 0.0) { "Коефіцієнт 'a' не може бути нулем!" }
            field = value
        }

    init {
        require(a != 0.0) { "Коефіцієнт 'a' не може бути нулем!" }
    }
    constructor(a: Int, b: Int, c: Int) : this(a.toDouble(), b.toDouble(), c.toDouble())

    constructor(b: Double, c: Double) : this(1.0, b, c)


    val discriminant: Double
        get() = b * b - 4 * a * c

    fun solve(): List<Double> {
        val d = discriminant
        return when {
            d > 0 -> {
                val sqrtD = sqrt(d)
                listOf((-b - sqrtD) / (2 * a), (-b + sqrtD) / (2 * a))
            }
            d == 0.0 -> listOf(-b / (2 * a))
            else -> emptyList()
        }
    }

    fun solveSealed(): Roots {
        val d = discriminant
        return when {
            d > 0 -> {
                val sqrtD = sqrt(d)
                Roots.TwoRoots((-b - sqrtD) / (2 * a), (-b + sqrtD) / (2 * a))
            }
            d == 0.0 -> Roots.OneRoot(-b / (2 * a))
            else -> Roots.NoRealRoots
        }
    }

    override fun toString(): String {
        val aStr = if (a == 1.0) "x^2" else "${a}x^2"
        val bStr = if (b >= 0) "+ ${b}x" else "- ${-b}x"
        val cStr = if (c >= 0) "+ $c" else "- ${-c}"
        return "$aStr $bStr $cStr = 0"
    }
}

fun main() {
    val eq = QuadraticEquation(1, -3, 2)
    println("Рівняння: $eq | D = ${eq.discriminant} | Корені: ${eq.solve()}")

    eq.b = 2.0
    eq.c = 1.0
    println("Після зміни b та c: $eq | Новий D = ${eq.discriminant} | Корені: ${eq.solve()}")

    when (val roots = eq.solveSealed()) {
        is Roots.TwoRoots -> println("Два корені: x1 = ${roots.x1}, x2 = ${roots.x2}")
        is Roots.OneRoot -> println("Один корінь: x = ${roots.x}")
        Roots.NoRealRoots -> println("Дійсних коренів немає")
    }
    println("\n--- Генерація 100 випадкових рівнянь ---")
    val equations = List(100) {
        var randomA: Int
        do {
            randomA = Random.nextInt(-50, 51)
        } while (randomA == 0)

        val randomB = Random.nextInt(-50, 51)
        val randomC = Random.nextInt(-50, 51)
        QuadraticEquation(randomA, randomB, randomC)
    }

    val withTwoRoots = equations.filter { it.discriminant > 0 }
    withTwoRoots.forEach { equation ->
        println("$equation  -->  Корені: ${equation.solve()}")
    }
    println("Загальна кількість рівнянь із 2 коренями: ${withTwoRoots.size}")
}