package Hw_1_6

data class Address(val street: String?, val city: String?, val zipCode: String?)
data class Company(val name: String, val address: Address?)
data class Worker(val name: String, val company: Company?)

fun printShippingLabel(worker: Worker?) {
    val city = worker?.company?.address?.city ?: "Місто не вказано"
    val street = worker?.company?.address?.street ?: "Вулицю не вказано"
    val zip = worker?.company?.address?.zipCode ?: "00000"

    worker?.let {
        println("Отримувач: ${it.name}")
        println("Компанія: ${it.company?.name ?: "Фріланс"}")
        println("Адреса: $zip, м. $city, $street")
    } ?: println("Дані про працівника відсутні")
}

fun main() {
    val fullWorker = Worker("Іван Петренко", Company("TechCorp", Address("Хрещатик, 1", "Київ", "01001")))
    val partialWorker = Worker("Марія Коваль", Company("StartUp", null))

    printShippingLabel(fullWorker)
    println("---")
    printShippingLabel(partialWorker)
    println("---")
    printShippingLabel(null)
}