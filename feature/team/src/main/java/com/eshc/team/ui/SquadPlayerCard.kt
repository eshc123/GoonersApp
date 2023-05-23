package com.eshc.team.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SquadPlayerCard(
    onClick: () -> Unit,
) {
    Card(
        modifier = Modifier
            .width(186.dp)
            .height(226.dp),
        onClick = onClick,
        shape = RoundedCornerShape(16.dp)
    ) {
        Column {
            Row {
                SquadPlayerHeaderImage(
                    "https://www.arsenal.com/sites/default/files/styles/player_featured_image_1045x658/public/images/Odegaard_Profile_1100x693_0.jpg?itok=deJq4bzS"
                )
            }
            Box(
                modifier = Modifier
                    .fillMaxSize()
            ) {
                Text(
                    modifier = Modifier
                        .align(Alignment.Center),
                    text = "8. Martin Odegaard"
                )
            }
        }
    }
}

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun SquadPlayerHeaderImage(
    imageUrl : String
) {
    GlideImage(
        modifier = Modifier
            .fillMaxWidth()
            .height(186.dp),
        contentScale = ContentScale.Crop,
        model = imageUrl,
        contentDescription = null
    )
}

@Preview(showBackground = true)
@Composable
fun SquadPlayerCardPreview() {
    SquadPlayerCard(
        onClick = {}
    )
}