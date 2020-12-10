package de.dikodam.day02

data class Policy(val firstNumber: Int, val secondNumber: Int, val character: Char)

fun Policy.validateCharCount(password: String): Boolean {
    val charCount = password.countCharacter(character)
    return charCount in firstNumber..secondNumber
}

fun Policy.validatePositional(password: String): Boolean {
    return (password[firstNumber - 1] == character) xor (password[secondNumber - 1] == character)
}

private fun String.countCharacter(character: Char) =
    this.asSequence()
        .filter { it == character }
        .count()


