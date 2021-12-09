package adventofcode

import kotlin.time.ExperimentalTime

object Day8 {

    //  dddd
    // e    a
    // e    a
    //  ffff
    // g    b
    // g    b
    //  cccc

    private val digitMap = mapOf(
        "acedgfb" to 8,
        "cdfbe" to 5,
        "gcdfa" to 2,
        "fbcad" to 3,
        "dab" to 7,
        "cefabd" to 9,
        "cdfgeb" to 6,
        "eafb" to 4,
        "cagedb" to 0,
        "ab" to 1,
    ).entries.associate { Pair(it.key.sort(), it.value) }

    private val uniques = listOf(2, 4, 3, 7)

    fun part1(input: List<String>): Int {
        val lines = input.map { it.split("| ")[1] }
        return lines.flatMap { line ->
            line.split(" ")
                .map { it.length }
                .filter { uniques.contains(it) }
        }.size
    }

    fun part2(input: List<String>): Int {
        val lines = input.map { it.split("| ")[1] }

        val ggg = lines.map { line ->
            line.split(" ")
                .map { segment -> findNumber(segment) }
        }


        return 0
    }

    private fun findNumber(segment: String): Int {
        val other = segment.sort()
        return digitMap.entries.find { entry ->
            entry.key == other
        }!!.value
    }

    private fun String.sort() = this.toList().sorted().joinToString("")

    @JvmStatic
    @OptIn(ExperimentalTime::class)
    fun main(args: Array<String>) {
        val input = Utils.readLines("day8.txt")

        Utils.printResult("part 1") { part1(input) }
//        Utils.printResult("part 2") { part2(input) }
    }
}