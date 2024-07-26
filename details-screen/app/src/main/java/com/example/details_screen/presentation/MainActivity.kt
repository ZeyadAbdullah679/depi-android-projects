package com.example.details_screen.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.details_screen.presentation.details.DetailsScreen
import com.example.details_screen.presentation.details.components.RepoDetails
import com.example.details_screen.ui.theme.DetailsScreenTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DetailsScreenTheme {
                DetailsScreen(
                    repoDetails = RepoDetails(
                        name = "Jetpack Compose",
                        imageUrl = "https://tabris.com/wp-content/uploads/2021/06/jetpack-compose-icon_RGB.png",
                        language = "Kotlin",
                        forksCount = 100,
                        starsCount = 1000,
                        description = "Jetpack Compose is Android's modern toolkit for building native user interfaces. It simplifies and accelerates UI development on Android with less code, powerful tools, and intuitive Kotlin APIs.",
                    ),
                    onClickBack = { finish() },
                    onClickViewIssues = {}
                )
            }
        }
    }
}




