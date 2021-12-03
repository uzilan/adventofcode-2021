package adventofcode

import java.lang.Integer.parseInt
import kotlin.time.ExperimentalTime

object Day3 {

    fun part1(input: List<String>): Int {
        val grouped = (0 until input[0].length)
            .map { index -> input.map { it[index] } }
            .map { col -> col.groupingBy { it }.eachCount().toList().sortedByDescending { it.second } }

        val gammaRate = grouped.map { it.first().first }.joinToString("").let { parseInt(it, 2); }
        val epsilonRate = grouped.map { it.last().first }.joinToString("").let { parseInt(it, 2); }

        return gammaRate * epsilonRate
    }

    fun part2(input: List<String>): Int {
        val oxygenGeneratorRating = part2Helper(input, true)
        val co2ScrubberRating = part2Helper(input, false)

        return oxygenGeneratorRating * co2ScrubberRating
    }

    private tailrec fun part2Helper(input: List<String>, max: Boolean, index: Int = 0): Int {
        if (input.size == 1) return parseInt(input.first(), 2)

        val grouped = input.map { it[index] }.groupingBy { it }.eachCount().toList()

        val mostSig = if (max) {
            if (grouped.first().second == grouped.last().second) '1'
            else grouped.maxByOrNull { it.second }!!.first
        } else {
            if (grouped.first().second == grouped.last().second) '0'
            else grouped.minByOrNull { it.second }!!.first
        }

        val filtered = input.filter { it[index] == mostSig }

        return part2Helper(filtered, max, (index + 1))
    }

    @JvmStatic
    @OptIn(ExperimentalTime::class)
    fun main(args: Array<String>) {
        val input = Utils.readLines("day3.txt")

        Utils.printResult("part 1") { part1(input) }
        Utils.printResult("part 2") { part2(input) }
    }
}