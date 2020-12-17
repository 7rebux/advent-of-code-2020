package day9

import java.nio.file.Files
import java.nio.file.Paths

fun main() {
    val input = Files.readAllLines(Paths.get("assets/day9.txt")).map { it.toLong() }
    val invalidNumber: Long = 21806024 // output of day9/First.kt

    var start = 0
    val contiguousSet = emptyList<Long>().toMutableList()

    while (contiguousSet.sum() != invalidNumber) {
        for (i in start until input.size) {
            if (contiguousSet.sum() > invalidNumber) {
                ++start
                contiguousSet.clear()
                break
            }

            if (contiguousSet.sum() == invalidNumber && contiguousSet.size > 1)
                break

            contiguousSet += input[i]
        }
    }

    print(contiguousSet.min()!! + contiguousSet.max()!!)
}
