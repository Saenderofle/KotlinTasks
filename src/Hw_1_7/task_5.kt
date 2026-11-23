package Hw_1_7

open class Employee(
    val name: String,
    val baseSalary: Double
) {
    open fun calculateSalary(): Double = baseSalary

    open fun getInfo(): String = "Працівник: $name | Зарплата: ${"%.2f".format(calculateSalary())} грн"
}

class Developer(
    name: String,
    baseSalary: Double,
    val completedProjects: Int,
    val bonusPerProject: Double
) : Employee(name, baseSalary) {
    override fun calculateSalary(): Double = baseSalary + completedProjects * bonusPerProject

    override fun getInfo(): String =
        "Розробник: $name | Проєктів: $completedProjects | Зарплата: ${"%.2f".format(calculateSalary())} грн"
}

class Manager(
    name: String,
    baseSalary: Double,
    val teamSize: Int,
    val teamBonus: Double
) : Employee(name, baseSalary) {
    override fun calculateSalary(): Double = baseSalary + teamSize * teamBonus

    override fun getInfo(): String =
        "Менеджер: $name | Команда: $teamSize осіб | Зарплата: ${"%.2f".format(calculateSalary())} грн"
}

fun main() {
    val staff: List<Employee> = listOf(
        Employee("Олександр Мельник", 20000.0),
        Developer("Ірина Коваль", 35000.0, completedProjects = 4, bonusPerProject = 2500.0),
        Manager("Дмитро Савченко", 40000.0, teamSize = 6, teamBonus = 1500.0)
    )

    staff.forEach { println(it.getInfo()) }
    println("Загальний фонд оплати праці: ${"%.2f".format(staff.sumOf { it.calculateSalary() })} грн")
}