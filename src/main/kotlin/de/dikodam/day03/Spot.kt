package de.dikodam.day03

enum class Spot {
    TREE, FREE_SPOT;

}

fun Char.asSpot() =
    when {
        (this == '#') -> Spot.TREE
        (this == '.') -> Spot.FREE_SPOT
        else -> throw IllegalArgumentException()
    }
