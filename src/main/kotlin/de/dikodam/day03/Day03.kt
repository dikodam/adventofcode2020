package de.dikodam.day03

import characters
import de.dikodam.AbstractDay
import de.dikodam.day03.Spot.TREE
import de.dikodam.utils.Vector2D

fun main() {
    Day03()()
}

class Day03 : AbstractDay() {
    override fun task1(): String {
        val slope = Vector2D(3, 1)
        val treeCount = traverseGridWithSlope(grid, slope)
        return "$treeCount"
    }

    fun traverseGridWithSlope(gridToTraverse: List<List<Spot>>, slope: Vector2D): Int {
        var position = Vector2D(0, 0)
        var treeCount = 0

        do {
            val (x, y) = position
            val line = gridToTraverse[y]
            val currentSpot = line[x % line.size]
            if (currentSpot == TREE) {
                treeCount++
            }
            position += slope
        } while (position.y < gridToTraverse.size)
        return treeCount
    }

    override fun task2(): String {

        val slopes = listOf(Vector2D(1, 1), Vector2D(3, 1), Vector2D(5, 1), Vector2D(7, 1), Vector2D(1, 2))

        val treeCollisions = slopes.map { slope -> traverseGridWithSlope(grid, slope) }

        val productOfTreeCollisions = treeCollisions.reduce(Int::times)

        return "$productOfTreeCollisions"
    }

    private val grid by lazy {
        input
            .lineSequence()
            .map { line -> line.characters().map { it.asSpot() }.toList() }
            .toList()
    }

