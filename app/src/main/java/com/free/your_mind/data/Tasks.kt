package com.free.your_mind.data

class Tasks {

    companion object {
        val challenges = mapOf(
            18 to Task("Make a poem", "You have to make a poem"),
            19 to Task("Draw a pic", "You have to draw a pic"),
            20 to Task("Draw a pic", "You have to draw a pic")
        )

        data class Task(val name: String, val description: String)
    }
}