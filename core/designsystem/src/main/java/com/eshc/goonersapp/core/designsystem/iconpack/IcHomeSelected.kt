package com.eshc.goonersapp.core.designsystem.iconpack

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathFillType.Companion.NonZero
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap.Companion.Butt
import androidx.compose.ui.graphics.StrokeJoin.Companion.Miter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.ImageVector.Builder
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp
import com.eshc.goonersapp.core.designsystem.IconPack

public val IconPack.IcHomeSelected: ImageVector
    get() {
        if (_icHomeSelected != null) {
            return _icHomeSelected!!
        }
        _icHomeSelected = Builder(name = "IcHomeSelected", defaultWidth = 512.0.dp, defaultHeight =
                512.0.dp, viewportWidth = 512.0f, viewportHeight = 512.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = SolidColor(Color(0x00000000)),
                    strokeLineWidth = 0.0f, strokeLineCap = Butt, strokeLineJoin = Miter,
                    strokeLineMiter = 4.0f, pathFillType = NonZero) {
                moveTo(244.3f, 1.5f)
                curveToRelative(-13.0f, 3.6f, -9.4f, 0.3f, -124.6f, 115.3f)
                curveToRelative(-59.8f, 59.8f, -110.1f, 110.7f, -111.7f, 113.1f)
                curveToRelative(-12.4f, 18.5f, -9.9f, 43.3f, 5.9f, 59.2f)
                curveToRelative(9.2f, 9.1f, 20.9f, 13.9f, 34.3f, 13.9f)
                lineToRelative(6.8f, -0.0f)
                lineToRelative(0.0f, 80.0f)
                curveToRelative(0.0f, 54.1f, 0.4f, 81.6f, 1.1f, 85.2f)
                curveToRelative(3.8f, 18.2f, 18.5f, 34.7f, 36.7f, 41.0f)
                curveToRelative(6.6f, 2.3f, 7.1f, 2.3f, 55.4f, 2.3f)
                curveToRelative(47.6f, -0.0f, 48.7f, -0.0f, 51.4f, -2.1f)
                curveToRelative(1.5f, -1.1f, 3.7f, -3.3f, 4.8f, -4.8f)
                curveToRelative(2.1f, -2.7f, 2.1f, -4.0f, 2.6f, -69.5f)
                lineToRelative(0.5f, -66.8f)
                lineToRelative(3.0f, -4.9f)
                curveToRelative(3.8f, -6.1f, 11.5f, -11.0f, 18.9f, -11.9f)
                curveToRelative(2.8f, -0.4f, 16.8f, -0.5f, 31.1f, -0.3f)
                lineToRelative(26.0f, 0.3f)
                lineToRelative(5.3f, 2.9f)
                curveToRelative(5.0f, 2.8f, 8.2f, 6.1f, 11.3f, 11.6f)
                curveToRelative(1.1f, 2.1f, 1.5f, 14.4f, 1.9f, 69.2f)
                curveToRelative(0.5f, 65.4f, 0.5f, 66.7f, 2.6f, 69.4f)
                curveToRelative(1.1f, 1.5f, 3.3f, 3.7f, 4.8f, 4.8f)
                curveToRelative(2.7f, 2.1f, 3.8f, 2.1f, 51.4f, 2.1f)
                curveToRelative(48.3f, -0.0f, 48.8f, -0.0f, 55.4f, -2.3f)
                curveToRelative(18.2f, -6.3f, 32.9f, -22.8f, 36.7f, -41.0f)
                curveToRelative(0.7f, -3.6f, 1.1f, -31.1f, 1.1f, -85.2f)
                lineToRelative(0.0f, -80.0f)
                lineToRelative(6.8f, -0.0f)
                curveToRelative(24.0f, -0.0f, 43.4f, -16.3f, 47.4f, -39.8f)
                curveToRelative(1.5f, -9.2f, 0.0f, -19.0f, -4.3f, -28.2f)
                curveToRelative(-2.9f, -6.0f, -11.6f, -15.0f, -111.8f, -115.3f)
                curveToRelative(-59.7f, -59.8f, -110.7f, -110.1f, -113.3f, -111.8f)
                curveToRelative(-2.6f, -1.7f, -7.1f, -4.0f, -10.0f, -5.1f)
                curveToRelative(-7.0f, -2.7f, -20.4f, -3.3f, -27.5f, -1.3f)
                close()
            }
        }
        .build()
        return _icHomeSelected!!
    }

private var _icHomeSelected: ImageVector? = null
