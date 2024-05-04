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

public val IconPack.IcArrowDown: ImageVector
    get() {
        if (_icArrowDown != null) {
            return _icArrowDown!!
        }
        _icArrowDown = Builder(name = "IcArrowDown", defaultWidth = 14.0.dp, defaultHeight = 8.0.dp,
                viewportWidth = 14.0f, viewportHeight = 8.0f).apply {
            path(fill = SolidColor(Color(0xFF9E9E9E)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(13.7394f, 1.5981f)
                lineTo(7.8906f, 7.6024f)
                curveTo(7.7562f, 7.7404f, 7.6172f, 7.8412f, 7.4737f, 7.9047f)
                curveTo(7.3301f, 7.9682f, 7.1722f, 8.0f, 7.0f, 8.0f)
                curveTo(6.8278f, 8.0f, 6.6699f, 7.9682f, 6.5263f, 7.9047f)
                curveTo(6.3828f, 7.8412f, 6.2438f, 7.7404f, 6.1094f, 7.6024f)
                lineTo(0.2602f, 1.5978f)
                curveTo(0.1796f, 1.5149f, 0.116f, 1.4224f, 0.0696f, 1.3203f)
                curveTo(0.0232f, 1.2181f, -0.0f, 1.1087f, -0.0f, 0.9919f)
                curveTo(-0.0f, 0.7584f, 0.0769f, 0.5556f, 0.2307f, 0.3833f)
                curveTo(0.3845f, 0.2111f, 0.5872f, 0.125f, 0.8389f, 0.125f)
                lineTo(13.1611f, 0.125f)
                curveTo(13.4128f, 0.125f, 13.6155f, 0.2119f, 13.7693f, 0.3858f)
                curveTo(13.9231f, 0.5597f, 14.0f, 0.7626f, 14.0f, 0.9945f)
                curveTo(14.0f, 1.0524f, 13.9131f, 1.2537f, 13.7394f, 1.5981f)
                close()
            }
        }
        .build()
        return _icArrowDown!!
    }

private var _icArrowDown: ImageVector? = null
