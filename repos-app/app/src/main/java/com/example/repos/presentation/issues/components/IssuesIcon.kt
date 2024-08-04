package com.example.repos.presentation.issues.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun IssuesIcon(modifier: Modifier = Modifier) {
    Canvas(modifier = modifier.size(24.dp)) {
        drawIssuesShape(
            size = size,
            dotCircleColor = Color.Black,
            innerCircleColor = Color.White,
            innerCircleRadiusFraction = 0.7f,
            outerCircleColor = Color.Black,
            outerCircleRadiusFraction = 0.3f
        )
    }

}

fun DrawScope.drawIssuesShape(
    size: Size,
    dotCircleColor: Color,
    innerCircleColor: Color,
    innerCircleRadiusFraction: Float,
    outerCircleColor: Color,
    outerCircleRadiusFraction: Float
) {
    val radius = size.minDimension / 2f
    val center = Offset(x = size.width / 2, y = size.height / 2)


    drawCircle(
        color = dotCircleColor,
        radius = radius,
        center = center
    )

    drawCircle(
        color = innerCircleColor,
        radius = radius * innerCircleRadiusFraction,
        center = center
    )

    drawCircle(
        color = outerCircleColor,
        radius = radius * outerCircleRadiusFraction,
        center = center
    )
}

@Preview(showBackground = true)
@Composable
fun PreviewDonutShape() {
    IssuesIcon()
}