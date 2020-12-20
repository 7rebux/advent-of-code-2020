package day07

import java.nio.file.Files
import java.nio.file.Paths

private val tree = emptyMap<String, MutableMap<String, Int>>().toMutableMap()

fun main() {
    val rules = Files.readAllLines(Paths.get("assets/day7.txt"))

    for (r in rules) {
        val bag = r.split(" bag")[0]
        val regex = Regex("(\\d) (.+?) bag")
        val matches = regex.findAll(r, 0).toList()

        for (m in matches) {
            if (bag !in tree)
                tree[bag] = mutableMapOf()

            tree[bag]!!.put(m.groups[2]!!.value, m.groups[1]!!.value.toInt())
        }
    }

    println(search("shiny gold") - 1)
}

private fun search(color: String): Int {
    var count = 1
    tree[color]?.iterator()?.forEach { bag ->
        count += bag.value * search(bag.key)
    }
    return count
}
