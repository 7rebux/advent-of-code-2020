package day04

import java.nio.file.Files
import java.nio.file.Paths

fun main() {
    val data = Files.readAllLines(Paths.get("assets/day4.txt"))
    var passport = ""
    var count = 0

    for (d in data) {
        if (d != "")
            passport += " $d"
        else {
            if (isValid(passport.substring(1)))
                count++
            passport = ""
        }
    }

    print(count)
}

private fun isValid(passport: String): Boolean {
    val fields = passport.split(" ")
    val values = hashMapOf<String, String>()

    fields.forEach { values[it.split(":")[0]] = it.split(":")[1] }

    if (values.size < 7 || values.size == 7 && values.contains("cid"))
        return false

    if ((values["byr"]!!.toInt() in 1920..2002) &&
        (values["iyr"]!!.toInt() in 2010..2020) &&
        (values["eyr"]!!.toInt() in 2010..2030) &&
        (checkHeight(values["hgt"] as String)) &&
        (values["hcl"]!!.matches(Regex("#[a-f0-9]{6}"))) &&
        (values["ecl"] in arrayOf("amb", "blu", "brn", "gry", "grn", "hzl", "oth")) &&
        (values["pid"]!!.length == 9 && values["pid"]!!.toIntOrNull()?.let { true } == true))
            return true

    return false
}

fun checkHeight(hgt: String): Boolean {
    if (hgt.contains("cm"))
        return (hgt.split("cm")[0]).toInt() in 150..193
    else if (hgt.contains("in"))
        return (hgt.split("in")[0]).toInt() in 59..76

    return false
}
