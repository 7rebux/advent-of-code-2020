package day2

import java.nio.file.Files
import java.nio.file.Paths

fun main() {
    val database = Files.readAllLines(Paths.get("assets/day2.txt"))
    var valid = 0

    for (entry in database) {
        if (isValidFirst(entry))
            valid++
    }

    print(valid)
}

fun isValidFirst(entry: String): Boolean {
    val args = entry.split(" ")
    var count = 0

    val min = args[0].split("-")[0].toInt()
    val max = args[0].split("-")[1].toInt()
    val char = args[1].replace(":", "").single()
    val password = args[2]

    for (c in password) {
        if (c == char)
            count++
    }

    return count in min..max
}
