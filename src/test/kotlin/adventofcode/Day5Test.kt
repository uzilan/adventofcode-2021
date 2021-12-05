package adventofcode

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class Day5Test : StringSpec({
    val input = Utils.readLines("day5test.txt")

    "Day 5 part 1" {
        Day5.part1(input, 9) shouldBe 5
    }

    "Day 5 part 2" {
        Day5.part2(input, 9) shouldBe 12
    }
})
