package de.dikodam.day09

import de.dikodam.AbstractDay
import de.dikodam.utils.asLongSequence

fun main() {
    Day09()()
}

class Day09 : AbstractDay() {
    private val input = Day09Input().input.asLongSequence()

    override fun task1(): String {

        val (_, breakingXMASint) = input
            .windowed(size = 26, step = 1, partialWindows = false) { list -> list.take(25) to list.last() }
            .first { (preamble, next) -> !satisfiesXmasProperty(preamble, next) }

        return "$breakingXMASint"
    }

    fun satisfiesXmasProperty(preamble: List<Long>, next: Long) =
        preamble.any { element -> preamble.contains(next - element) }

    override fun task2(): String {
        val target = task1().toLong()
        val subranges = input.mapIndexed { index, _ -> input.drop(index) }

        val rawXmasBreakingSequence = subranges.map { subrange -> subrange.zip(subrange.runningReduce(Long::plus)) }
            .first { sequence -> sequence.any { (_, partSum) -> partSum == target } }

        val xmasBreakingSeq = rawXmasBreakingSequence.takeWhile { (_, partSum) -> partSum <= target }.map { it.first }
        val min: Long = xmasBreakingSeq.minOrNull() ?: 0L
        val max = xmasBreakingSeq.maxOrNull() ?: 0L
        return "${min + max}"
    }
}