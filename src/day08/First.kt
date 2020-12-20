package day08

import java.nio.file.Files
import java.nio.file.Paths

fun main() {
    val input = Files.readAllLines(Paths.get("assets/day08.txt"))
    val commands = arrayOf<List<String>>().toMutableList()

    input.forEach {
        commands.add(it.split(" "))
    }

    var accumulator = 0
    val seen = emptyArray<Int>().toMutableList()

    var i = 0
    while (true) {
        if (i >= commands.size || i in seen)
            break
        seen.add(i)
        when (commands[i][0]) {
            "nop" -> ++i
            "acc" -> { accumulator += commands[i][1].toInt(); ++i }
            "jmp" -> i += commands[i][1].toInt()
        }
    }

    print(accumulator)
}
