package adventofcode

import kotlin.time.ExperimentalTime

object Day5 {

    fun part1(input: List<String>, mapSize: Int = 1000): Int {
        val (ground, map) = createGroundAndMap(input, mapSize)

        map.forEach { line ->
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
        val (ground, map) = createGroundAndMap(input, mapSize)

        map.forEach { line ->
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

    private fun countMultipleLines(ground: List<MutableList<Int>>) =
        ground.flatten().count { it >= 2 }

    private fun addVerticals(
        from: Pair<Int, Int>,
        to: Pair<Int, Int>,
        ground: List<MutableList<Int>>) {
        val sorted = listOf(from.second, to.second).sorted()
        (sorted.first()..sorted.last()).forEach {
            ground[it][from.first] += 1
        }
    }

    private fun addHorizontals(
        from: Pair<Int, Int>,
        to: Pair<Int, Int>,
        ground: List<MutableList<Int>>) {
        val sorted = listOf(from.first, to.first).sorted()
        (sorted.first()..sorted.last()).forEach {
            ground[from.second][it] += 1
        }
    }

    private fun addDiagonals(
        from: Pair<Int, Int>,
        to: Pair<Int, Int>,
        ground: List<MutableList<Int>>) {
        val lineRange = (if (from.first < to.first) (from.first..to.first)
        else (from.first downTo to.first)).toList()

        val colRange = (if (from.second < to.second) (from.second..to.second)
        else (from.second downTo to.second)).toList()

        (lineRange.indices).forEach { index ->
            ground[colRange[index]][lineRange[index]] += 1
        }
    }

    private fun createGroundAndMap(
        input: List<String>,
        mapSize: Int): Pair<List<MutableList<Int>>, List<List<Pair<Int, Int>>>> {
        val ground = (0..mapSize).map {
            (0..mapSize).map { 0 }.toMutableList()
        }
        val map = input.map { line ->
            line.split(" -> ")
                .map { it.split(",") }
                .map { Pair(it.first().toInt(), it.last().toInt()) }
        }
        return Pair(ground, map)
    }

    private fun paintGround(ground: List<List<Int>>) {
        ground.forEach { println(it.joinToString("")) }
        println()
    }

    @JvmStatic
    @OptIn(ExperimentalTime::class)
    fun main(args: Array<String>) {
        val input = Utils.readLines("day5.txt")

        Utils.printResult("part 1") { part1(input) }
        Utils.printResult("part 2") { part2(input) }
    }
}