package com.eshc.goonersapp.core.designsystem

import androidx.compose.ui.graphics.vector.ImageVector
import com.eshc.goonersapp.core.designsystem.iconpack.IcFootballClub
import com.eshc.goonersapp.core.designsystem.iconpack.IcPerson
import com.eshc.goonersapp.core.designsystem.iconpack.IcSearch
import kotlin.collections.List as ____KtList

public object IconPack

private var __Icons: ____KtList<ImageVector>? = null

public val IconPack.Icons: ____KtList<ImageVector>
  get() {
    if (__Icons != null) {
      return __Icons!!
    }
    __Icons= listOf(IcFootballClub, IcPerson, IcSearch)
    return __Icons!!
  }
