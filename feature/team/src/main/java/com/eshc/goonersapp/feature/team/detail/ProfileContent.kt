package com.eshc.goonersapp.feature.team.detail

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.eshc.goonersapp.core.common.util.DateUtil.getYearAndMonthAndDateString
import com.eshc.goonersapp.core.designsystem.theme.ColorFF000000
import com.eshc.goonersapp.core.designsystem.theme.ColorFF777777
import com.eshc.goonersapp.core.designsystem.theme.ColorFFDCDCDC
import com.eshc.goonersapp.core.designsystem.theme.GnrTypography
import com.eshc.goonersapp.core.domain.model.player.Player
import com.eshc.goonersapp.feature.team.R

@Composable
fun ProfileContent(
    player: Player,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .padding(horizontal = 15.dp, vertical = 20.dp)
    ) {
        Text(
            modifier = Modifier.padding(vertical = 10.dp),
            text = "Detailed Profile",
            style = GnrTypography.subtitleSemiBold,
            color = ColorFF000000
        )
        ProfileContentItem(
            title = stringResource(id = R.string.player_detail_profile_date_of_birth),
            description = getYearAndMonthAndDateString(player.birthDate),
            modifier = Modifier.fillMaxWidth()
        )
        ProfileContentItem(
            title = stringResource(id = R.string.player_detail_profile_height),
            description = "${player.height}cm",
            modifier = Modifier.fillMaxWidth()
        )
        ProfileContentItem(
            title = stringResource(id = R.string.player_detail_profile_weight),
            description = "${player.weight}kg",
            modifier = Modifier.fillMaxWidth()
        )
        ProfileContentItem(
            title = stringResource(id = R.string.player_detail_profile_nationality),
            description = player.nationality,
            modifier = Modifier.fillMaxWidth()
        )
        ProfileContentItem(
            title = stringResource(id = R.string.player_detail_profile_position),
            description = player.position,
            modifier = Modifier.fillMaxWidth()
        )
    }
}

@Composable
fun ColumnScope.ProfileContentItem(
    title: String,
    description: String,
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
