package org.sj.aoc2022.day03

import org.sj.aoc2022.util.readInput

fun main() {
    val basePath = "/org/sj/aoc2022/day03/"
    check(priorityItems(readInput("${basePath}Day03_test")) == 157)
    check(priorityItems(readInput("${basePath}Day03")) == 8515)
    check(priorityGroupItems(readInput("${basePath}Day03_test")) == 70)
    check(priorityGroupItems(readInput("${basePath}Day03")) == 2434)
}
