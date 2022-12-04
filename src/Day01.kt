import java.io.File

fun main() {
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

    // Alternate Idea
    val data = File("src/Day01_test.txt").readText()
    val s = data.split("\n\n").map { elf ->
        elf.lines().map { it.toInt() }.sum()
    }
    s.max()

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day01_test")
    println("checking test input for Max Elf calories ")
    check(maxElvesCalories(testInput) == 24000)
    println("checking test input for Max top 3 Elves calories ")
    check(topNElvesCalories(testInput, maxNCalories) == 45000)

    val input = readInput("Day01")
    println("checking test input for Max Elf calories ")
    check(maxElvesCalories(input) == 67633)
    println("checking test input for Max top 3 Elves calories ")
    check(topNElvesCalories(input, maxNCalories) == 199628)
}
