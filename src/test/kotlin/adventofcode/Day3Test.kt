package adventofcode

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class Day3Test : StringSpec({
    val input = Utils.readLines("day3test.txt")

    "Day 3 part 1" {
        Day3.part1(input) shouldBe 198
    }

    "Day 3 part 2" {
        Day3.part2(input) shouldBe 230
    }
})