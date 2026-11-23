package Hw_1_4

class PlainEmployee(
    val firstName: String,
    val lastName: String,
    val position: String
)

data class DataEmployee(
    val firstName: String,
    val lastName: String,
    val position: String
) {
    var bonus: Int = 0
}

class ManualDataEmployee(
    val firstName: String,
    val lastName: String,
    val position: String
) {
    override fun toString(): String {
        return "Employee(firstName=$firstName, lastName=$lastName, position=$position)"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is ManualDataEmployee) return false

        return firstName == other.firstName &&
                lastName == other.lastName &&
                position == other.position
    }

    override fun hashCode(): Int {
        var result = firstName.hashCode()
        result = 31 * result + lastName.hashCode()
        result = 31 * result + position.hashCode()
        return result
    }

    operator fun component1(): String = firstName
    operator fun component2(): String = lastName
    operator fun component3(): String = position

    fun copy(
        firstName: String = this.firstName,
        lastName: String = this.lastName,
        position: String = this.position
    ): ManualDataEmployee {
        return ManualDataEmployee(firstName, lastName, position)
    }
}

fun main() {
    val p1 = PlainEmployee("Олена", "Ковальчук", "Developer")
    val p2 = PlainEmployee("Олена", "Ковальчук", "Developer")
    val p3 = p1
    println("Plain toString: $p1")
    println("p1 === p2: ${p1 === p2}, p1 == p2: ${p1 == p2}, p1 === p3: ${p1 === p3}")

    val d1 = DataEmployee("Олена", "Ковальчук", "Developer").apply { bonus = 500 }
    val d2 = DataEmployee("Олена", "Ковальчук", "Developer").apply { bonus = 1000 }
    println("\nData toString: $d1")
    println("d1 == d2 (при різному bonus): ${d1 == d2}") // true

    val emp1 = ManualDataEmployee("Олена", "Ковальчук", "Developer")
    val emp2 = ManualDataEmployee("Олена", "Ковальчук", "Developer")
    println("\nManual toString: $emp1")
    println("emp1 == emp2: ${emp1 == emp2}")

    val (name, surname, pos) = emp1
    println("Розпаковано: Ім'я = $name, Прізвище = $surname, Посада = $pos")

    val promotedEmp = emp1.copy(position = "Senior Developer")
    println("Після підвищення: $promotedEmp")
}