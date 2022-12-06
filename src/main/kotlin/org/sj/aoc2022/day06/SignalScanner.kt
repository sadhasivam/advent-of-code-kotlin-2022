package org.sj.aoc2022.day06

import org.sj.aoc2022.util.readInput

fun String.hasUniqueChars(): Boolean = this.toCharArray().distinct().count() != length
fun scanSignal(input: String, marker: Int): Int {
    var signal = ""
    var count = 0

    for (char in input.asSequence()) {
        signal += char
        count++
        if (count > 3 && signal.length == marker && signal.hasUniqueChars()) {
            signal = signal.drop(1)
        }
        if (signal.length == marker) {
            return count
        }
    }
    return -1
}

data class SignalIO(val marker: Int, val output: Int)

fun main() {
    val basePath = "/org/sj/aoc2022/day06/"
    var testSignalData = mapOf(
        "mjqjpqmgbljsphdztnvjfqwrcgsmlb" to listOf(SignalIO(4, 7), SignalIO(14, 19)),
        "bvwbjplbgvbhsrlpgdmjqwftvncz" to listOf(SignalIO(4, 5), SignalIO(14, 23)),
        "nppdvjthqldpwncqszvftbrmjlhg" to listOf(SignalIO(4, 6), SignalIO(14, 23)),
        "nznrnfrfntjfmvfwmzdfjlvtqnbhcprsg" to listOf(SignalIO(4, 10), SignalIO(14, 29)),
        "zcfzfwzzqfrljwzlrfnpqdbhtmscgvjw" to listOf(SignalIO(4, 11), SignalIO(14, 26))
    )

    testSignalData.forEach { (signal, value) ->
        for (sio in value) {
            check(scanSignal(signal, sio.marker) == sio.output)
            return@forEach
        }
    }

    val signalData = readInput("${basePath}Day06")
    for (signal in signalData) {
        check(scanSignal(signal, 4) == 1542)
        check(scanSignal(signal, 14) == 3153)
    }
}
