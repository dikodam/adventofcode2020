package de.dikodam.day17

import de.dikodam.AbstractDay

fun main() {
    Day17()()
}

data class Coordinates3D(val x: Int, val y: Int, val z: Int)
data class Coordinates4D(val w: Int, val x: Int, val y: Int, val z: Int)

private typealias GameState3D = Set<Coordinates3D>
private typealias GameState4D = Set<Coordinates4D>

class Day17 : AbstractDay() {
    override fun task1(): String {
        var gameState = parseInitialState3D(Day17Input().input.lines())

        println("initial count: ${gameState.count()}")

        repeat(6) { i ->
            gameState = computeNextState3D(gameState)
            println("count after round ${i + 1}: ${gameState.count()}")
        }

        return "${gameState.count()}"
    }

    fun parseInitialState3D(lines: List<String>): GameState3D {
        val interpretLine: (Int, String) -> List<Triple<Int, Int, Char>> =
            { xIndex, line -> line.mapIndexed { yIndex, char: Char -> Triple(xIndex, yIndex, char) } }

        return lines.flatMapIndexed(interpretLine)
            .filter { (_, _, c) -> c == '#' }
            .map { (x, y) -> Coordinates3D(x, y, 0) }
            .toSet()
    }

    fun computeNextState3D(state: GameState3D): GameState3D {
        return state.determinePotential3DCandidates()
            .filter { candidate -> determineNextLiveness(candidate, state) }
            .toSet()
    }

    fun GameState3D.determinePotential3DCandidates(): Set<Coordinates3D> =
        this.flatMap { determine3DNeighbors(it, includeSelf = true) }
            .toSet()

    fun determineNextLiveness(cube: Coordinates3D, state: GameState3D): Boolean {
        val livingNeighborsCount = determine3DNeighbors(cube, includeSelf = false)
            .filter { neighbor -> state.contains(neighbor) }
            .count()

        val isActive = state.contains(cube)
        return if (isActive) {
            livingNeighborsCount == 2 || livingNeighborsCount == 3
        } else {
            livingNeighborsCount == 3
        }
        // equivalent expression, but I find it harder to read:
        // return livingNeighborsCount == 3 || (livingNeighborsCount == 2 && state.contains(cube))
    }

    fun determine3DNeighbors(cube: Coordinates3D, includeSelf: Boolean = false): Set<Coordinates3D> {
        val accumulator = mutableListOf<Coordinates3D>()

        for (a in (cube.x - 1)..(cube.x + 1)) {
            for (b in (cube.y - 1)..(cube.y + 1)) {
                for (c in (cube.z - 1)..(cube.z + 1)) {
                    accumulator.add(Coordinates3D(a, b, c))
                }
            }
        }

        if (!includeSelf) {
            accumulator.remove(cube)
        }

        return accumulator.toSet()
    }


    override fun task2(): String {

        var gameState = parseInitialState4D(Day17Input().input.lines())

        println("initial count: ${gameState.count()}")

        repeat(6) { i ->
            gameState = computeNextState4D(gameState)
            println("count after round ${i + 1}: ${gameState.count()}")
        }

        return "${gameState.count()}"

    }


    fun parseInitialState4D(lines: List<String>): GameState4D {
        val interpretLine: (Int, String) -> List<Triple<Int, Int, Char>> =
            { xIndex, line -> line.mapIndexed { yIndex, char: Char -> Triple(xIndex, yIndex, char) } }

        return lines.flatMapIndexed(interpretLine)
            .filter { (_, _, c) -> c == '#' }
            .map { (x, y) -> Coordinates4D(x, y, 0, 0) }
            .toSet()
    }

    fun computeNextState4D(state: GameState4D): GameState4D {
        return state.determinePotential4DCandidates()
            .filter { candidate -> determineNextLiveness(candidate, state) }
            .toSet()
    }

    fun GameState4D.determinePotential4DCandidates(): Set<Coordinates4D> =
        this.flatMap { determine4DNeighbors(it, includeSelf = true) }
            .toSet()

    fun determine4DNeighbors(cube: Coordinates4D, includeSelf: Boolean = false): Set<Coordinates4D> {
        val accumulator = mutableListOf<Coordinates4D>()

        for (a in (cube.w - 1)..(cube.w + 1)) {
            for (b in (cube.x - 1)..(cube.x + 1)) {
                for (c in (cube.y - 1)..(cube.y + 1)) {
                    for (d in (cube.z - 1)..(cube.z + 1)) {
                        accumulator.add(Coordinates4D(a, b, c, d))
                    }
                }
            }
        }

        if (!includeSelf) {
            accumulator.remove(cube)
        }

        return accumulator.toSet()
    }

    fun determineNextLiveness(cube: Coordinates4D, state: GameState4D): Boolean {
        val livingNeighborsCount = determine4DNeighbors(cube, includeSelf = false)
            .filter { neighbor -> state.contains(neighbor) }
            .count()

        val isActive = state.contains(cube)
        return if (isActive) {
            livingNeighborsCount == 2 || livingNeighborsCount == 3
        } else {
            livingNeighborsCount == 3
        }
    }

}


