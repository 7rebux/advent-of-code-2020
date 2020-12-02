package day1

import java.nio.file.Files
import java.nio.file.Paths

fun main() {
    val numbers = Files.readAllLines(Paths.get("assets/day1.txt")).map { it.toInt() }

    for (i in numbers) {
        for (j in numbers) {
            if (i+j == 2020) {
                print(i*j)
                return;
            }
        }
    }
}
