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

public val IconPack.IcPerson: ImageVector
    get() {
        if (_icPerson != null) {
            return _icPerson!!
        }
        _icPerson = Builder(name = "IcPerson", defaultWidth = 800.0.dp, defaultHeight = 800.0.dp,
                viewportWidth = 32.0f, viewportHeight = 32.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(16.0f, 15.503f)
                arcTo(5.041f, 5.041f, 0.0f, true, false, 16.0f, 5.42f)
                arcToRelative(5.041f, 5.041f, 0.0f, false, false, 0.0f, 10.083f)
                close()
                moveTo(16.0f, 17.718f)
                curveToRelative(-6.703f, 0.0f, -11.0f, 3.699f, -11.0f, 5.5f)
                verticalLineToRelative(3.363f)
                horizontalLineToRelative(22.0f)
                verticalLineToRelative(-3.363f)
                curveToRelative(0.0f, -2.178f, -4.068f, -5.5f, -11.0f, -5.5f)
                close()
            }
        }
        .build()
        return _icPerson!!
    }

private var _icPerson: ImageVector? = null
