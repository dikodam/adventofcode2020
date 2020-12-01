fun String.asDigits() =
    this.chunked(1) { (it as String).toInt() }

fun String.asInts() =
    this.split("\n").map { it.toInt() }


