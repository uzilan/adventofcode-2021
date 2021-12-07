package adventofcode

import adventofcode.Utils.printResult
import kotlin.math.abs
import kotlin.time.ExperimentalTime

object Day7 {

    fun part1(input: String): Int {
        val split = input.split(",").map { it.toInt() }

        return (1..split.maxOrNull()!!)
            .minOf { candidate -> split.sumOf { abs(it - candidate) } }
    }

    fun part2(input: String): Int {
        val split = input.split(",").map { it.toInt() }

        return (1..split.maxOrNull()!!)
            .minOf { candidate ->
                split.sumOf {
                    sum(abs(it - candidate))
                }
            }
    }

    private fun sum(num: Int) = num * (num + 1) / 2

    @JvmStatic
    @OptIn(ExperimentalTime::class)
    fun main(args: Array<String>) {
        val input = Utils.readText("day7.txt")

        printResult("part 1") { part1(input) }
        printResult("part 2") { part2(input) }
    }
}