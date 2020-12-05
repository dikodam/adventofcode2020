import kotlin.math.ceil

fun String.characterSequence() =
    this.chunkedSequence(1) { it[0] }

fun String.digitSequence() =
    this.characterSequence()
        .map { it.toInt() }

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

