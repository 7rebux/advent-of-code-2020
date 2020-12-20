package day03

import java.nio.file.Files
import java.nio.file.Paths

fun main() {
    var result: Long = 1
    val slopes = arrayOf(
        arrayOf(1, 1),
        arrayOf(1, 3),
        arrayOf(1, 5),
        arrayOf(1, 7),
        arrayOf(2, 1)
    )

    slopes.forEach { result *= checkSlope(it[0], it[1]) }

    print(result)
}

fun checkSlope(down: Int, right: Int): Int {
    val area = Files.readAllLines(Paths.get("assets/day3.txt"))

    var x = 0
    var count = 0

    for (y in area.indices step down) {
        while (x >= area[y].length)
            area[y] += area[y]

        if (area[y][x] == '#')
            count++

        x += right
    }

    return count
}
