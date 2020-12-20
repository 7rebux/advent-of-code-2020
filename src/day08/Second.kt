package day08

import java.nio.file.Files
import java.nio.file.Paths

private val commands = arrayOf<List<String>>().toMutableList()

fun main() {
    val input = Files.readAllLines(Paths.get("assets/day8.txt"))

    input.forEach {
        commands.add(it.split(" "))
    }

    for (i in 0 until commands.size) {
        if (commands[i][0] == "nop" || commands[i][0] == "jmp") {
            commands[i] = listOf(swap(commands[i][0]), commands[i][1])
            if (boot() != 0)
                break
            commands[i] = listOf(swap(commands[i][0]), commands[i][1])
        }
    }

    print(boot())
}

fun boot(): Int {
    var accumulator = 0
    val seen = emptyArray<Int>().toMutableList()
    var i = 0

    while (true) {
        if (i >= commands.size)
            return accumulator
        if (i in seen)
            return 0
        seen.add(i)
        when (commands[i][0]) {
            "nop" -> ++i
            "acc" -> { accumulator += commands[i][1].toInt(); ++i }
            "jmp" -> i += commands[i][1].toInt()
        }
    }
}

fun swap(value: String): String {
    return if (value == "nop") "jmp" else "nop"
}
