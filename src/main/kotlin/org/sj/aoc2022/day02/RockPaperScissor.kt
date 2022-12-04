package org.sj.aoc2022.day02

// Rock defeats Scissors, (A, X)
// Paper defeats Rock     (B, Y)
// Scissors defeats Paper,(C, Z)

const val WIN = 6
const val DRAW = 3
const val LOSS = 0

val rcpMap = mapOf<Char, Int>(
    'A' to 1,
    'B' to 2,
    'C' to 3,
    'X' to 1,
    'Y' to 2,
    'Z' to 3
)

val resultMap = mapOf<Char, Int>(
    'X' to LOSS,
    'Y' to DRAW,
    'Z' to WIN
)

fun rockPaperScissor(play: String): Int {
    if (play in listOf("A X", "B Y", "C Z")) {
        return DRAW
    }
    if (play in listOf("B X", "C Y", "A Z")) {
        return LOSS
    }
    if (play in listOf("C X", "A Y", "B Z")) {
        return WIN
    }
    error("condition didn't met")
}

// X means you need to lose,
// Y means you need to end the round in a draw, and
// Z means you need to win. Good luck!"
val ROCK = listOf("A Y", "B X", "C Z")
val PAPER = listOf("A Z", "B Y", "C X")
val SCISSOR = listOf("A X", "B Z", "C Y")
fun rockPaperScissorWithStrategy(play: String): Int {
    if (play in ROCK) {
        return 1
    }
    if (play in PAPER) {
        return 2
    }
    if (play in SCISSOR) {
        return 3
    }
    error("condition didn't met")
    // return resultMap[play.last()]!!
}
