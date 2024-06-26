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

public val IconPack.IcIosArrowBack: ImageVector
    get() {
        if (_iciosarrowback != null) {
            return _iciosarrowback!!
        }
        _iciosarrowback = Builder(name = "IcIosArrowBack", defaultWidth = 10.0.dp, defaultHeight =
                18.0.dp, viewportWidth = 10.0f, viewportHeight = 18.0f).apply {
            path(fill = SolidColor(Color(0xFF181818)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(1.4564f, 9.0014f)
                lineTo(9.1754f, 16.7206f)
                curveTo(9.323f, 16.868f, 9.3959f, 17.0444f, 9.394f, 17.2496f)
                curveTo(9.392f, 17.4549f, 9.3173f, 17.6312f, 9.1697f, 17.7786f)
                curveTo(9.0223f, 17.9262f, 8.846f, 18.0f, 8.6407f, 18.0f)
                curveTo(8.4354f, 18.0f, 8.2591f, 17.9262f, 8.1117f, 17.7786f)
                lineTo(0.4655f, 10.1384f)
                curveTo(0.3039f, 9.9769f, 0.1859f, 9.7967f, 0.1116f, 9.5979f)
                curveTo(0.0372f, 9.399f, 0.0f, 9.2002f, 0.0f, 9.0014f)
                curveTo(0.0f, 8.8026f, 0.0372f, 8.6038f, 0.1116f, 8.4049f)
                curveTo(0.1859f, 8.2061f, 0.3039f, 8.0259f, 0.4655f, 7.8643f)
                lineTo(8.1117f, 0.2184f)
                curveTo(8.2591f, 0.0708f, 8.4364f, -0.002f, 8.6437f, 0.0f)
                curveTo(8.8508f, 0.0019f, 9.028f, 0.0766f, 9.1754f, 0.2241f)
                curveTo(9.323f, 0.3716f, 9.3968f, 0.5479f, 9.3968f, 0.7532f)
                curveTo(9.3968f, 0.9584f, 9.323f, 1.1348f, 9.1754f, 1.2822f)
                lineTo(1.4564f, 9.0014f)
                close()
            }
        }
        .build()
        return _iciosarrowback!!
    }

private var _iciosarrowback: ImageVector? = null
