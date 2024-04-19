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

public val IconPack.IcHomeUnselected: ImageVector
    get() {
        if (_icHomeUnselected != null) {
            return _icHomeUnselected!!
        }
        _icHomeUnselected = Builder(name = "IcHomeUnselected", defaultWidth = 26.0.dp, defaultHeight
                = 26.0.dp, viewportWidth = 26.0f, viewportHeight = 26.0f).apply {
            path(fill = SolidColor(Color(0xFF888888)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(2.6f, 23.6281f)
                horizontalLineTo(8.4f)
                verticalLineTo(15.6608f)
                curveTo(8.4f, 15.2559f, 8.5502f, 14.9164f, 8.8504f, 14.6425f)
                curveTo(9.1507f, 14.3686f, 9.5228f, 14.2316f, 9.9667f, 14.2316f)
                horizontalLineTo(16.0333f)
                curveTo(16.4772f, 14.2316f, 16.8493f, 14.3686f, 17.1496f, 14.6425f)
                curveTo(17.4498f, 14.9164f, 17.6f, 15.2559f, 17.6f, 15.6608f)
                verticalLineTo(23.6281f)
                horizontalLineTo(23.4f)
                verticalLineTo(9.6397f)
                curveTo(23.4f, 9.5587f, 23.3806f, 9.4852f, 23.3417f, 9.4193f)
                curveTo(23.3028f, 9.3534f, 23.25f, 9.2951f, 23.1834f, 9.2444f)
                lineTo(13.3167f, 2.4783f)
                curveTo(13.2278f, 2.4074f, 13.1222f, 2.3719f, 13.0f, 2.3719f)
                curveTo(12.8778f, 2.3719f, 12.7722f, 2.4074f, 12.6833f, 2.4783f)
                lineTo(2.8166f, 9.2444f)
                curveTo(2.75f, 9.2951f, 2.6972f, 9.3534f, 2.6583f, 9.4193f)
                curveTo(2.6194f, 9.4852f, 2.6f, 9.5587f, 2.6f, 9.6397f)
                verticalLineTo(23.6281f)
                close()
                moveTo(0.0f, 23.6281f)
                verticalLineTo(9.6397f)
                curveTo(0.0f, 9.1872f, 0.111f, 8.7584f, 0.3329f, 8.3534f)
                curveTo(0.5549f, 7.9485f, 0.8617f, 7.615f, 1.2533f, 7.353f)
                lineTo(11.12f, 0.5717f)
                curveTo(11.6676f, 0.1906f, 12.2933f, 0.0f, 12.9973f, 0.0f)
                curveTo(13.7013f, 0.0f, 14.3289f, 0.1906f, 14.88f, 0.5717f)
                lineTo(24.7467f, 7.353f)
                curveTo(25.1383f, 7.615f, 25.4451f, 7.9485f, 25.6671f, 8.3534f)
                curveTo(25.889f, 8.7584f, 26.0f, 9.1872f, 26.0f, 9.6397f)
                verticalLineTo(23.6281f)
                curveTo(26.0f, 24.2748f, 25.7439f, 24.8318f, 25.2317f, 25.2991f)
                curveTo(24.7194f, 25.7664f, 24.1089f, 26.0f, 23.4f, 26.0f)
                horizontalLineTo(16.5667f)
                curveTo(16.1228f, 26.0f, 15.7507f, 25.863f, 15.4504f, 25.5891f)
                curveTo(15.1501f, 25.3151f, 15.0f, 24.9757f, 15.0f, 24.5708f)
                verticalLineTo(16.6034f)
                horizontalLineTo(11.0f)
                verticalLineTo(24.5708f)
                curveTo(11.0f, 24.9757f, 10.8498f, 25.3151f, 10.5496f, 25.5891f)
                curveTo(10.2493f, 25.863f, 9.8772f, 26.0f, 9.4333f, 26.0f)
                horizontalLineTo(2.6f)
                curveTo(1.8911f, 26.0f, 1.2806f, 25.7664f, 0.7683f, 25.2991f)
                curveTo(0.2561f, 24.8318f, 0.0f, 24.2748f, 0.0f, 23.6281f)
                close()
            }
        }
        .build()
        return _icHomeUnselected!!
    }

private var _icHomeUnselected: ImageVector? = null
