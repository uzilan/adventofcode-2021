package adventofcode

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class Day7Test : StringSpec({
    val input = Utils.readText("day7test.txt")

    "Day 7 part 1" {
        Day7.part1(input) shouldBe 37
    }

    "Day 7 part 2" {
        Day7.part2(input) shouldBe 168
    }
})
