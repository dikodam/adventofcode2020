package de.dikodam

abstract class AbstractDay {
    fun executeTasks() {
        val day = this::class.simpleName
        println("The result of $day task 1 is: ${task1()}")
        println("The result of $day task 2 is: ${task2()}")

    }

    abstract fun task1(): String
    abstract fun task2(): String
}
