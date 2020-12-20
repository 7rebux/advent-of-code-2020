package day06

import java.nio.file.Files
import java.nio.file.Paths

fun main() {
    val list = Files.readAllLines(Paths.get("assets/day6.txt"))
    var current = emptyArray<String>()
    var sum = 0

    for (l in list) {
        if (l != "")
            current += l
        else {
            for (c in CharArray(26) { (it + 97).toChar() }.joinToString("")) {
                var yes = true
                for (p in current) {
                    if (!p.contains(c))
                        yes = false
                }

                if (yes) sum++
            }

            current = emptyArray()
        }
    }

    print(sum)
}
