package de.dikodam.utils

fun String.asIntSequence(): Sequence<Int> =
    this.lineSequence().map { it.toInt() }

fun String.asLongSequence(): Sequence<Long> =
    this.lineSequence().map { it.toLong() }

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

fun <T> List<T>.splitAfter(count: Int): Pair<List<T>, List<T>> =
    take(count) to drop(count)
