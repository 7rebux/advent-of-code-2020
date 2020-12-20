package day09

import java.nio.file.Files
import java.nio.file.Paths

/**
 * Could cause an IndexOutOfBoundsException if there are only valid numbers
 */
fun main() {
    val input = Files.readAllLines(Paths.get("assets/day09.txt")).map { it.toLong() }

    for (i in input.indices) {
        val number = input[i+25]
        if (!isValid(input.subList(i, i + 25), number)) {
            print(number)
            return
        }
    }
}

fun isValid(options: List<Long>, number: Long): Boolean {
    for (i in options.indices) {
        for (j in options.indices) {
            if (i == j)
                continue

            if (options[i] + options[j] == number)
                return true
        }
    }
    return false
}
