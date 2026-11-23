package Hw_1_6

interface Event
data class ClickEvent(val x: Int, val y: Int) : Event
data class KeyEvent(val keyCode: Int?) : Event

fun handleEvent(event: Any?) {
    val validEvent = requireNotNull(event as? Event) { "Переданий об'єкт не є подією Event" }

    when (validEvent) {
        is ClickEvent -> println("Клік у координатах (${validEvent.x}, ${validEvent.y})")
        is KeyEvent -> {
            val code = validEvent.keyCode ?: -1
            println("Натиснуто клавішу з кодом: $code")
        }
    }
}

fun main() {
    handleEvent(ClickEvent(120, 340))
    handleEvent(KeyEvent(null))
    handleEvent(KeyEvent(13))
}