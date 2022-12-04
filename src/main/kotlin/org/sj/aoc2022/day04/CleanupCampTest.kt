package org.sj.aoc2022.day04

import org.sj.aoc2022.util.readInput
fun main() {
    val basePath = "/org/sj/aoc2022/day04/"
    var result = fullyOverlappingAssignments(readInput("${basePath}Day04_test"))
    check(result == 2)
    result = fullyOverlappingAssignments(readInput("${basePath}Day04"))
    check(result == 483)
    result = partiallyOverlappingAssignments(readInput("${basePath}Day04_test"))
    println(result)
    check(result == 4)
    result = partiallyOverlappingAssignments(readInput("${basePath}Day04"))
    println(result)
    check(result == 874)
}
