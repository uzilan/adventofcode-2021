package adventofcode

import adventofcode.Utils.printResult
import java.io.File
import kotlin.time.ExperimentalTime

object Day1 {
    fun part1(input: List<Int>): Int {
        val (_, sum) = input.drop(1).fold(Pair(input.first(), 0)) { acc, curr ->
            if (curr > acc.first) Pair(curr, acc.second + 1)
            else Pair(curr, acc.second)
        }
        return sum
    }

    fun part2(input: List<Int>): Int {
        val windowed = input.windowed(3).map(List<Int>::sum)
        return part1(windowed)
    }

    @JvmStatic
    @OptIn(ExperimentalTime::class)
    fun main(args: Array<String>) {
        val input = File("src/main/resources/day1.txt").readLines()
            .map { it.toInt() }

        printResult("part 1") { part1(input) }
        printResult("part 2") { part2(input) }
    }
}