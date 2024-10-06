package io.xdatagroup.puzzle

import kotlinx.serialization.Serializable

@Serializable
data class ZebraPuzzleSolution(
    val waterDrinker: String,
    val zebraOwner: String
) {
    init {
        require(waterDrinker.isNotBlank()) { "Water drinker cannot be blank" }
        require(zebraOwner.isNotBlank()) { "Zebra owner cannot be blank" }
    }

    override fun toString(): String {
        return "Water drinker: $waterDrinker, Zebra owner: $zebraOwner"
    }
}
