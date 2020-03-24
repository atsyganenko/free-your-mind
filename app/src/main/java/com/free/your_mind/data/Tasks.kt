package com.free.your_mind.data

class Tasks {

    companion object {
        val challenges = mapOf(
            14 to Task("Make a poem", "You have to make a poem"),
            15 to Task("Draw a pic", "You have to draw a pic"),
            16 to Task("Draw a pic", "You have to draw a pic")
        )

        data class Task(val name: String, val description: String)
    }
}