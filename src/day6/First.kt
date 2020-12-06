package day6

import java.nio.file.Files
import java.nio.file.Paths

fun main() {
    val list = Files.readAllLines(Paths.get("assets/day6.txt"))
    var current = ""
    var sum = 0

    for (l in list) {
        if (l != "")
            current += l
        else {
            sum += current.toCharArray().distinct().size
            println(sum)
            current = ""
        }
    }

    print(sum)
}
