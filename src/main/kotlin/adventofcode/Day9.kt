package adventofcode

import kotlin.time.ExperimentalTime

object Day9 {

    fun part1(input: List<String>): Int {
        val grid = input.map { row -> row.map { it.digitToInt() } }

        val lowest = grid.indices.flatMap { row ->
            grid[row].indices.filter { col ->
                isLowest(row, col, grid)
            }.map { col ->
                grid[row][col]
            }
        }

        return lowest.sumOf { it + 1 }
    }

    private fun isLowest(row: Int, col: Int, grid: List<List<Int>>): Boolean {
        val neighbors = findNeighbors(row, col, grid)
        return neighbors.all { grid[row][col] < it }
    }

    private fun findNeighbors(row: Int, col: Int, grid: List<List<Int>>): List<Int> {
        val north = if (row == 0) null else grid[row - 1][col]
        val south = if (row == grid.size - 1) null else grid[row + 1][col]
        val west = if (col == 0) null else grid[row][col - 1]
        val east = if (col == grid[row].size - 1) null else grid[row][col + 1]
        return listOfNotNull(north, south, west, east)
    }

    @JvmStatic
    @OptIn(ExperimentalTime::class)
    fun main(args: Array<String>) {
        val input = Utils.readLines("day9.txt")

        Utils.printResult("part 1") { part1(input) }
//        Utils.printResult("part 2") { part2(input) }
    }
}