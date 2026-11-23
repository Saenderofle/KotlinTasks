package Hw_1_6

fun validateStock(requested: Int?, available: Int?): Int {
    val validRequested = requireNotNull(requested) { "Requested quantity must not be null" }
    val validAvailable = requireNotNull(available) { "Available quantity must not be null" }

    require(validRequested >= 0) { "Requested quantity cannot be negative" }
    require(validAvailable >= 0) { "Available quantity cannot be negative" }
    check(validRequested <= validAvailable) { "Not enough stock available" }

    return validRequested
}

fun main() {
    println(validateStock(5, 10))
    println(validateStock(null, 10))
    println(validateStock(-2, 10))
    println(validateStock(15, 10))
}