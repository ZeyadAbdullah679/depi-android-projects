package com.example.repos.presentation.issues

import AppBar
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.repos.R
import com.example.repos.ui.theme.ReposAppTheme

@ExperimentalMaterial3Api
@Composable
fun IssuesScreen(
    modifier: Modifier = Modifier,
    onBackClick: () -> Unit
) {
    Scaffold(
        modifier = modifier,
        topBar = {
            AppBar(
                title = stringResource(id = R.string.issues_screen),
                onBackArrowClicked = onBackClick
            )
        }
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier.padding(innerPadding)
        ) {

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