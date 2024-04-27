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

public val IconPack.IcArrowRight: ImageVector
    get() {
        if (_vector != null) {
            return _vector!!
        }
        _vector = Builder(name = "Vector", defaultWidth = 5.0.dp, defaultHeight = 9.0.dp,
                viewportWidth = 5.0f, viewportHeight = 9.0f).apply {
            path(fill = SolidColor(Color(0xFF9E9E9E)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(3.39035f, 4.44097f)
                lineTo(0.12893f, 0.81845f)
                curveTo(0.0429f, 0.72288f, 9.9E-4f, 0.61036f, 0.00321f, 0.48089f)
                curveTo(0.00543f, 0.35142f, 0.04956f, 0.2389f, 0.1356f, 0.14334f)
                curveTo(0.22163f, 0.04778f, 0.32293f, -1.0E-5f, 0.4395f, -1.0E-5f)
                curveTo(0.55607f, -1.0E-5f, 0.65737f, 0.04778f, 0.7434f, 0.14334f)
                lineTo(4.06477f, 3.82505f)
                curveTo(4.14304f, 3.91198f, 4.20105f, 4.00939f, 4.23879f, 4.11728f)
                curveTo(4.27654f, 4.22518f, 4.29541f, 4.33308f, 4.29541f, 4.44097f)
                curveTo(4.29541f, 4.54886f, 4.27654f, 4.65676f, 4.23879f, 4.76466f)
                curveTo(4.20105f, 4.87255f, 4.14304f, 4.96996f, 4.06477f, 5.05689f)
                lineTo(0.7434f, 8.74599f)
                curveTo(0.65737f, 8.84156f, 0.55496f, 8.88811f, 0.43617f, 8.88565f)
                curveTo(0.31738f, 8.88318f, 0.21497f, 8.83416f, 0.12893f, 8.7386f)
                curveTo(0.04289f, 8.64304f, -1.2E-4f, 8.53052f, -1.2E-4f, 8.40105f)
                curveTo(-1.2E-4f, 8.27158f, 0.04289f, 8.15906f, 0.12893f, 8.06349f)
                lineTo(3.39035f, 4.44097f)
                close()
            }
        }
        .build()
        return _vector!!
    }

private var _vector: ImageVector? = null
