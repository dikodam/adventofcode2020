fun String.characterSequence() =
    this.chunkedSequence(1) { it[0] }

fun String.digitSequence() =
    this.characterSequence()
        .map { it.toInt() }

fun String.intSequence() =
    this.lineSequence().map { it.toInt() }





