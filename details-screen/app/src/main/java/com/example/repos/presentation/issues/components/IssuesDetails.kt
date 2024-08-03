package com.example.repos.presentation.issues.components

import java.time.LocalDateTime

data class IssuesDetails(
    val title: String,
    val status: String,
    val author: String,
    val creationTime: LocalDateTime
)
