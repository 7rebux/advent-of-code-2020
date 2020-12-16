package day7

import java.nio.file.Files
import java.nio.file.Paths

private val tree = emptyMap<String, MutableSet<String>>().toMutableMap()
private val ans = emptyList<String>().toMutableList()

fun main() {
    val rules = Files.readAllLines(Paths.get("assets/day7.txt"))

    for (r in rules) {
        val bag = r.split(" bag")[0]
        val regex = Regex("(\\d) (.+?) bag")
        val matches = regex.findAll(r, 0).toList()

        for (m in matches) {
            if (bag !in tree)
                tree[bag] = mutableSetOf()

            tree[bag]!!.add(m.groups[2]!!.value)
        }
    }

    searchFirst("shiny gold")
    print(ans.distinct().size)
}

fun searchFirst(color: String) {
    for (entry in tree) {
        if (color in entry.value) {
            ans.add(entry.key)
            searchFirst(entry.key)
        }
    }
}
