fun String.characters() =
    this.chunkedSequence(1) { it[0] }

fun String.asDigits() =
    this.characters()
        .map { it.toInt() }

fun String.asInts() =
    this.lineSequence().map { it.toInt() }





