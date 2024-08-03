package com.example.repos.presentation.details

import AppBar
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.SubcomposeAsyncImage
import com.example.repos.R
import com.example.repos.presentation.details.components.DetailsItem
import com.example.repos.presentation.details.components.RepoDetails
import com.example.repos.ui.theme.ReposAppTheme

@ExperimentalMaterial3Api
@Composable
fun DetailsScreen(
    repoDetails: RepoDetails,
    onClickBack: () -> Unit,
    onClickViewIssues: () -> Unit,
    modifier: Modifier = Modifier
) {
    Scaffold(modifier = modifier.fillMaxSize(),
        topBar = {
            AppBar(
                title = stringResource(id = R.string.details_screen),
                onBackArrowClicked = onClickBack
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            SubcomposeAsyncImage(
                model = repoDetails.imageUrl,
                loading = {
                    CircularProgressIndicator()
                },
                contentDescription = null,
                modifier = Modifier.size(200.dp)
            )
            Text(
                text = repoDetails.name,
                style = MaterialTheme.typography.headlineSmall,
                overflow = TextOverflow.Ellipsis,
                maxLines = 1
            )
            Row(
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically,
            ) {
                DetailsItem(
                    value = repoDetails.starsCount.toString(),
                    image = R.drawable.star,
                    modifier = Modifier.weight(1f)
                )
                DetailsItem(
                    value = repoDetails.language,
                    image = R.drawable.blue_circle,
                    modifier = Modifier.weight(1f)
                )
                DetailsItem(
                    value = repoDetails.forksCount.toString(),
                    image = R.drawable.git,
                    modifier = Modifier.weight(1f)
                )
            }
            Text(
                text = repoDetails.description,
                overflow = TextOverflow.Ellipsis,
                style = MaterialTheme.typography.bodyLarge,
            )
            Spacer(modifier = Modifier.weight(1f))
            Button(
                onClick = onClickViewIssues,
                shape = MaterialTheme.shapes.small,
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Blue
                ),
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Text(
                    text = "View Issues",
                    style = MaterialTheme.typography.bodyLarge.copy(
                        fontWeight = FontWeight.Bold
                    )
                )
            }
        }
    }
}


@ExperimentalMaterial3Api
@Preview(showBackground = true)
@Composable
fun DetailsScreenPreview() {
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
            onClickBack = {},
            onClickViewIssues = {}
        )
    }
}
