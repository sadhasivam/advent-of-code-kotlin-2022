package org.sj.aoc2022

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

fun String.intRange() =
    this.split("-").first().toInt()..this.split("-").last().toInt()
