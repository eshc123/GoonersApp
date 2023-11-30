package com.eshc.goonersapp.core.designsystem.shape

import androidx.compose.foundation.shape.CornerSize
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.geometry.RoundRect
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.geometry.toRect
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.PathOperation
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.LayoutDirection

class TicketShape(
    private val circleRadius: Dp,
    private val cornerSize: CornerSize,
    private val weight : Float = 2F
) : Shape {

    override fun createOutline(size: Size, layoutDirection: LayoutDirection, density: Density): Outline {
        return Outline.Generic(path = getPath(size, density))
    }

    private fun getPath(size: Size, density: Density): Path {
        val roundedRect = RoundRect(size.toRect(), CornerRadius(cornerSize.toPx(size, density)))
        val roundedRectPath = Path().apply { addRoundRect(roundedRect) }
        return Path.combine(operation = PathOperation.Intersect, path1 = roundedRectPath, path2 = getTicketPath(size, density))
    }

    private fun getTicketPath(size: Size, density: Density): Path {
        val circleStartY = size.height.times(weight.div(weight.plus(1)))
        val circleRadiusInPx = with(density) { circleRadius.toPx() }
        return Path().apply {
            reset()
            // Ensure we start drawing line at top left
            lineTo(x = 0F, y = 0F)
            // Draw line to top right
            lineTo(x = size.width, y = 0F)

            // Draw line to top middle
            lineTo(x = size.width, y = circleStartY)
            // Draw top cutout
            arcTo(
                rect = Rect(
                    left = size.width.minus(circleRadiusInPx),
                    top = circleStartY.minus(circleRadiusInPx),
                    right = size.width.plus(circleRadiusInPx),
                    bottom = circleStartY.plus(circleRadiusInPx)
                ),
                startAngleDegrees = 270F,
                sweepAngleDegrees = -180F,
                forceMoveTo = false
            )

            // Draw line to bottom right
            lineTo(x = size.width, y = size.height)
            // Draw line to bottom left
            lineTo(x = 0F, y = size.height)
            // Draw line to bottom middle
            lineTo(x = 0F, y = circleStartY)
            // Draw bottom cutout
            arcTo(
                rect = Rect(
                    left = 0F - circleRadiusInPx,
                    top = circleStartY.minus(circleRadiusInPx),
                    right = circleRadiusInPx,
                    bottom = circleStartY.plus(circleRadiusInPx)
                ),
                startAngleDegrees = 90F,
                sweepAngleDegrees = -180F,
                forceMoveTo = false
            )

            // Draw line back to top left
            lineTo(x = 0F, y = 0F)
        }
    }
}