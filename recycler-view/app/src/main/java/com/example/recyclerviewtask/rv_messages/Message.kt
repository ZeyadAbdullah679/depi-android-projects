package com.example.recyclerviewtask.rv_messages

import java.time.LocalTime
import java.time.format.DateTimeFormatter

data class Message(
    val name: String,
    val content: String,
    val time: String = LocalTime.now().format(
        DateTimeFormatter.ofPattern("HH:mm a")
    ),
    val isSender: Boolean
)
