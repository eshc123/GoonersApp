package com.eshc.goonersapp.core.designsystem

import androidx.compose.ui.graphics.vector.ImageVector
import com.eshc.goonersapp.core.designsystem.iconpack.IcCalendarSelected
import com.eshc.goonersapp.core.designsystem.iconpack.IcCalendarUnselected
import com.eshc.goonersapp.core.designsystem.iconpack.IcHomeSelected
import com.eshc.goonersapp.core.designsystem.iconpack.IcHomeUnselected
import com.eshc.goonersapp.core.designsystem.iconpack.IcPlaygroundSelected
import com.eshc.goonersapp.core.designsystem.iconpack.IcPlaygroundUnselected
import com.eshc.goonersapp.core.designsystem.iconpack.IcTeamSelected
import com.eshc.goonersapp.core.designsystem.iconpack.IcTeamUnselected
import kotlin.collections.List as ____KtList

public object IconPack

private var __Icon: ____KtList<ImageVector>? = null

public val IconPack.Icon: ____KtList<ImageVector>
  get() {
    if (__Icon != null) {
      return __Icon!!
    }
    __Icon= listOf(IcTeamSelected,IcTeamUnselected,IcCalendarSelected,IcCalendarUnselected,IcHomeSelected, IcHomeUnselected, IcPlaygroundSelected, IcPlaygroundUnselected)
    return __Icon!!
  }
