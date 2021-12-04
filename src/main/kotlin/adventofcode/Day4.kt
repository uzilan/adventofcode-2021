package adventofcode

import kotlin.time.ExperimentalTime

object Day4 {
    fun part1(input: String): Int {
        val (numbers, boards) = processInput(input)
        return part1Helper(numbers, boards)
    }

    fun part2(input: String): Int {
        val (numbers, boards) = processInput(input)
        return part2Helper(numbers, boards)
    }

    private tailrec fun part1Helper(numbers: List<Int>, boards: List<Board>): Int {
        val currentNumber = numbers.first()
        boards.forEach { board ->
            board.mark(currentNumber)
            if (board.isBingo()) return board.unmarkedSum() * currentNumber
        }
        return part1Helper(numbers.drop(1), boards)
    }

    private tailrec fun part2Helper(numbers: List<Int>, boards: List<Board>): Int {
        val currentNumber = numbers.first()
        boards.forEach { board ->
            board.mark(currentNumber)
            if (boards.all { it.isBingo() }) return board.unmarkedSum() * currentNumber
        }
        return part2Helper(numbers.drop(1), boards)
    }

    private fun processInput(input: String): Pair<List<Int>, List<Board>> {
        val split = input.split("\n\n")
        val numbers = split.first().split(",").map { it.toInt() }
        val boards = split.drop(1).map { it.toBoard() }
        return Pair(numbers, boards)
    }

    data class Number(val number: Int, var marked: Boolean = false)
    data class Board(val lines: List<List<Number>>) {
        fun mark(number: Int) {
            lines.flatten().forEach {
                if (it.number == number) {
                    it.marked = true
                }
            }
        }

        private val columns = (0 until lines.first().size).map {
            lines.map { line -> line[it] }
        }

        fun isBingo(): Boolean {
            return lines.any { line -> line.all { it.marked } } || columns.any { column -> column.all { it.marked } }
        }

        fun unmarkedSum(): Int {
            return lines.flatten().filter { !it.marked }.sumOf { it.number }
        }
    }

    private fun Int.toNumber() = Number(this)

    private fun String.toBoard(): Board {
        val map = this.split("\n")
            .map { line ->
                line.trim().split("""\s+""".toRegex())
                    .map { num -> num.toInt().toNumber() }
            }
        return Board(map)
    }

    @JvmStatic
    @OptIn(ExperimentalTime::class)
    fun main(args: Array<String>) {
        val input = Utils.readText("day4.txt")

        Utils.printResult("part 1") { Day4.part1(input) }
        Utils.printResult("part 2") { Day4.part2(input) }
    }
}
