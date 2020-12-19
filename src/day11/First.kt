package day11

import java.nio.file.Files
import java.nio.file.Paths

private var input = Files.readAllLines(Paths.get("assets/day11.txt")).map { it.toCharArray() }.toMutableList()

fun main() {
    // add border as floor
    input.forEachIndexed { i, it -> input[i] = ".${String(it)}.".toCharArray() }
    input.add(0, ".".repeat(input[0].size).toCharArray())
    input.add(input.size, ".".repeat(input[0].size).toCharArray())

    simulate()
    print(countOccupied(input))
}

fun simulate() {
    val inputClone = input.map { it.copyOf() }.toMutableList()
    var previous = emptyList<CharArray>().toMutableList()

    // really bad check lol (still works tho)
    while(countOccupied(previous) == 0 || countOccupied(input) != countOccupied(previous) ) {
        previous = inputClone.map { it.copyOf() }.toMutableList()

        for (y in input.indices) {
            for (x in input[y].indices) {
                if (input[y][x] == 'L' && countAdjacent(x, y) == 0)
                    inputClone[y][x] = '#'
                else if (input[y][x] == '#' && countAdjacent(x, y) >= 4)
                    inputClone[y][x] = 'L'
            }
        }
        input = inputClone.map { it.copyOf() }.toMutableList()
    }
}

fun countAdjacent(x: Int, y: Int): Int {
    var count = 0

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

fun countOccupied(list: MutableList<CharArray>): Int {
    var count = 0

    for (y in list) {
        for (x in y) {
            if (x == '#')
                ++count
        }
    }

    return count
}
