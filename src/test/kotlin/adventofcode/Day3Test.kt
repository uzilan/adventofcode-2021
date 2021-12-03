package adventofcode

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class Day3Test : StringSpec({
    val input = listOf(
        "00100",
        "11110",
        "10110",
        "10111",
        "10101",
        "01111",
        "00111",
        "11100",
        "10000",
        "11001",
        "00010",
        "01010",
    )

    "Day 3 part 1" {
        Day3.part1(input) shouldBe 198
    }

    "Day 3 part 2" {
        Day3.part2(input) shouldBe 230
    }
})