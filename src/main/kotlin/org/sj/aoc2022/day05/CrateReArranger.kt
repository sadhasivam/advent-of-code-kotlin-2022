package org.sj.aoc2022.day05

import org.sj.aoc2022.util.readInput

fun rearrange(crates: List<MutableList<String>>, count: Int, from: Int, to: Int, inOrder: Boolean) {
    val fromCrate = crates[from]
    val toCrate = crates[to]
    val toCrateSize = toCrate.size
    repeat(count) {
        if (inOrder) {
            toCrate.add(toCrateSize, fromCrate.removeLast())
        } else {
            toCrate.add(fromCrate.removeLast())
        }
    }
   /* println("--------------------------------")
    crates.forEachIndexed { index, stack ->
        println("stack$index  $stack")
    }
    println("--------------------------------")*/
}

fun makeCrates(input: List<String>): List<MutableList<String>> {
    val crates = List(input.reversed().first().split("  ").count()) {
        mutableListOf<String>()
    }

    input.reversed().subList(1, input.size).map {
        it.chunked(4).forEachIndexed { index, item ->
            if (item.trim().isNotBlank()) {
                crates[index].add(item.trim())
            }
        }
    }
    return crates
}
private fun List<List<String>>.topItem(): String = this.joinToString("") {
    it.last().removePrefix("[").removeSuffix("]")
}

fun rearrangeCrate(input: List<String>, instructions: List<String>, inOrder: Boolean): String {
    val crates = makeCrates(input)
    instructions.map {
        val a = it.split(" ")
        val count = a[1].toInt()
        val from = a[3].toInt()
        val to = a[5].toInt()
        // println("$count -> $from -> $to")
        rearrange(crates, count, from - 1, to - 1, inOrder)
    }
    return crates.topItem()
}

fun main() {
    val basePath = "/org/sj/aoc2022/day05/"
    var input = readInput("${basePath}Day05Stack_test")
    var instructions = readInput("${basePath}Day05Instruction_test")
    check(rearrangeCrate(input, instructions, false) == "CMZ")
    check(rearrangeCrate(input, instructions, true) == "MCD")

    input = readInput("${basePath}Day05Stack")
    instructions = readInput("${basePath}Day05Instruction")
    check(rearrangeCrate(input, instructions, false) == "LJSVLTWQM")
    println(rearrangeCrate(input, instructions, true))
}
