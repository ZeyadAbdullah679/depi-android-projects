package com.example.repos.presentation.issues.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
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
import com.example.repos.R
import com.example.repos.ui.theme.ReposAppTheme
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

@Composable
fun IssuesItem(
    modifier: Modifier = Modifier,
    issuesDetails: IssuesDetails
) {
    Card(
        modifier = modifier
            .fillMaxWidth(),
        shape = MaterialTheme.shapes.medium,
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 2.dp
        )
    ) {
        Column(
            modifier = Modifier.padding(8.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp),
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                IssuesIcon()
                Text(
                    text = issuesDetails.title,
                    style = MaterialTheme.typography.titleLarge.copy(
                        fontWeight = FontWeight.SemiBold,
                    ),
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    modifier = Modifier.weight(1f)
                )
                Text(
                    text = issuesDetails.status,
                    style = MaterialTheme.typography.bodyLarge
                )
            }
            Column(
                modifier = Modifier.padding(start = 32.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Text(
                    text = issuesDetails.author,
                    style = MaterialTheme.typography.bodyLarge
                )
                Row {
                    Text(
                        text = stringResource(R.string.issues_screen_created_at),
                        style = MaterialTheme.typography.bodyMedium.copy(
                            fontWeight = FontWeight.ExtraBold
                        )
                    )
                    Text(
                        text = issuesDetails.creationTime.format(
                            DateTimeFormatter.ofPattern("yyyy-MM-dd, HH:mm a")
                        ),
                        style = MaterialTheme.typography.bodyMedium
                    )
                }
            }

        }
    }
}

@Preview
@Composable
private fun IssuesItemPreview() {
    ReposAppTheme {
        IssuesItem(
            issuesDetails = IssuesDetails(
                title = "fix going to have in the hell of cheese",
                author = "NONE",
                status = "Open",
                creationTime = LocalDateTime.now(),
            )
        )
    }
}