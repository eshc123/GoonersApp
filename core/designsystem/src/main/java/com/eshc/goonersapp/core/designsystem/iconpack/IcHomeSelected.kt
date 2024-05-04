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
        _icHomeSelected = Builder(name = "IcHomeSelected", defaultWidth = 26.0.dp, defaultHeight =
                26.0.dp, viewportWidth = 26.0f, viewportHeight = 26.0f).apply {
            path(fill = SolidColor(Color(0xFF181818)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
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
                horizontalLineTo(17.8667f)
                curveTo(17.4228f, 26.0f, 17.0507f, 25.863f, 16.7504f, 25.5891f)
                curveTo(16.4502f, 25.3151f, 16.3f, 24.9757f, 16.3f, 24.5708f)
                verticalLineTo(16.8468f)
                curveTo(16.3f, 16.4418f, 16.1499f, 16.1024f, 15.8496f, 15.8284f)
                curveTo(15.5493f, 15.5545f, 15.1772f, 15.4175f, 14.7333f, 15.4175f)
                horizontalLineTo(11.2667f)
                curveTo(10.8228f, 15.4175f, 10.4507f, 15.5545f, 10.1504f, 15.8284f)
                curveTo(9.8501f, 16.1024f, 9.7f, 16.4418f, 9.7f, 16.8468f)
                verticalLineTo(24.5708f)
                curveTo(9.7f, 24.9757f, 9.5498f, 25.3151f, 9.2496f, 25.5891f)
                curveTo(8.9493f, 25.863f, 8.5772f, 26.0f, 8.1334f, 26.0f)
                horizontalLineTo(2.6f)
                curveTo(1.8911f, 26.0f, 1.2806f, 25.7664f, 0.7683f, 25.2991f)
                curveTo(0.2561f, 24.8318f, 0.0f, 24.2748f, 0.0f, 23.6281f)
                close()
            }
        }
        .build()
        return _icHomeSelected!!
    }

private var _icHomeSelected: ImageVector? = null
