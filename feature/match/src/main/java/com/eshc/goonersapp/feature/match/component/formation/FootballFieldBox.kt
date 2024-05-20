package com.eshc.goonersapp.feature.match.component.formation

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.eshc.goonersapp.core.designsystem.theme.BrushMainGradient
import com.eshc.goonersapp.core.designsystem.theme.Color88FFFFFF

@Composable
fun FootballFieldBox(
    modifier: Modifier = Modifier,
    rotateDegree : Float = 0f
) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .clip(RoundedCornerShape(10.dp))
            .background(BrushMainGradient)
            .rotate(rotateDegree),
        contentAlignment = Alignment.Center
    ) {
        Canvas(
            modifier = modifier
        ) {
            drawArc(
                color = Color88FFFFFF,
                startAngle = 0f,
                sweepAngle = 180f,
                useCenter = false,
                style = Stroke(width = 3f),
                size = Size(width = size.width * 0.3f, height = size.height * 0.3f),
                topLeft = Offset(size.width * 0.35f, (size.height * 0.15f) * -1f)
            )
            drawLine(
                color = Color88FFFFFF,
                start = Offset(0f, 0f),
                end = Offset(0f, size.height),
                strokeWidth = 3f
            )
            drawLine(
                color = Color88FFFFFF,
                start = Offset(0f, size.height),
                end = Offset(size.width, size.height),
                strokeWidth = 3f
            )
            drawLine(
                color = Color88FFFFFF,
                start = Offset(size.width, size.height),
                end = Offset(size.width, 0f),
                strokeWidth = 3f
            )
            drawLine(
                color = Color88FFFFFF,
                start = Offset(size.width, 0f),
                end = Offset(0f, 0f),
                strokeWidth = 3f
            )
            drawLine(
                color = Color88FFFFFF,
                start = Offset(size.width * 0.3f, size.height),
                end = Offset(size.width * 0.3f, size.height * 0.84f),
                strokeWidth = 3f
            )
            drawLine(
                color = Color88FFFFFF,
                start = Offset(size.width * 0.3f, size.height * 0.84f),
                end = Offset(size.width * 0.7f, size.height * 0.84f),
                strokeWidth = 3f
            )
            drawLine(
                color = Color88FFFFFF,
                start = Offset(size.width * 0.7f, size.height * 0.84f),
                end = Offset(size.width * 0.7f, size.height),
                strokeWidth = 3f
            )
            drawLine(
                color = Color88FFFFFF,
                start = Offset(size.width * 0.4f, size.height),
                end = Offset(size.width * 0.4f, size.height * 0.9f),
                strokeWidth = 3f
            )
            drawLine(
                color = Color88FFFFFF,
                start = Offset(size.width * 0.4f, size.height * 0.9f),
                end = Offset(size.width * 0.6f, size.height * 0.9f),
                strokeWidth = 3f
            )
            drawLine(
                color = Color88FFFFFF,
                start = Offset(size.width * 0.6f, size.height * 0.9f),
                end = Offset(size.width * 0.6f, size.height),
                strokeWidth = 3f
            )
        }

    }

}

@Preview
@Composable
fun PreviewFormationBox(){
    FootballFieldBox()
}