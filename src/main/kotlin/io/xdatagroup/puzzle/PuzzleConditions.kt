package io.xdatagroup.puzzle

import kotlinx.serialization.Serializable

@Serializable
data class PuzzleConditions(
    val houseColors: List<String>,
    val nationalities: List<String>,
    val drinks: List<String>,
    val cigars: List<String>,
    val pets: List<String>
) {
    init {
        require(houseColors.size == 5) { "Exactly 5 house colors are required" }
        require(nationalities.size == 5) { "Exactly 5 nationalities are required" }
        require(drinks.size == 5) { "Exactly 5 drinks are required" }
        require(cigars.size == 5) { "Exactly 5 cigars are required" }
        require(pets.size == 5) { "Exactly 5 pets are required" }
    }
}
