package de.dikodam.day02

data class Policy(val minCount: Int, val maxCount: Int, val character: Char) {
    fun validate(password: String): Boolean {
        val charCount = password.countCharacter(character)
        return charCount in minCount..maxCount
    }

    private fun String.countCharacter(character: Char) =
        this.toCharArray()
            .asSequence()
            .filter { it == character }
            .count()


}