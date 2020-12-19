package day11

import java.nio.file.Files
import java.nio.file.Paths

private val input = Files.readAllLines(Paths.get("assets/day11.txt")).map { it.toCharArray() }.toMutableList()

fun main() {
    // add border as floor
    input.forEachIndexed { i, it -> input[i] = ".${String(it)}.".toCharArray() }
    input.add(0, ".".repeat(input[0].size).toCharArray())
    input.add(input.size, ".".repeat(input[0].size).toCharArray())

    simulate()
    print(countOccupied())
}

fun simulate() {
    var previous = emptyList<CharArray>()

    while(input != previous) {
        println(input.size)

        previous = input

        for (y in input.indices) {
            for (x in input[y].indices) {
                if (input[y][x] == 'L' && countAdjacent(x, y) == 0)
                    input[y][x] = '#'
                else if (input[y][x] == '#' && countAdjacent(x, y) >= 4)
                    input[y][x] = 'L'
            }
        }
    }
}

fun countAdjacent(x: Int, y: Int): Int {
    var count = 0

    if (input[y][x] == '.')
        return 0

    if (input[y-1][x-1] == '#')
        ++count

    if (input[y-1][x] == '#')
        ++count

    if (input[y-1][x+1] == '#')
        ++count

    if (input[y][x-1] == '#')
        ++count

    if (input[y][x+1] == '#')
        ++count

    if (input[y+1][x-1] == '#')
        ++count

    if (input[y+1][x] == '#')
        ++count

    if (input[y+1][x+1] == '#')
        ++count

    return count
}

fun countOccupied(): Int {
    var count = 0

    for (y in input) {
        for (x in y) {
            if (x == '#')
                ++count
        }
    }

    return count
}
