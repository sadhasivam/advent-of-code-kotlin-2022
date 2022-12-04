fun priorityItems(input: List<String>): Int = input.map {
    it.substring(0, it.length / 2) intersect it.substring(it.length / 2)
}.flatten().sumOf { it.priority }

fun priorityGroupItems(input: List<String>): Int = input.chunked(3) {
    it[0] intersect it[1] intersect it[2]
}.flatten().sumOf { it.priority }

fun main() {
    check(priorityItems(readInput("Day03_test")) == 157)
    check(priorityItems(readInput("Day03")) == 8515)
    check(priorityGroupItems(readInput("Day03_test")) == 70)
    check(priorityGroupItems(readInput("Day03")) == 2434)
}

// Improved after watching the video.
val Char.priority: Int
    get(): Int {
        return when (this) {
            in 'a'..'z' -> this.code - 96
            in 'A'..'Z' -> this.code - 38
            else -> error("Check your input $this")
        }
    }

inline infix fun String.intersect(s: String) = this.toSet() intersect s.toSet()
inline infix fun Set<Char>.intersect(s: String) = this intersect s.toSet()
