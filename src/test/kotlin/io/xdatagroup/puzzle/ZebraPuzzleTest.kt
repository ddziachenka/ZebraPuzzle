package io.xdatagroup.puzzle

import org.junit.Assert.*
import org.junit.Test

class ZebraPuzzleTest {

    @Test
    fun testSolveZebraPuzzle() {
        // Given
        val conditions = PuzzleConditions(
            houseColors = listOf("Red", "Green", "Ivory", "Yellow", "Blue"),
            nationalities = listOf("Englishman", "Spaniard", "Ukrainian", "Japanese", "Norwegian"),
            drinks = listOf("Coffee", "Tea", "Milk", "Orange Juice", "Water"),
            cigars = listOf("Old Gold", "Kools", "Chesterfields", "Lucky Strike", "Parliaments"),
            pets = listOf("Dog", "Snails", "Fox", "Horse", "Zebra")
        )

        val puzzle = ZebraPuzzle(conditions)

        // When
        val solution = puzzle.solve()

        // Then
        assertNotNull("Solution should not be null", solution)
        assertEquals("Water drinker should be Norwegian", "Norwegian", solution?.waterDrinker)
        assertEquals("Zebra owner should be Japanese", "Japanese", solution?.zebraOwner)
    }

    @Test
    fun testDifferentConditions() {
        // Given
        val conditions = PuzzleConditions(
            houseColors = listOf("Red", "Green", "Ivory", "Yellow", "Blue"),
            nationalities = listOf("Frenchman", "German", "Ukrainian", "Japanese", "Norwegian"),
            drinks = listOf("Coffee", "Tea", "Milk", "Orange Juice", "Water"),
            cigars = listOf("Old Gold", "Kools", "Chesterfields", "Lucky Strike", "Parliaments"),
            pets = listOf("Dog", "Snails", "Fox", "Horse", "Tiger")
        )

        val puzzle = ZebraPuzzle(conditions)

        // When
        val solution = puzzle.solve()

        // Then
        assertNotNull("Solution should not be null", solution)
        assertEquals("Water drinker should be Norwegian", "Norwegian", solution?.waterDrinker)
        assertEquals("Tiger owner should be Japanese", "Japanese", solution?.zebraOwner)
    }

    @Test
    fun testIncorrectConditions() {
        assertThrows(IllegalArgumentException::class.java) {
            PuzzleConditions(
                houseColors = listOf("Red", "Green", "Ivory", "Yellow", "Blue", "Purple"),  // Extra color
                nationalities = listOf("Englishman", "Spaniard", "Ukrainian", "Japanese", "Norwegian"),
                drinks = listOf("Coffee", "Tea", "Milk", "Orange Juice", "Water"),
                cigars = listOf("Old Gold", "Kools", "Chesterfields", "Lucky Strike", "Parliaments"),
                pets = listOf("Dog", "Snails", "Fox", "Horse", "Zebra")
            )
        }
    }

}
