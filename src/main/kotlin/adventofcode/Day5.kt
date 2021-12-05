package adventofcode

import adventofcode.Utils.printResult
import kotlin.time.ExperimentalTime

typealias Ground = List<MutableList<Int>>
typealias Coords = Pair<Int, Int>
typealias Lines = List<List<Coords>>

object Day5 {

    fun part1(input: List<String>, mapSize: Int = 1000): Int {
        val (ground, lines) = createGroundAndLines(input, mapSize)

        lines.forEach { line ->
            val from = line.first()
            val to = line.last()
            when {
                from.first != to.first && from.second == to.second -> {
                    addHorizontals(from, to, ground)
                }
                from.first == to.first && from.second != to.second -> {
                    addVerticals(from, to, ground)
                }
            }
        }

//        paintGround(ground)

        return countMultipleLines(ground)
    }

    fun part2(input: List<String>, mapSize: Int = 1000): Int {
        val (ground, lines) = createGroundAndLines(input, mapSize)

        lines.forEach { line ->
            val from = line.first()
            val to = line.last()
            when {
                from.first != to.first && from.second == to.second -> {
                    addHorizontals(from, to, ground)
                }
                from.first == to.first && from.second != to.second -> {
                    addVerticals(from, to, ground)
                }
                else -> {
                    addDiagonals(from, to, ground)
                }
            }
        }

//        paintGround(ground)

        return countMultipleLines(ground)
    }

    private fun countMultipleLines(ground: Ground) = ground.flatten().count { it >= 2 }

    private fun addHorizontals(from: Coords, to: Coords, ground: Ground) {
        val sorted = listOf(from.first, to.first).sorted()
        (sorted.first()..sorted.last()).forEach {
            ground[from.second][it] += 1
        }
    }

    private fun addVerticals(from: Coords, to: Coords, ground: Ground) {
        val sorted = listOf(from.second, to.second).sorted()
        (sorted.first()..sorted.last()).forEach {
            ground[it][from.first] += 1
        }
    }

    private fun addDiagonals(from: Coords, to: Coords, ground: Ground) {
        val lineRange = (if (from.first < to.first) (from.first..to.first)
        else (from.first downTo to.first)).toList()

        val colRange = (if (from.second < to.second) (from.second..to.second)
        else (from.second downTo to.second)).toList()

        (lineRange.indices).forEach { index ->
            ground[colRange[index]][lineRange[index]] += 1
        }
    }

    private fun createGroundAndLines(input: List<String>, mapSize: Int): Pair<Ground, Lines> {
        val ground = (0..mapSize).map {
            (0..mapSize).map { 0 }.toMutableList()
        }
        val lines = input.map { line ->
            line.split(" -> ")
                .map { it.split(",") }
                .map { Coords(it.first().toInt(), it.last().toInt()) }
        }
        return Pair(ground, lines)
    }

    private fun paintGround(ground: List<List<Int>>) {
        ground.forEach { println(it.joinToString("")) }
        println()
    }

    @JvmStatic
    @OptIn(ExperimentalTime::class)
    fun main(args: Array<String>) {
        val input = Utils.readLines("day5.txt")

        printResult("part 1") { part1(input) }
        printResult("part 2") { part2(input) }
    }
}