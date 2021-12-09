package adventofcode

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class Day9Test : StringSpec({
    val input = Utils.readLines("day9test.txt")

    "Day 9 part 1" {
        Day9.part1(input) shouldBe 15
    }

//    "Day 8 part 2" {
//        Day8.part2(input) shouldBe 61229
//    }
})
