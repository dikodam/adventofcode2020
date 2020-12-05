package de.dikodam.day05

import characterSequence
import firstHalf
import secondHalf

data class BoardingPass(val row: Int, val column: Int) {
    fun computeSeatId() = row * 8 + column

    companion object {
        fun fromString(boardingPassString: String): BoardingPass {

            val row = boardingPassString
                .characterSequence()
                .take(7)
                .fold(0..127, ::narrowRowRange)
                .first

            val column = boardingPassString
                .characterSequence()
                .drop(7)
                .fold(0..7, ::narrowColumnRange)
                .first

            return BoardingPass(row, column)
        }

        fun narrowRowRange(range: IntRange, rowChar: Char) =
            when (rowChar) {
                'F' -> range.firstHalf()
                'B' -> range.secondHalf()
                else -> error("wtf is $rowChar")
            }

        fun narrowColumnRange(range: IntRange, columnChar: Char) =
            when (columnChar) {
                'L' -> range.firstHalf()
                'R' -> range.secondHalf()
                else -> error("wtf is $columnChar")
            }
    }
}

