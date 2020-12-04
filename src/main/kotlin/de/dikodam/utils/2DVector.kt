package de.dikodam.utils

data class Vector2D(val x: Int, val y: Int) {
    operator fun plus(other: Vector2D) =
        Vector2D(this.x + other.x, this.y + other.y)

    operator fun minus(other: Vector2D) =
        Vector2D(this.x - other.x, this.y - other.y)
}