package day10

import java.nio.file.Files
import java.nio.file.Paths

fun main() {
    val input = Files.readAllLines(Paths.get("assets/day10.txt")).map { it.toInt() }.plus(0).sorted()

    var (a, b) = listOf(0, 0)

    for (i in 0 until input.size-1)
        if (input[i+1] - input[i] == 1) ++a else ++b

    print(a * (b+1))
}
