package adventofcode

import adventofcode.Utils.printResult
import adventofcode.Utils.readLinesAsInts
import kotlin.time.ExperimentalTime

object Day1 {
    fun part1(input: List<Int>): Int {
        return input.zipWithNext().count { (a, b) -> b > a }
    }

    fun part2(input: List<Int>): Int {
        val windowed = input.windowed(3).map { it.sum() }
        return part1(windowed)
    }

    @JvmStatic
    @OptIn(ExperimentalTime::class)
    fun main(args: Array<String>) {
        val input = readLinesAsInts("day1.txt")

        printResult("part 1") { part1(input) }
        printResult("part 2") { part2(input) }
    }
}