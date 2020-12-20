package day05

import java.nio.file.Files
import java.nio.file.Paths

fun main() {
    val seats = Files.readAllLines(Paths.get("assets/day05.txt"))
    val ids = arrayListOf<Int>()

    for (line in seats) {
        val s = line.replace('B', '1')
            .replace('F', '0')
            .replace('R', '1')
            .replace('L', '0')

        val row = Integer.parseInt(s.toCharArray(0, 7).concatToString(), 2)
        val col = Integer.parseInt(s.toCharArray(7, 10).concatToString(), 2)

        ids.add(row * 8 + col)
    }

    for (id in ids.sorted()) {
        if ((id+1) !in ids && (id+2) in ids)
            print(id+1)
    }
}
