package com.eshc.goonersapp.core.designsystem.iconpack

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathFillType.Companion.NonZero
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap.Companion.Round
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.ImageVector.Builder
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp
import com.eshc.goonersapp.core.designsystem.IconPack

public val IconPack.IcSearch: ImageVector
    get() {
        if (_icSearch != null) {
            return _icSearch!!
        }
        _icSearch = Builder(name = "IcSearch", defaultWidth = 800.0.dp, defaultHeight = 800.0.dp,
                viewportWidth = 24.0f, viewportHeight = 24.0f).apply {
            path(fill = SolidColor(Color(0x00000000)), stroke = SolidColor(Color(0xFF000000)),
                    strokeLineWidth = 2.0f, strokeLineCap = Round, strokeLineJoin =
                    StrokeJoin.Companion.Round, strokeLineMiter = 4.0f, pathFillType = NonZero) {
                moveTo(16.6725f, 16.6412f)
                lineTo(21.0f, 21.0f)
                moveTo(19.0f, 11.0f)
                curveTo(19.0f, 15.4183f, 15.4183f, 19.0f, 11.0f, 19.0f)
                curveTo(6.5817f, 19.0f, 3.0f, 15.4183f, 3.0f, 11.0f)
                curveTo(3.0f, 6.5817f, 6.5817f, 3.0f, 11.0f, 3.0f)
                curveTo(15.4183f, 3.0f, 19.0f, 6.5817f, 19.0f, 11.0f)
                close()
            }
        }
        .build()
        return _icSearch!!
    }

private var _icSearch: ImageVector? = null
