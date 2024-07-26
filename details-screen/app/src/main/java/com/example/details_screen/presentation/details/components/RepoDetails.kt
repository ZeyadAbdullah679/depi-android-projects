package com.example.details_screen.presentation.details.components

data class RepoDetails(
    val name: String,
    val description: String,
    val forksCount: Int,
    val starsCount: Int,
    val imageUrl: String,
    val language: String,
)
