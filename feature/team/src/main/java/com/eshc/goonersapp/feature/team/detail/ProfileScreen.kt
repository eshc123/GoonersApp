package com.eshc.goonersapp.feature.team.detail

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.eshc.goonersapp.core.common.util.DateUtil
import com.eshc.goonersapp.core.common.util.DateUtil.getYearAndMonthAndDateString
import com.eshc.goonersapp.core.designsystem.theme.ColorFF000000
import com.eshc.goonersapp.core.designsystem.theme.ColorFF181818
import com.eshc.goonersapp.core.designsystem.theme.ColorFF777777
import com.eshc.goonersapp.core.designsystem.theme.ColorFFDCDCDC
import com.eshc.goonersapp.core.designsystem.theme.GnrTypography
import com.eshc.goonersapp.core.domain.model.player.Player
import com.eshc.goonersapp.feature.team.R

@Composable
fun ProfileScreen(
    player : Player,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.fillMaxSize().padding(horizontal = 15.dp, vertical = 20.dp)
    ) {
        ProfileContent(
            title = stringResource(id = R.string.player_detail_profile_date_of_birth),
            description = getYearAndMonthAndDateString(player.birthDate),
            modifier = Modifier.fillMaxWidth()
        )
        ProfileContent(
            title = stringResource(id = R.string.player_detail_profile_height),
            description = "${player.height}cm",
            modifier = Modifier.fillMaxWidth()
        )
        ProfileContent(
            title = stringResource(id = R.string.player_detail_profile_weight),
            description = "${player.weight}kg",
            modifier = Modifier.fillMaxWidth()
        )
        ProfileContent(
            title = stringResource(id = R.string.player_detail_profile_nationality),
            description =  "Bosnia and Herzegovina",
            modifier = Modifier.fillMaxWidth()
        )
        ProfileContent(
            title = stringResource(id = R.string.player_detail_profile_position),
            description = player.position,
            modifier = Modifier.fillMaxWidth()
        )
    }
}

@Composable
fun ColumnScope.ProfileContent(
    title : String,
    description : String,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier.padding(horizontal = 15.dp, vertical = 14.dp)
    ) {
        Text(
            modifier = Modifier.width(128.dp),
            text = title,
            style = GnrTypography.body1Regular,
            color = ColorFF777777
        )
        Text(
            text = description,
            style = GnrTypography.body1Medium,
            color = ColorFF000000
        )
    }
    HorizontalDivider(
        modifier = modifier,
        color = ColorFFDCDCDC,
        thickness = 1.dp
    )
}
