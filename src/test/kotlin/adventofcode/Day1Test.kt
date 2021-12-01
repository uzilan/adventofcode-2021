package adventofcode

import io.kotest.core.spec.style.StringSpec

class Day1Test : StringSpec({
    val input = listOf(
        199,
        200,
        208,
        210,
        200,
        207,
        240,
        269,
        260,
        263,
    )

    "Day 1 part 1" {
        assert(Day1.part1(input) == 7)
    }

    "Day 1 part 2" {
        assert(Day1.part2(input) == 5)
    }

})
