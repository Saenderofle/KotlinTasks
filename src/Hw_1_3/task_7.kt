package Hw_1_3

fun main() {
    val rawLogs = listOf(
        "2026-09-01 INFO: User logged in",
        "2026-09-01 ERROR: 500 Internal Server Error",
        "2026-09-01 WARN: High memory usage",
        "2026-09-01 ERROR: 404 Not Found",
        "2026-09-01 INFO: Payment processed"
    )

    var infoCount = 0
    var warnCount = 0
    var errorCount = 0
    val errorLogs = mutableListOf<String>()

    for (log in rawLogs) {
        when {
            log.contains("INFO") -> infoCount++
            log.contains("WARN") -> warnCount++
            log.contains("ERROR") -> {
                errorCount++
                errorLogs.add(log)
            }
        }
    }

    val errorDetails = if (errorLogs.isEmpty()) {
        "Помилок не зафіксовано."
    } else {
        errorLogs.joinToString(separator = "\n") { "  - $it" }
    }

    val report = """
        ========================================
        ЗВІТ АНАЛІЗУ ЛОГІВ СЕРВЕРА
        ========================================
        Всього оброблено записів: ${rawLogs.size}
        • INFO:  $infoCount
        • WARN:  $warnCount
        • ERROR: $errorCount
        ----------------------------------------
        Деталі помилок (ERROR):
        $errorDetails
        ========================================
    """.trimIndent()

    println(report)
}