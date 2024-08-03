package com.example.repos.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.ExperimentalMaterial3Api
import com.example.repos.presentation.details.DetailsScreen
import com.example.repos.presentation.details.components.RepoDetails
import com.example.repos.ui.theme.ReposAppTheme

class MainActivity : ComponentActivity() {
    @ExperimentalMaterial3Api
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ReposAppTheme {
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




