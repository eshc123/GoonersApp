package com.eshc.goonersapp.feature.team.club.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.eshc.goonersapp.core.designsystem.theme.ColorFF720509
import com.eshc.goonersapp.core.designsystem.theme.ColorFFC10006
import com.eshc.goonersapp.core.designsystem.theme.ColorFFFFFFFF
import com.eshc.goonersapp.core.designsystem.theme.GnrTypography
import com.eshc.goonersapp.feature.team.R

@Composable
fun ClubDetailImageView(
    clubImgUrl: String,
    clubName: String,
    clubFoundedYear: String,
    clubHomeTown: String,
    clubNation: String,
    clubNationImgUrl: String,
    clubStadium: String,
    clubCoachName: String,
    clubCaptainName: String,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .clip(RoundedCornerShape(bottomEnd = 30.dp, bottomStart = 30.dp))
            .background(
                Brush.verticalGradient(
                    listOf(
                        ColorFFC10006,
                        ColorFF720509
                    )
                )
            )
            .fillMaxWidth()
            .wrapContentHeight()
    ) {
        Column(
            modifier = Modifier.padding(15.dp),
            verticalArrangement = Arrangement.Top
        ) {
            Row(
                modifier = Modifier.padding(horizontal = 15.dp, vertical = 30.dp),
                horizontalArrangement = Arrangement.spacedBy(20.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                AsyncImage(
                    model = clubImgUrl,
                    modifier = Modifier.size(95.dp),
                    contentDescription = null
                )
                Column {
                    Text(
                        text = clubName,
                        style = GnrTypography.heading1SemiBold,
                        color = ColorFFFFFFFF
                    )
                    ClubLocation(
                        clubNationalityImgUrl = clubNationImgUrl,
                        clubLocation = "${clubHomeTown}, $clubNation"
                    )
                }
            }
            ClubInfoTextContent(
                establishDate = clubFoundedYear,
                hometown = clubHomeTown,
                stadium = clubStadium,
                coach = clubCoachName,
                captain = clubCaptainName,
                modifier = Modifier.padding(vertical = 15.dp)
            )
        }
    }
}

@Composable
fun ClubLocation(
    clubNationalityImgUrl: String,
    clubLocation: String
) {
    Row(
        horizontalArrangement = Arrangement.spacedBy(12.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        AsyncImage(
            model = clubNationalityImgUrl,
            modifier = Modifier
                .size(20.dp)
                .clip(CircleShape),
            contentDescription = "Flag",
            contentScale = ContentScale.Crop
        )
        Text(
            text = clubLocation,
            style = GnrTypography.body2Medium,
            color = ColorFFFFFFFF
        )
    }
}

@Composable
fun ClubInfoTextContent(
    establishDate: String,
    hometown: String,
    stadium: String,
    coach: String,
    captain: String,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(9.dp)
    ) {
        ClubInfoTextRow(
            infoTitle = stringResource(id = R.string.club_detail_establishment),
            infoContent = establishDate,
            modifier = Modifier.padding(horizontal = 15.dp)
        )
        HorizontalDivider(
            thickness = 1.dp,
            color = ColorFFFFFFFF.copy(alpha = 0.2f)
        )
        ClubInfoTextRow(
            infoTitle = stringResource(id = R.string.club_detail_hometown),
            infoContent = hometown,
            modifier = Modifier.padding(horizontal = 15.dp)
        )
        HorizontalDivider(
            thickness = 1.dp,
            color = ColorFFFFFFFF.copy(alpha = 0.2f)
        )
        ClubInfoTextRow(
            infoTitle = stringResource(id = R.string.club_detail_stadium),
            infoContent = stadium,
            modifier = Modifier.padding(horizontal = 15.dp)
        )
        HorizontalDivider(
            thickness = 1.dp,
            color = ColorFFFFFFFF.copy(alpha = 0.2f)
        )
        ClubInfoTextRow(
            infoTitle = stringResource(id = R.string.club_detail_coach),
            infoContent = coach,
            modifier = Modifier.padding(horizontal = 15.dp)
        )
        HorizontalDivider(
            thickness = 1.dp,
            color = ColorFFFFFFFF.copy(alpha = 0.2f)
        )
        ClubInfoTextRow(
            infoTitle = stringResource(id = R.string.club_detail_captain),
            infoContent = captain,
            modifier = Modifier.padding(horizontal = 15.dp)
        )
    }
}

@Composable
fun ClubInfoTextRow(
    infoTitle: String,
    infoContent: String,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Start,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = infoTitle,
            modifier = Modifier.weight(1f),
            style = GnrTypography.body1Regular,
            color = ColorFFFFFFFF.copy(alpha = 0.7f)
        )
        Text(
            text = infoContent,
            modifier = Modifier.weight(2f),
            style = GnrTypography.body1Regular,
            color = ColorFFFFFFFF
        )
    }
}

@Preview
@Composable
fun PreviewClubDetailImgView() {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        ClubDetailImageView(
            clubImgUrl = "",
            clubName = "",
            clubHomeTown = "",
            clubStadium = "",
            clubCoachName = "",
            clubFoundedYear = "",
            clubCaptainName = "",
            clubNation = "",
            clubNationImgUrl = ""
        )
        ClubLocation("", "London, England")

        ClubInfoTextRow(infoTitle = "Establishment", infoContent = "1886.12.01")
        ClubInfoTextRow(infoTitle = "Hometown", infoContent = "London")
        ClubInfoTextRow(infoTitle = "Stadium", infoContent = "Emirates Stadium")
        ClubInfoTextRow(infoTitle = "Captain", infoContent = "Martin Ødegaard")

        ClubInfoTextContent(
            establishDate = "1886.12.01",
            hometown = "London",
            stadium = "Emirates Stadium",
            coach = "Mikel Arteta",
            captain = "Martin Ødegaard",
            modifier = Modifier
                .background(ColorFF720509)
                .padding(vertical = 15.dp)
        )
    }
}