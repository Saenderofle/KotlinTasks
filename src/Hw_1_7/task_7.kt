package Hw_1_7

interface Printable {
    fun printDocument()
}

interface Scannable {
    fun scanDocument(): String
}

class BasicPrinter : Printable {
    override fun printDocument() {
        println("Друк документа на стандартному принтері...")
    }
}

class BasicScanner : Scannable {
    override fun scanDocument(): String = "Відсканований текст документа [PDF]"
}

class AllInOneMFP(
    private val printer: Printable,
    private val scanner: Scannable
) : Printable by printer, Scannable by scanner {
    fun copyDocument() {
        val content = scanDocument()
        println("Копіювання: $content")
        printDocument()
    }
}

fun main() {
    val mfp = AllInOneMFP(BasicPrinter(), BasicScanner())
    mfp.printDocument()
    println(mfp.scanDocument())
    mfp.copyDocument()
}