    private val input = """.#.......#...........#.........
..##.......#.#.#.....##...#....
.......#..#.....#...#..........
...#..........###...#........##
#.#..#.#.##.#........#.#.....#.
#..#....#..#....#..............
#..#........#..................
..#.#...#.#...#....#.#.#..#....
..............#..#.............
.##....#...................#...
........#..........#......#...#
.##..#..#...##..........#...#..
.#...#....#.........#...#.....#
.#........##............#.#....
...........#..............##...
.#..#......#..#..............#.
..#.#.#...........#........#...
..###..........#....#.#......#.
.......#...##..........#.......
........#...#..................
....#....#..#.......#........#.
.......##.#......#.....#...##..
..#.#........................#.
.#.....#.##..............#.#...
..#.#...#.#..#....#....#.......
.#....##.....#....#........#...
..#...........#.##....#...#....
..#.##...#....#.#.....##...#...
.......#...####...#...#.......#
.#...#.........................
.......................#.......
.....#.#.........#..........#.#
#.........#............###..#..
.....#.#.............###.......
...#..#........#.#.......#.....
...................#....#......
...#..#...#............#..##...
...#.....#....#.......##......#
.....#....#...##..#..#...#...#.
..........#...........#.#.#....
..#.......#...#.....#......#...
.........#.......##......#..#.#
..#.....#..#.###...#.#......#..
#....#...#..#...#.....#........
..#......#..#.......#.#.....#..
#......#...#......#.....##.#...
........##.......#.......#.....
.#.#...............#...........
..............#...#.#....#.....
....#......#.#..#......#.......
...##....#....#...#............
.#...............#...........#.
.#.#...#.#.....#.....#...#.#...
...##...........#.....#..#...#.
.#.#...##.#.#......#......#....
.##.....#.......##....#.#.#....
.......#...........#....#....#.
....#...........#......#.####..
......#....#...#...##.......#..
......................#.#####..
..#...#.#...#..#..#......#.....
....#........##.......##....#..
#.#......##.........##.#..#...#
.#.#....#...#..#...#...##....#.
.....##...#....#....#.#........
......#..#....#.#...#..........
.........#...................#.
............#.###....#.#.......
...#.#.....#......#....#.#..#..
..............#..#.#.#.#.......
#..##...................##.....
..#.......#..#.........##..#...
.........##...#......#........#
..#.........#........##.###.#..
...........#.#....#.....###....
..#....##.#..#.##....#.....##..
..#.....#.##..................#
#....#.........................
..............#..#...#.#.......
......#..#.#.##....#..........#
..#.........#.####.....#.......
......#..#.#..........#...#....
......#.................#..#.#.
.....#..........#..............
....#.....#............#....##.
.....#.....#........#..........
............#.....#...#........
........#....#.#...............
#.....#.........#......#..#.#..
...#..#......#......#.......#..
.....#......#.#....#..#...#...#
......................#..##....
.............#.........###....#
#..............#.#..........##.
...#.#.................##......
...........#.#.....#...........
.........#.................#.#.
........#........#...#..##...#.
........#......##.......###....
..............#.#.#............
.#.....###...##.#......#.....#.
.............#......#.#.#...#.#
..#.........#.......#.....#....
......#........#...##......#...
.##..........##......#.#.....#.
..#.##....#....#...............
......#...#..#.....#.....#...#.
.......##..##..#............##.
..............#...##........#..
#....#................#..#.....
........#.......#.#.#...#......
......#.......#..............#.
#.#..#...#........#....#..####.
..#........#...........#.....#.
.##...........................#
.............#...........#.....
.#.....#.#...#.........#.......
..........#...#....#....#......
.#..#........##....#...........
.......###......##...#.........
..........#.#.#..#.#....#......
........##..#.........#....#...
........#.#......#.#...#.#..#..
....#....................#.##..
##....#..#...........#.....#.#.
...#..............##...##..#.#.
......#.##.#.......#..#...#....
....#..#..##.....#.....#.#....#
.......#....##.##..............
#..##....#.....#.#.............
..................#......#..#..
..#......#...#..#.......#...#..
...........#....#.#.....#......
#..#...##.........###..#......#
.......#......................#
#.......#....................#.
..#..#..........#..#..#....#...
.##..#..#.....#.#..##..........
#..###.......#..##..#...#..#.#.
.....##......###.....#.#.##...#
..............#...#....#.#.....
#...........#..................
..............#....#..##..#..#.
.........#.............#.......
.#.#....#....#...............##
.##.##.#.....###.....#.........
....#..............##......#...
....#........##................
....#.....#....#....##....##...
.#........#......#......#......
....#..........#...............
##..........#......#.....#.....
........#.#..#.#..#.....##.....
..##......#.#.......#.#..#.....
.#.......#......#...........#..
..#.#..#.#..................#..
...#...#...#...##......#.......
.#...##....#...#...#...#.......
.......#.#.......#.............
.#.##.#.....#...........#.##.#.
.#.##.#........#...##..........
.#.....#.....#....#..#.........
...##.............##...........
.#........##.....#.......#...#.
...........#..#..##........##..
.....#..#......................
..#.......#....................
.....#......#....#....#.......#
........#..#.#.....#......#....
..........#..#.....#......#....
..........#####.....#........#.
........#..#...#.#....#......#.
.........#...#....#.#..........
......#....##..........#...#...
#..............###.#.#.........
.#.#............##......#.#..#.
......#........................
...#..#......#.......#....#...#
.......#....##.....#.#......##.
...........#..........#..#.....
...........#..#.....###......#.
.......#....#..##......#.......
.........#.#.#.......#..#...#..
.......#.......##.....##...#...
..............#....#.....#.....
...#....#.....#.#..........##..
###.........#.............#....
...##......#.#........#....#..#
#....###.......#...#.#......##.
....#...##.......#......#.....#
.....#......#..................
#........##....#....#.#........
........#.......###...#........
........#..#.......###.........
..............#......#..#......
#......#.....#....#.#..........
.#......##.#.#.....#...#.#....#
.##...........#..#.##.....#....
.....#.....................#...
.#..#...#...##.#...#...........
.......#.......##..#.#..#......
.......##.....#.....#..........
.................#.............
#........#..#.......##.........
#...#..###.#..#....#.#.###.....
..#.......#.......#.......#....
..............#............##..
.#...#..#...##.........#....#..
#...........#...#..............
.......#.....#......#..#.....#.
..........#......#.............
##.........###..##.#....#..#.#.
..............###..............
#..##.............##.....#.....
....##...................#..#..
....#.....#..............#..#.#
........#........##...#.....##.
#...........#.##..........##...
#......##.....#...............#
..##..#....#.................#.
#.......##.....................
...............#.##..##......#.
..#.##..#.#....#.......##......
......##....#............##....
.#..#..##.....#.##....#........
#.........#..........#...#....#
...#.......#.............#.#.#.
..##............#...##........#
.......#.#.#........#..........
.....#.............#.....#.....
.........#.........#.........#.
#.....#....#.......#...........
.........#....#.............#.#
.##..#.......#...#......#......
....#....#....#........#....#..
............#.......#..#......#
.#............#.##........##...
..#...##...#....#...#.#...#..#.
#...#..........#..##.........#.
..#.........................#.#
...........#.........#..#.##...
.#..................#..#.......
......#......#...........#..#..
...##.....#.....#..#.......#...
.........#.#.......#......#....
...........#................#..
.....#...#..#............##....
.#.......#..#....#..........#..
#.....#..#.....#..##.......##..
...#.......#...#....#...#.#..##
...#...##......#....#....#.....
.......###.#..#.......#......#.
........#.#...#..#..#...#....#.
....#.........##.#.....#.......
....#.........#..##........#...
..#...........#......#....#.##.
.....................#.........
...................##......#..#
......#.#.....##..##..........#
..#.##........#.#.#..........#.
.#.......#...##.#....#....#....
#.#......#..#..#.......#.......
.............#........#.......#
....#...#.....#........#...#...
..#..............##..#.........
..#.................#..#...##..
....#..#...#...................
......#.........##.#..#..#...##
........#..#....#.......#.#.##.
.#...#...........#..........#..
##.....#...#............##...#.
.##.....#...#..................
.#.......####.#..##.##.#......#
.............#...#..#..#.......
...#.##.........#.#....#.......
...........##...##....#....##..
........#......#...#...........
...........#..#...#....#.##....
..##....#..........#....#...#..
#....#.#.#.......#.#...........
......#............##..........
#.#.###..#....#.......#...#....
.#......##..#..#.#.........#..#
..#.........#........#....#....
......##.#.......##....#..#..##
.............#...#............#
......#......#...#.#.#.##.#....
#.#...#.##.....#..............#
..........#.............##.##..
#......#....#...#.#.#.#..#....#
........#........#...#.#......#
.....#...........#.............
...........#....#..........#...
....####...#..##....#.#........
.#......#...#..#...........#...
#......###..#.##.###...........
..#...........#.........#....#.
................#.#....#..#.##.
...................#......#....
....#.#.....#.......#...###.##.
.#........#.#....#...#..#...#..
....#..###.................#..#
.....#.#..#........#......#..#.
....#.....#...............#...#
............##.#.........#..#..
.......#..#..##.#.#...##.......
..#..........##..#..#........#.
..............#..#...#.........
......#.#....#........##.......
.#.....##....#..#...#.......##.
..............#.##.............
#..#..#...##....##.#.....##.#..
..#...###..#.........##........
........##......#.....#..###...
.....#......##.###.............
....#.....#.#..#.#..#..........
....#..#.......#...........#...
.#.............#..#......##....
..#.#......#.#.................
.......#.#.#............#..#...
......###....##............#..#
.........#....#......#.........
..........#...............#..#."""

}