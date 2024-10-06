package io.xdatagroup.puzzle

import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import java.io.File

fun main() {
    try {
        val puzzleConditions = loadPuzzleConditions("puzzle_conditions.json")
        val puzzle = ZebraPuzzle(puzzleConditions)
        val solution = puzzle.solve()

        solution?.let {
            saveSolutionToJson(it, "puzzle_solution.json")
            println("Solution saved to zebra_puzzle_solution.json")
        } ?: run {
            println("No solution found!")
        }
    } catch (e: Exception) {
        println("An error occurred: ${e.message}")
    }
}

fun loadPuzzleConditions(filePath: String): PuzzleConditions {
    return try {
        val jsonString = File(filePath).readText()
        Json.decodeFromString<PuzzleConditions>(jsonString)
    } catch (e: Exception) {
        throw IllegalArgumentException("Failed to load puzzle conditions from $filePath: ${e.message}")
    }
}

fun saveSolutionToJson(solution: ZebraPuzzleSolution, outputFilePath: String) {
    try {
        val jsonString = Json.encodeToString(solution)
        File(outputFilePath).writeText(jsonString)
    } catch (e: Exception) {
        throw IllegalArgumentException("Failed to save solution to $outputFilePath: ${e.message}")
    }
}
