package Hw_1_7

import kotlin.math.PI

abstract class Shape(val name: String) {
    abstract fun area(): Double
    abstract fun perimeter(): Double

    fun printSummary() {
        println("$name -> Площа: ${"%.2f".format(area())}, Периметр: ${"%.2f".format(perimeter())}")
    }
}

class Circle(val radius: Double) : Shape("Коло (r=$radius)") {
    init {
        require(radius > 0)
    }

    override fun area(): Double = PI * radius * radius
    override fun perimeter(): Double = 2 * PI * radius
}

class Rectangle(val width: Double, val height: Double) : Shape("Прямокутник (${width}x${height})") {
    init {
        require(width > 0 && height > 0)
    }

    override fun area(): Double = width * height
    override fun perimeter(): Double = 2 * (width + height)
}

fun main() {
    val shapes: List<Shape> = listOf(
        Circle(5.0),
        Rectangle(4.0, 6.0),
        Circle(2.5)
    )

    shapes.forEach { it.printSummary() }
    println("Сумарна площа: ${"%.2f".format(shapes.sumOf { it.area() })}")
}