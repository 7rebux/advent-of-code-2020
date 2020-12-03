package day3

import java.nio.file.Files
import java.nio.file.Paths

fun main() {
    val area = Files.readAllLines(Paths.get("assets/day3.txt"))

    var x = 0
    var count = 0

    for (y in area.indices) {
        while (x >= area[y].length)
            area[y] += area[y]

        if (area[y][x] == '#')
            count++

        x += 3
    }

    print(count)
}
