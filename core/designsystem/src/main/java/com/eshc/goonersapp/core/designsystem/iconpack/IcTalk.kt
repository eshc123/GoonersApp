package com.eshc.goonersapp.core.designsystem.iconpack

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathFillType
import androidx.compose.ui.graphics.PathFillType.Companion.NonZero
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.StrokeCap.Companion.Butt
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.StrokeJoin.Companion.Miter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.ImageVector.Builder
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp
import com.eshc.goonersapp.core.designsystem.IconPack

public val IconPack.IcTalk: ImageVector
    get() {
        if (_icTalk != null) {
            return _icTalk!!
        }
        _icTalk = Builder(name = "IcTalk", defaultWidth = 800.0.dp, defaultHeight = 800.0.dp,
                viewportWidth = 36.0f, viewportHeight = 36.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(23.0f, 26.0f)
                arcToRelative(1.0f, 1.0f, 0.0f, false, true, -1.0f, 1.0f)
                horizontalLineTo(8.0f)
                curveToRelative(-0.22f, 0.0f, -0.43f, 0.2f, -0.61f, 0.33f)
                lineTo(4.0f, 30.0f)
                verticalLineTo(14.0f)
                arcToRelative(1.0f, 1.0f, 0.0f, false, true, 1.0f, -1.0f)
                horizontalLineTo(8.86f)
                verticalLineTo(11.0f)
                horizontalLineTo(5.0f)
                arcToRelative(3.0f, 3.0f, 0.0f, false, false, -3.0f, 3.0f)
                verticalLineTo(32.0f)
                arcToRelative(1.0f, 1.0f, 0.0f, false, false, 0.56f, 0.89f)
                arcToRelative(1.0f, 1.0f, 0.0f, false, false, 1.0f, -0.1f)
                lineTo(8.71f, 29.0f)
                horizontalLineTo(22.15f)
                arcTo(2.77f, 2.77f, 0.0f, false, false, 25.0f, 26.13f)
                verticalLineTo(25.0f)
                horizontalLineTo(23.0f)
                close()
            }
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(31.0f, 4.0f)
                horizontalLineTo(14.0f)
                arcToRelative(3.0f, 3.0f, 0.0f, false, false, -3.0f, 3.0f)
                verticalLineTo(19.0f)
                arcToRelative(3.0f, 3.0f, 0.0f, false, false, 3.0f, 3.0f)
                horizontalLineTo(27.55f)
                lineToRelative(4.78f, 3.71f)
                arcToRelative(1.0f, 1.0f, 0.0f, false, false, 1.0f, 0.11f)
                arcToRelative(1.0f, 1.0f, 0.0f, false, false, 0.57f, -0.9f)
                verticalLineTo(7.0f)
                arcTo(3.0f, 3.0f, 0.0f, false, false, 31.0f, 4.0f)
                close()
                moveTo(32.0f, 22.94f)
                lineTo(28.5f, 20.21f)
                arcToRelative(1.0f, 1.0f, 0.0f, false, false, -0.61f, -0.21f)
                horizontalLineTo(14.0f)
                arcToRelative(1.0f, 1.0f, 0.0f, false, true, -1.0f, -1.0f)
                verticalLineTo(7.0f)
                arcToRelative(1.0f, 1.0f, 0.0f, false, true, 1.0f, -1.0f)
                horizontalLineTo(31.0f)
                arcTo(1.1f, 1.1f, 0.0f, false, true, 32.0f, 7.06f)
                close()
            }
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, fillAlpha = 0.0f,
                    strokeLineWidth = 0.0f, strokeLineCap = Butt, strokeLineJoin = Miter,
                    strokeLineMiter = 4.0f, pathFillType = NonZero) {
                moveTo(0.0f, 0.0f)
                horizontalLineToRelative(36.0f)
                verticalLineToRelative(36.0f)
                horizontalLineToRelative(-36.0f)
                close()
            }
        }
        .build()
        return _icTalk!!
    }

private var _icTalk: ImageVector? = null
