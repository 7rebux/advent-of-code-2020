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

private fun simulate() {
    val inputClone = input.map { it.copyOf() }.toMutableList()
    var previous = emptyList<CharArray>().toMutableList()

    // really bad check lol (still works tho)
    while(countOccupied(previous) == 0 || countOccupied(input) != countOccupied(previous) ) {
        previous = inputClone.map { it.copyOf() }.toMutableList()

        for (y in input.indices) {
            for (x in input[y].indices) {
                if (input[y][x] == 'L' && countSeeable(x, y) == 0)
                    inputClone[y][x] = '#'
                else if (input[y][x] == '#' && countSeeable(x, y) >= 5)
                    inputClone[y][x] = 'L'
            }
        }
        input = inputClone.map { it.copyOf() }.toMutableList()
    }
}

fun countSeeable(x: Int, y: Int): Int {
    return isSeeable(x, y, 0, -1) +
            isSeeable(x, y, 1, -1) +
            isSeeable(x, y, 1, 0) +
            isSeeable(x, y, 1, 1) +
            isSeeable(x, y, 0, 1) +
            isSeeable(x, y, -1, 1) +
            isSeeable(x, y, -1, 0) +
            isSeeable(x, y, -1, -1)
}

fun isSeeable(x: Int, y: Int, pOffX: Int, pOffY: Int): Int {
    var offX = pOffX
    var offY = pOffY

    while (x + offX >= 0 && x + offX < input[0].size && y + offY >= 0 && y + offY < input.size) {
        if (input[y+offY][x+offX] == '#')
            return 1

        if (input[y+offY][x+offX] == 'L')
            break

        offX += pOffX
        offY += pOffY
    }
    return 0
}

private fun countOccupied(list: MutableList<CharArray>): Int {
    var count = 0

    for (y in list) {
        for (x in y) {
            if (x == '#')
                ++count
        }
    }

    return count
}
