package org.sj.aoc2022.day04

import org.sj.aoc2022.intRange

fun fullyOverlappingAssignments(input: List<String>): Int = input.count {
    val (e1, e2) = it.split(",")
    e1.intRange() overlaps e2.intRange()
}

fun partiallyOverlappingAssignments(input: List<String>): Int = input.count {
    val (e1, e2) = it.split(",")
    e1.intRange() partialOverlaps e2.intRange()
}

private infix fun IntRange.overlaps(r: IntRange): Boolean = (this.first >= r.first && this.last <= r.last) ||
    (r.first >= this.first && r.last <= this.last)

private infix fun IntRange.partialOverlaps(r: IntRange): Boolean {
    val range = this + r
    return range.size != range.toSet().size
}
