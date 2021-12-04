package adventofcode

import java.io.File
import java.lang.ClassLoader.getSystemResource
import kotlin.time.ExperimentalTime
import kotlin.time.measureTimedValue

object Utils {

    fun readText(fileName: String): String {
        return File(getSystemResource(fileName).file).readText()
    }

    fun readLines(fileName: String): List<String> {
        return File(getSystemResource(fileName).file)
            .readLines()
            .map(String::trim)
    }

    fun readLinesAsInts(fileName: String): List<Int> {
        return readLines(fileName).map { it.toInt() }
    }

    @ExperimentalTime
    fun <T> printResult(message: String, block: () -> T) {
        val (result, duration) = measureTimedValue {
            block()
        }
        println("$message: $result ($duration)")
    }
}