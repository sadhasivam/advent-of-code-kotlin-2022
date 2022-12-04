package org.sj.aoc2022.day02

import org.sj.aoc2022.util.readInput

fun main() {
    val basePath = "/org/sj/aoc2022/day02/"
    val testInput = readInput("${basePath}Day02_test")
    val a = testInput.map {
        rcpMap[it.last()]!! + rockPaperScissor(it)
    }.sumOf { it }
    check(a == 15)

    val input = readInput("${basePath}Day02")
    val answer = input.map {
        rcpMap[it.last()]!! + rockPaperScissor(it)
    }.sumOf { it }
    check(answer == 11767)

    val b = testInput.map {
        resultMap[it.last()]!! + rockPaperScissorWithStrategy(it)
    }.sumOf { it }
    println(b)
    check(b == 12)

    val answer2 = input.map {
        resultMap[it.last()]!! + rockPaperScissorWithStrategy(it)
    }.sumOf { it }
    println(answer2)
}
