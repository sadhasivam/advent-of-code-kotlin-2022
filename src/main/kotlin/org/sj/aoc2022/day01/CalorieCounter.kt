package org.sj.aoc2022.day01

val maxNCalories = 3

fun computeElvesCaloriesList(input: List<String>): List<Int> {
    val elvesCalories = mutableListOf<Int>()
    var calories = 0
    input.forEach {
        if (it.trim() != "") {
            calories += it.toInt()
        } else {
            elvesCalories.add(calories)
            calories = 0
        }
    }
    if (calories > 0) {
        elvesCalories.add(calories)
    }
    return elvesCalories
}

/**
 * Find the Elf carrying the most Calories. How many total Calories is that Elf carrying?
 */
fun maxElvesCalories(input: List<String>): Int =
    computeElvesCaloriesList(input).max()

/**
 * Find the top three Elves carrying the most Calories. How many Calories are those Elves carrying in total?
 */
fun topNElvesCalories(input: List<String>, nCalories: Int): Int =
    computeElvesCaloriesList(input)
        .sorted()
        .asReversed()
        .take(nCalories)
        .sum()
