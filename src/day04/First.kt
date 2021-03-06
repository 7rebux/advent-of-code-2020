package day04

import java.nio.file.Files
import java.nio.file.Paths

fun main() {
    val data = Files.readAllLines(Paths.get("assets/day04.txt"))
    var passport = ""
    var count = 0

    for (d in data) {
        if (d != "")
            passport += " $d"
        else {
            if (isValid(passport.substring(1)))
                count++
            passport = ""
        }
    }

    print(count)
}

private fun isValid(passport: String): Boolean {
    val fields = passport.split(" ")

    return fields.size == 8 || fields.size == 7 && !passport.contains("cid:")
}
