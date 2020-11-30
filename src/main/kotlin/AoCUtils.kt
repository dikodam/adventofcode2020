fun String.asDigits() = this.chunked(1) { (it as String).toInt() }
