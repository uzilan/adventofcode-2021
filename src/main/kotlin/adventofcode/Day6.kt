package adventofcode

import adventofcode.Utils.printResult
import kotlin.time.ExperimentalTime

object Day6 {

    fun part1(input: String): Long {
        val fish = input.split(",").map { it.toLong() }
        return helper(fish, 80)
    }

    fun part2(input: String): Long {
        val fish = input.split(",").map { it.toLong() }
        return helper(fish, 256)
    }

    private fun helper(fish: List<Long>, days: Int): Long {
        var map = fish.groupingBy { it }.eachCount()
            .mapValues { it.value.toLong() }
            .toMutableMap()

        var newMap = mutableMapOf<Long, Long>()

        (0 until days).forEach { _ ->
            newMap = mutableMapOf()
            map.toSortedMap().entries.forEach { entry ->
                if (entry.key == 0L) {
                    newMap[6] = entry.value
                    newMap[8] = entry.value
                } else {
                    val current = newMap[entry.key - 1] ?: 0
                    newMap[entry.key - 1] = entry.value + current
                }
            }
            map = newMap
        }
        return newMap.values.sumOf { it }
    }

    @JvmStatic
    @OptIn(ExperimentalTime::class)
    fun main(args: Array<String>) {
        val input = Utils.readText("day6.txt")

        printResult("part 1") { part1(input) }
        printResult("part 2") { part2(input) }
    }
}