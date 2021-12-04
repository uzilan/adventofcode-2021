package adventofcode

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class Day2Test : StringSpec({
    val input = Utils.readLines("day2test.txt")

    "Day 2 part 1" {
        Day2.part1(input) shouldBe 150
    }

    "Day 2 part 2" {
        Day2.part2(input) shouldBe 900
    }
})
