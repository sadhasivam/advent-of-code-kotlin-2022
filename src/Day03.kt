fun priorityItems(input: List<String>): Int = input.map {
    it.substring(0, it.length / 2).toSet().intersect(it.substring(it.length / 2, it.length).toSet())
}.flatten().sumOf { priority(it) }

fun priority(c: Char): Int = if (c in 'a'..'z') {
    c.toInt() - 96
} else {
    c.toInt() - 38
}

fun priorityGroupItems(input: List<String>): Int = input.chunked(3) {
    it[0].toSet().intersect(it[1].toSet()).intersect(it[2].toSet())
}.flatten().sumOf { priority(it) }

fun main() {
    check(priorityItems(readInput("Day03_test")) == 157)
    check(priorityItems(readInput("Day03")) == 8515)
    check(priorityGroupItems(readInput("Day03_test")) == 70)
    println(priorityGroupItems(readInput("Day03")))
}