package com.eshc.goonersapp.core.designsystem.iconpack

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathFillType
import androidx.compose.ui.graphics.PathFillType.Companion.NonZero
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap.Companion.Butt
import androidx.compose.ui.graphics.StrokeCap.Companion.Round
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.StrokeJoin.Companion.Miter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.ImageVector.Builder
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp
import com.eshc.goonersapp.core.designsystem.IconPack

public val IconPack.IcInfo: ImageVector
    get() {
        if (_icInfo != null) {
            return _icInfo!!
        }
        _icInfo = Builder(name = "IcInfo", defaultWidth = 800.0.dp, defaultHeight = 800.0.dp,
                viewportWidth = 25.0f, viewportHeight = 25.0f).apply {
            path(fill = SolidColor(Color(0x00000000)), stroke = SolidColor(Color(0xFF000000)),
                    strokeLineWidth = 1.5f, strokeLineCap = Round, strokeLineJoin =
                    StrokeJoin.Companion.Round, strokeLineMiter = 4.0f, pathFillType = NonZero) {
                moveTo(12.5f, 21.5f)
                curveTo(17.6086f, 21.5f, 21.75f, 17.3586f, 21.75f, 12.25f)
                curveTo(21.75f, 7.1414f, 17.6086f, 3.0f, 12.5f, 3.0f)
                curveTo(7.3914f, 3.0f, 3.25f, 7.1414f, 3.25f, 12.25f)
                curveTo(3.25f, 17.3586f, 7.3914f, 21.5f, 12.5f, 21.5f)
                close()
            }
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(13.4309f, 8.1501f)
                curveTo(13.4256f, 8.3923f, 13.325f, 8.6227f, 13.1509f, 8.7912f)
                curveTo(12.9767f, 8.9597f, 12.7431f, 9.0527f, 12.5008f, 9.05f)
                curveTo(12.3242f, 9.0441f, 12.1533f, 8.9864f, 12.0093f, 8.884f)
                curveTo(11.8652f, 8.7816f, 11.7546f, 8.639f, 11.6911f, 8.4741f)
                curveTo(11.6275f, 8.3093f, 11.6139f, 8.1293f, 11.652f, 7.9567f)
                curveTo(11.69f, 7.7842f, 11.778f, 7.6267f, 11.905f, 7.5038f)
                curveTo(12.032f, 7.3809f, 12.1923f, 7.2981f, 12.366f, 7.2658f)
                curveTo(12.5397f, 7.2334f, 12.7192f, 7.2529f, 12.8819f, 7.3218f)
                curveTo(13.0446f, 7.3907f, 13.1834f, 7.506f, 13.281f, 7.6533f)
                curveTo(13.3787f, 7.8006f, 13.4308f, 7.9734f, 13.4309f, 8.1501f)
                close()
                moveTo(11.7909f, 16.5301f)
                lineTo(11.7909f, 11.1501f)
                curveTo(11.7882f, 11.0556f, 11.8046f, 10.9615f, 11.8392f, 10.8736f)
                curveTo(11.8738f, 10.7857f, 11.9258f, 10.7057f, 11.9922f, 10.6385f)
                curveTo(12.0585f, 10.5712f, 12.1378f, 10.518f, 12.2252f, 10.4822f)
                curveTo(12.3126f, 10.4464f, 12.4064f, 10.4286f, 12.5008f, 10.43f)
                curveTo(12.594f, 10.4299f, 12.6863f, 10.4487f, 12.772f, 10.4853f)
                curveTo(12.8577f, 10.5218f, 12.9352f, 10.5753f, 12.9997f, 10.6426f)
                curveTo(13.0642f, 10.7099f, 13.1143f, 10.7895f, 13.1472f, 10.8767f)
                curveTo(13.1801f, 10.9639f, 13.1949f, 11.0569f, 13.1908f, 11.1501f)
                lineTo(13.1908f, 16.5301f)
                curveTo(13.1908f, 16.622f, 13.1727f, 16.713f, 13.1376f, 16.7979f)
                curveTo(13.1024f, 16.8828f, 13.0508f, 16.96f, 12.9858f, 17.025f)
                curveTo(12.9208f, 17.09f, 12.8437f, 17.1415f, 12.7588f, 17.1767f)
                curveTo(12.6738f, 17.2119f, 12.5828f, 17.23f, 12.4909f, 17.23f)
                curveTo(12.399f, 17.23f, 12.3079f, 17.2119f, 12.223f, 17.1767f)
                curveTo(12.1381f, 17.1415f, 12.0609f, 17.09f, 11.9959f, 17.025f)
                curveTo(11.9309f, 16.96f, 11.8793f, 16.8828f, 11.8442f, 16.7979f)
                curveTo(11.809f, 16.713f, 11.7909f, 16.622f, 11.7909f, 16.5301f)
                close()
            }
        }
        .build()
        return _icInfo!!
    }

private var _icInfo: ImageVector? = null
