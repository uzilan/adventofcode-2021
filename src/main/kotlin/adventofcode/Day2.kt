package adventofcode

import adventofcode.Utils.printResult
import kotlin.time.ExperimentalTime

object Day2 {

    data class Position(val horizontal: Int = 0, val depth: Int = 0, val aim: Int = 0) {
        fun incHorizontal(by: Int) = Position(horizontal + by, depth, aim)
        fun incDepth(by: Int) = Position(horizontal, depth + by, aim)
        fun decDepth(by: Int) = incDepth(-by)
        fun incAim(by: Int) = Position(horizontal, depth, aim + by)
        fun decAim(by: Int) = incAim(-by)
    }

    fun part1(input: List<String>): Int {
        val lines = input.map { it.split(" ") }
        val (horizontal, depth) = lines.fold(Position()) { acc, curr ->
            val (direction, distance) = Pair(curr.first(), curr.last().toInt())
            when (direction) {
                "forward" -> acc.incHorizontal(distance)
                "down" -> acc.incDepth(distance)
                else -> acc.decDepth(distance)
            }
        }
        return horizontal * depth
    }

    fun part2(input: List<String>): Int {
        val lines = input.map { it.split(" ") }
        val (horizontal, depth) = lines.fold(Position()) { acc, curr ->
            val (direction, distance) = Pair(curr.first(), curr.last().toInt())
            when (direction) {
                "down" -> acc.incAim(distance)
                "up" -> acc.decAim(distance)
                else -> {
                    val tempAcc = acc.incHorizontal(distance)
                    tempAcc.incDepth(tempAcc.aim * distance)
                }
            }
        }
        return horizontal * depth
    }

    @JvmStatic
    @OptIn(ExperimentalTime::class)
    fun main(args: Array<String>) {
        val input = Utils.readLines("day2.txt")

        printResult("part 1") { part1(input) }
        printResult("part 2") { part2(input) }
    }
}