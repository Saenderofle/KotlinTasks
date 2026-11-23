package Hw_1_6

data class ActiveUser(val username: String, val isActive: Boolean)

fun getActiveUsernames(users: List<ActiveUser>): List<String> =
    users.mapNotNull { user -> user.username.takeIf { user.isActive } }

fun main() {
    val allUsers = listOf(
        ActiveUser("alice123", true),
        ActiveUser("bob_the_builder", false),
        ActiveUser("charlie99", true)
    )

    println(getActiveUsernames(allUsers))
}