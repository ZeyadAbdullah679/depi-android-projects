package com.example.repos.presentation.issues

import AppBar
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.repos.R
import com.example.repos.presentation.issues.components.IssuesDetails
import com.example.repos.presentation.issues.components.IssuesItem
import com.example.repos.ui.theme.ReposAppTheme
import java.time.LocalDateTime

@ExperimentalMaterial3Api
@Composable
fun IssuesScreen(
    modifier: Modifier = Modifier,
    onBackClick: () -> Unit
) {
    Scaffold(
        containerColor = Color.Gray.copy(alpha = 0.05f),
        modifier = modifier,
        topBar = {
            AppBar(
                title = stringResource(id = R.string.issues_screen),
                onBackArrowClicked = onBackClick,
                backgroundColor = Color.White
            )
        }
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier.padding(innerPadding),
            contentPadding = PaddingValues(4.dp)
        ) {
            items(mockData()) {
                IssuesItem(
                    modifier = Modifier.padding(4.dp),
                    issuesDetails = it
                )
            }
        }
    }
}

@ExperimentalMaterial3Api
@Preview
@Composable
private fun IssuesScreenPreview() {
    ReposAppTheme {
        IssuesScreen(
            onBackClick = {}
        )
    }
}

fun mockData(): List<IssuesDetails> = listOf(
    IssuesDetails(
        title = "fix going to have in the hell of cheese",
        author = "NONE",
        status = "Open",
        creationTime = LocalDateTime.now()
    ),
    IssuesDetails(
        title = "fix going to have in the hell of cheese",
        author = "NONE",
        status = "Open",
        creationTime = LocalDateTime.now()
    ),
    IssuesDetails(
        title = "fix going to have in the hell of cheese",
        author = "NONE",
        status = "Open",
        creationTime = LocalDateTime.now()
    ),
    IssuesDetails(
        title = "fix going to have in the hell of cheese",
        author = "NONE",
        status = "Open",
        creationTime = LocalDateTime.now()
    ),
    IssuesDetails(
        title = "fix going to have in the hell of cheese",
        author = "NONE",
        status = "Open",
        creationTime = LocalDateTime.now()
    ),
    IssuesDetails(
        title = "fix going to have in the hell of cheese",
        author = "NONE",
        status = "Open",
        creationTime = LocalDateTime.now()
    ),
    IssuesDetails(
        title = "fix going to have in the hell of cheese",
        author = "NONE",
        status = "Open",
        creationTime = LocalDateTime.now()
    ),
    IssuesDetails(
        title = "fix going to have in the hell of cheese",
        author = "NONE",
        status = "Open",
        creationTime = LocalDateTime.now()
    ),
    IssuesDetails(
        title = "fix going to have in the hell of cheese",
        author = "NONE",
        status = "Open",
        creationTime = LocalDateTime.now()
    ),
    IssuesDetails(
        title = "fix going to have in the hell of cheese",
        author = "NONE",
        status = "Open",
        creationTime = LocalDateTime.now()
    ),
    IssuesDetails(
        title = "fix going to have in the hell of cheese",
        author = "NONE",
        status = "Open",
        creationTime = LocalDateTime.now()
    ),
    IssuesDetails(
        title = "fix going to have in the hell of cheese",
        author = "NONE",
        status = "Open",
        creationTime = LocalDateTime.now()
    )
)