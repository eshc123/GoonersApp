package com.eshc.goonersapp.core.designsystem.iconpack

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathFillType
import androidx.compose.ui.graphics.PathFillType.Companion.NonZero
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.StrokeCap.Companion.Round
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.ImageVector.Builder
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp
import com.eshc.goonersapp.core.designsystem.IconPack

public val IconPack.IcGrid: ImageVector
    get() {
        if (_icGrid != null) {
            return _icGrid!!
        }
        _icGrid = Builder(name = "IcGrid", defaultWidth = 800.0.dp, defaultHeight = 800.0.dp,
                viewportWidth = 24.0f, viewportHeight = 24.0f).apply {
            path(fill = SolidColor(Color(0x00000000)), stroke = SolidColor(Color(0xFF000000)),
                    strokeLineWidth = 2.0f, strokeLineCap = Round, strokeLineJoin =
                    StrokeJoin.Companion.Round, strokeLineMiter = 4.0f, pathFillType = NonZero) {
                moveTo(14.0f, 5.6f)
                curveTo(14.0f, 5.0399f, 14.0f, 4.7599f, 14.109f, 4.546f)
                curveTo(14.2049f, 4.3579f, 14.3578f, 4.2049f, 14.546f, 4.109f)
                curveTo(14.7599f, 4.0f, 15.0399f, 4.0f, 15.6f, 4.0f)
                horizontalLineTo(18.4f)
                curveTo(18.9601f, 4.0f, 19.2401f, 4.0f, 19.454f, 4.109f)
                curveTo(19.6422f, 4.2049f, 19.7951f, 4.3579f, 19.891f, 4.546f)
                curveTo(20.0f, 4.7599f, 20.0f, 5.0399f, 20.0f, 5.6f)
                verticalLineTo(8.4f)
                curveTo(20.0f, 8.96f, 20.0f, 9.2401f, 19.891f, 9.454f)
                curveTo(19.7951f, 9.6421f, 19.6422f, 9.7951f, 19.454f, 9.891f)
                curveTo(19.2401f, 10.0f, 18.9601f, 10.0f, 18.4f, 10.0f)
                horizontalLineTo(15.6f)
                curveTo(15.0399f, 10.0f, 14.7599f, 10.0f, 14.546f, 9.891f)
                curveTo(14.3578f, 9.7951f, 14.2049f, 9.6421f, 14.109f, 9.454f)
                curveTo(14.0f, 9.2401f, 14.0f, 8.96f, 14.0f, 8.4f)
                verticalLineTo(5.6f)
                close()
            }
            path(fill = SolidColor(Color(0x00000000)), stroke = SolidColor(Color(0xFF000000)),
                    strokeLineWidth = 2.0f, strokeLineCap = Round, strokeLineJoin =
                    StrokeJoin.Companion.Round, strokeLineMiter = 4.0f, pathFillType = NonZero) {
                moveTo(4.0f, 5.6f)
                curveTo(4.0f, 5.0399f, 4.0f, 4.7599f, 4.109f, 4.546f)
                curveTo(4.2049f, 4.3579f, 4.3579f, 4.2049f, 4.546f, 4.109f)
                curveTo(4.7599f, 4.0f, 5.0399f, 4.0f, 5.6f, 4.0f)
                horizontalLineTo(8.4f)
                curveTo(8.96f, 4.0f, 9.2401f, 4.0f, 9.454f, 4.109f)
                curveTo(9.6421f, 4.2049f, 9.7951f, 4.3579f, 9.891f, 4.546f)
                curveTo(10.0f, 4.7599f, 10.0f, 5.0399f, 10.0f, 5.6f)
                verticalLineTo(8.4f)
                curveTo(10.0f, 8.96f, 10.0f, 9.2401f, 9.891f, 9.454f)
                curveTo(9.7951f, 9.6421f, 9.6421f, 9.7951f, 9.454f, 9.891f)
                curveTo(9.2401f, 10.0f, 8.96f, 10.0f, 8.4f, 10.0f)
                horizontalLineTo(5.6f)
                curveTo(5.0399f, 10.0f, 4.7599f, 10.0f, 4.546f, 9.891f)
                curveTo(4.3579f, 9.7951f, 4.2049f, 9.6421f, 4.109f, 9.454f)
                curveTo(4.0f, 9.2401f, 4.0f, 8.96f, 4.0f, 8.4f)
                verticalLineTo(5.6f)
                close()
            }
            path(fill = SolidColor(Color(0x00000000)), stroke = SolidColor(Color(0xFF000000)),
                    strokeLineWidth = 2.0f, strokeLineCap = Round, strokeLineJoin =
                    StrokeJoin.Companion.Round, strokeLineMiter = 4.0f, pathFillType = NonZero) {
                moveTo(4.0f, 15.6f)
                curveTo(4.0f, 15.0399f, 4.0f, 14.7599f, 4.109f, 14.546f)
                curveTo(4.2049f, 14.3578f, 4.3579f, 14.2049f, 4.546f, 14.109f)
                curveTo(4.7599f, 14.0f, 5.0399f, 14.0f, 5.6f, 14.0f)
                horizontalLineTo(8.4f)
                curveTo(8.96f, 14.0f, 9.2401f, 14.0f, 9.454f, 14.109f)
                curveTo(9.6421f, 14.2049f, 9.7951f, 14.3578f, 9.891f, 14.546f)
                curveTo(10.0f, 14.7599f, 10.0f, 15.0399f, 10.0f, 15.6f)
                verticalLineTo(18.4f)
                curveTo(10.0f, 18.9601f, 10.0f, 19.2401f, 9.891f, 19.454f)
                curveTo(9.7951f, 19.6422f, 9.6421f, 19.7951f, 9.454f, 19.891f)
                curveTo(9.2401f, 20.0f, 8.96f, 20.0f, 8.4f, 20.0f)
                horizontalLineTo(5.6f)
                curveTo(5.0399f, 20.0f, 4.7599f, 20.0f, 4.546f, 19.891f)
                curveTo(4.3579f, 19.7951f, 4.2049f, 19.6422f, 4.109f, 19.454f)
                curveTo(4.0f, 19.2401f, 4.0f, 18.9601f, 4.0f, 18.4f)
                verticalLineTo(15.6f)
                close()
            }
            path(fill = SolidColor(Color(0x00000000)), stroke = SolidColor(Color(0xFF000000)),
                    strokeLineWidth = 2.0f, strokeLineCap = Round, strokeLineJoin =
                    StrokeJoin.Companion.Round, strokeLineMiter = 4.0f, pathFillType = NonZero) {
                moveTo(14.0f, 15.6f)
                curveTo(14.0f, 15.0399f, 14.0f, 14.7599f, 14.109f, 14.546f)
                curveTo(14.2049f, 14.3578f, 14.3578f, 14.2049f, 14.546f, 14.109f)
                curveTo(14.7599f, 14.0f, 15.0399f, 14.0f, 15.6f, 14.0f)
                horizontalLineTo(18.4f)
                curveTo(18.9601f, 14.0f, 19.2401f, 14.0f, 19.454f, 14.109f)
                curveTo(19.6422f, 14.2049f, 19.7951f, 14.3578f, 19.891f, 14.546f)
                curveTo(20.0f, 14.7599f, 20.0f, 15.0399f, 20.0f, 15.6f)
                verticalLineTo(18.4f)
                curveTo(20.0f, 18.9601f, 20.0f, 19.2401f, 19.891f, 19.454f)
                curveTo(19.7951f, 19.6422f, 19.6422f, 19.7951f, 19.454f, 19.891f)
                curveTo(19.2401f, 20.0f, 18.9601f, 20.0f, 18.4f, 20.0f)
                horizontalLineTo(15.6f)
                curveTo(15.0399f, 20.0f, 14.7599f, 20.0f, 14.546f, 19.891f)
                curveTo(14.3578f, 19.7951f, 14.2049f, 19.6422f, 14.109f, 19.454f)
                curveTo(14.0f, 19.2401f, 14.0f, 18.9601f, 14.0f, 18.4f)
                verticalLineTo(15.6f)
                close()
            }
        }
        .build()
        return _icGrid!!
    }

private var _icGrid: ImageVector? = null
