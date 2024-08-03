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
        shape = MaterialTheme.shapes.small,
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        )
    ) {
        Row(
            modifier = Modifier.padding(4.dp),
            verticalAlignment = Alignment.Top,
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            IssuesIcon()
            Column(
                modifier = Modifier.weight(1f),
                verticalArrangement = Arrangement.Center
            ) {
                Text(text = issuesDetails.title)
                Text(text = issuesDetails.author)
                Row {
                    Text(
                        text = stringResource(R.string.issues_screen_created_at)
                    )
                    Text(
                        text = issuesDetails.creationTime.format(
                            DateTimeFormatter.ofPattern("yyyy-MM-dd, HH:mm a")
                        )
                    )
                }
            }
            Text(text = issuesDetails.status)
        }
    }
}

@Preview
@Composable
private fun IssuesItemPreview() {
    ReposAppTheme {
        IssuesItem(
            issuesDetails = IssuesDetails(
                title = "title",
                author = "NONE",
                status = "Open",
                creationTime = LocalDateTime.now(),
            )
        )
    }
}