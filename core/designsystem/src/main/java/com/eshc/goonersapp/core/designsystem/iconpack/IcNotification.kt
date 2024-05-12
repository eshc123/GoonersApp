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

public val IconPack.IcNotification: ImageVector
    get() {
        if (_notification != null) {
            return _notification!!
        }
        _notification = Builder(name = "Notification", defaultWidth = 23.0.dp, defaultHeight =
                26.0.dp, viewportWidth = 23.0f, viewportHeight = 26.0f).apply {
            path(fill = SolidColor(Color(0xFFBBBBBB)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(1.1197f, 22.1964f)
                curveTo(0.8024f, 22.1964f, 0.5365f, 22.099f, 0.3219f, 21.9042f)
                curveTo(0.1073f, 21.7094f, 0.0f, 21.468f, 0.0f, 21.18f)
                curveTo(0.0f, 20.892f, 0.1073f, 20.6507f, 0.3219f, 20.4562f)
                curveTo(0.5365f, 20.2617f, 0.8024f, 20.1644f, 1.1197f, 20.1644f)
                horizontalLineTo(2.6987f)
                verticalLineTo(10.0561f)
                curveTo(2.6987f, 8.2342f, 3.3183f, 6.6233f, 4.5576f, 5.2234f)
                curveTo(5.7969f, 3.8236f, 7.3878f, 2.9283f, 9.3305f, 2.5375f)
                verticalLineTo(1.6934f)
                curveTo(9.3305f, 1.223f, 9.5118f, 0.8232f, 9.8743f, 0.4939f)
                curveTo(10.2368f, 0.1646f, 10.677f, 0.0f, 11.1949f, 0.0f)
                curveTo(11.7128f, 0.0f, 12.1535f, 0.1646f, 12.5172f, 0.4939f)
                curveTo(12.8808f, 0.8232f, 13.0626f, 1.223f, 13.0626f, 1.6934f)
                verticalLineTo(2.5375f)
                curveTo(15.0053f, 2.9283f, 16.5963f, 3.8236f, 17.8356f, 5.2234f)
                curveTo(19.0748f, 6.6233f, 19.6945f, 8.2342f, 19.6945f, 10.0561f)
                verticalLineTo(20.1644f)
                horizontalLineTo(21.2735f)
                curveTo(21.5907f, 20.1644f, 21.8566f, 20.2618f, 22.0712f, 20.4566f)
                curveTo(22.2858f, 20.6514f, 22.3931f, 20.8929f, 22.3931f, 21.1808f)
                curveTo(22.3931f, 21.4689f, 22.2858f, 21.7101f, 22.0712f, 21.9046f)
                curveTo(21.8566f, 22.0991f, 21.5907f, 22.1964f, 21.2735f, 22.1964f)
                horizontalLineTo(1.1197f)
                close()
                moveTo(11.194f, 26.0f)
                curveTo(10.4512f, 26.0f, 9.8161f, 25.7602f, 9.2888f, 25.2806f)
                curveTo(8.7616f, 24.8011f, 8.4979f, 24.2246f, 8.4979f, 23.5511f)
                horizontalLineTo(13.8952f)
                curveTo(13.8952f, 24.2267f, 13.6307f, 24.8038f, 13.1017f, 25.2823f)
                curveTo(12.5728f, 25.7608f, 11.9369f, 26.0f, 11.194f, 26.0f)
                close()
                moveTo(4.9379f, 20.1644f)
                horizontalLineTo(17.4552f)
                verticalLineTo(10.0561f)
                curveTo(17.4552f, 8.4878f, 16.8442f, 7.1491f, 15.6221f, 6.0402f)
                curveTo(14.4001f, 4.9312f, 12.9249f, 4.3767f, 11.1966f, 4.3767f)
                curveTo(9.4683f, 4.3767f, 7.9931f, 4.9312f, 6.771f, 6.0402f)
                curveTo(5.549f, 7.1491f, 4.9379f, 8.4878f, 4.9379f, 10.0561f)
                verticalLineTo(20.1644f)
                close()
            }
        }
        .build()
        return _notification!!
    }

private var _notification: ImageVector? = null
