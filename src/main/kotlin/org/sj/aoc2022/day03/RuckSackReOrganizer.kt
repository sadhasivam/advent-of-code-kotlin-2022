package org.sj.aoc2022.day03

import org.sj.aoc2022.intersect
import org.sj.aoc2022.priority

fun priorityItems(input: List<String>): Int = input.map {
    it.substring(0, it.length / 2) intersect it.substring(it.length / 2)
}.flatten().sumOf { it.priority }

fun priorityGroupItems(input: List<String>): Int = input.chunked(3) {
    it[0] intersect it[1] intersect it[2]
}.flatten().sumOf { it.priority }
