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

public val IconPack.IcUser: ImageVector
    get() {
        if (_icUser != null) {
            return _icUser!!
        }
        _icUser = Builder(name = "IcUser", defaultWidth = 800.0.dp, defaultHeight = 800.0.dp,
                viewportWidth = 24.0f, viewportHeight = 24.0f).apply {
            path(fill = SolidColor(Color(0x00000000)), stroke = SolidColor(Color(0xFF000000)),
                    strokeLineWidth = 2.0f, strokeLineCap = Round, strokeLineJoin =
                    StrokeJoin.Companion.Round, strokeLineMiter = 4.0f, pathFillType = NonZero) {
                moveTo(5.0f, 21.0f)
                curveTo(5.0f, 17.134f, 8.134f, 14.0f, 12.0f, 14.0f)
                curveTo(15.866f, 14.0f, 19.0f, 17.134f, 19.0f, 21.0f)
                moveTo(16.0f, 7.0f)
                curveTo(16.0f, 9.2091f, 14.2091f, 11.0f, 12.0f, 11.0f)
                curveTo(9.7909f, 11.0f, 8.0f, 9.2091f, 8.0f, 7.0f)
                curveTo(8.0f, 4.7909f, 9.7909f, 3.0f, 12.0f, 3.0f)
                curveTo(14.2091f, 3.0f, 16.0f, 4.7909f, 16.0f, 7.0f)
                close()
            }
        }
        .build()
        return _icUser!!
    }

private var _icUser: ImageVector? = null
