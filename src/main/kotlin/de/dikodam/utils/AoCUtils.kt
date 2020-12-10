package de.dikodam.utils

fun String.digitSequence() =
    this.map { it.toInt() }

fun String.intSequence() =
    this.lineSequence().map { it.toInt() }

fun IntRange.firstHalf(): IntRange {
    val newWidth = (last + 1 - first) / 2
    val newLast = first - 1 + newWidth
    return first..newLast
}

fun IntRange.secondHalf(): IntRange {
    val newWidth = (last + 1 - first) / 2
    val newFirst = last + 1 - newWidth
    return newFirst..last
}

