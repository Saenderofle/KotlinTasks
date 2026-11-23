package Hw_1_7

interface Refundable {
    fun refund(amount: Double)
}

abstract class PaymentMethod(val name: String) {
    fun authorize(amount: Double) {
        println("Authorizing payment of $$amount via $name.")
    }

    abstract fun processPayment(amount: Double)
}

class CreditCard(name: String, val cardNumber: String) : PaymentMethod(name), Refundable {
    override fun processPayment(amount: Double) {
        println("Processing credit card payment of $$amount using card ending in ${cardNumber.takeLast(4)}.")
    }

    override fun refund(amount: Double) {
        println("Refunding $$amount to credit card ending in ${cardNumber.takeLast(4)}.")
    }
}

fun main() {
    val visa = CreditCard("Visa", "1234567812345678")
    visa.authorize(100.0)
    visa.processPayment(100.0)
    visa.refund(50.0)
}