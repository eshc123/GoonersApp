package com.eshc.goonersapp.core.designsystem

import androidx.compose.ui.graphics.vector.ImageVector
import com.eshc.goonersapp.core.designsystem.iconpack.IcCalendarSelected
import com.eshc.goonersapp.core.designsystem.iconpack.IcCalendarUnselected
import com.eshc.goonersapp.core.designsystem.iconpack.IcHomeSelected
import com.eshc.goonersapp.core.designsystem.iconpack.IcHomeUnselected
import com.eshc.goonersapp.core.designsystem.iconpack.IcTeamSelected
import com.eshc.goonersapp.core.designsystem.iconpack.IcTeamUnselected
import kotlin.collections.List as ____KtList

public object IconPack

private var __Icons: ____KtList<ImageVector>? = null

public val IconPack.Icons: ____KtList<ImageVector>
  get() {
    if (__Icons != null) {
      return __Icons!!
    }
    __Icons= listOf(IcCalendarSelected, IcHomeSelected, IcTeamSelected, IcCalendarUnselected,
        IcTeamUnselected, IcHomeUnselected)
    return __Icons!!
  }
