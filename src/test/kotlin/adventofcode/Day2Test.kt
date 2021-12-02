package adventofcode

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class Day2Test : StringSpec({
    val input = listOf(
        "forward 5",
        "down 5",
        "forward 8",
        "up 3",
        "down 8",
        "forward 2",
    )

    "Day 2 part 1" {
        Day2.part1(input) shouldBe 150
    }

    "Day 2 part 2" {
        Day2.part2(input) shouldBe 900
    }
})
