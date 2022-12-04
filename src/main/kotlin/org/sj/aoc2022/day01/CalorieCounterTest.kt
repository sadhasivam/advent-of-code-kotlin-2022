package org.sj.aoc2022.day01
import org.sj.aoc2022.util.readInput

fun main() {
    /*
    // Alternate Idea
    val data = File("src/Day01_test.txt").readText()
    val s = data.split("\n\n").map { elf ->
    elf.lines().map { it.toInt() }.sum()
    }
    s.max()
     */
    // test if implementation meets criteria from the description, like:

    val basePath = "/org/sj/aoc2022/day01/"
    val testInput = readInput("${basePath}Day01_test")
    println("checking test input for Max Elf calories ")
    check(maxElvesCalories(testInput) == 24000)
    println("checking test input for Max top 3 Elves calories ")
    check(topNElvesCalories(testInput, maxNCalories) == 45000)

    val input = readInput("${basePath}Day01")
    println("checking test input for Max Elf calories ")
    check(maxElvesCalories(input) == 67633)
    println("checking test input for Max top 3 Elves calories ")
    check(topNElvesCalories(input, maxNCalories) == 199628)
}
