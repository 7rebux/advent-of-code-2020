package day10

import java.math.BigInteger
import java.nio.file.Files
import java.nio.file.Paths

fun main() {
    val input = Files.readAllLines(Paths.get("assets/day10.txt")).map { it.toInt() }.plus(0).sorted()

    val possibilities = listOf<BigInteger>(BigInteger.ONE, BigInteger.ONE, BigInteger.TWO)
        .plus(generateSequence { BigInteger.ZERO }.take(input[input.size-3]).toMutableList()).toMutableList()

    for (i in input.drop(0))
        if (i > 2) possibilities[i] = possibilities[i - 1] + possibilities[i - 2] + possibilities[i - 3]

    println(possibilities.last())
}
