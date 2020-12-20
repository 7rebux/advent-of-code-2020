package day05

import java.nio.file.Files
import java.nio.file.Paths

fun main() {
    val seats = Files.readAllLines(Paths.get("assets/day5.txt"))
    var id = 0

    for (line in seats) {
        val s = line.replace('B', '1')
            .replace('F', '0')
            .replace('R', '1')
            .replace('L', '0')

        val row = Integer.parseInt(s.toCharArray(0, 7).concatToString(), 2)
        val col = Integer.parseInt(s.toCharArray(7, 10).concatToString(), 2)

        id = maxOf(id, row * 8 + col)
    }

    print(id)
}
