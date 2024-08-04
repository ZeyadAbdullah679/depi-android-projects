package com.example.repos.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.ExperimentalMaterial3Api
import com.example.repos.presentation.issues.IssuesScreen
import com.example.repos.ui.theme.ReposAppTheme

class MainActivity : ComponentActivity() {
    @ExperimentalMaterial3Api
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ReposAppTheme {
                IssuesScreen(
                    onBackClick = { finish() },
                )
            }
        }
    }
}




