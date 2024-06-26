package com.eshc.goonersapp.core.designsystem.component

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.eshc.goonersapp.core.designsystem.IconPack
import com.eshc.goonersapp.core.designsystem.iconpack.IcArrowDown
import com.eshc.goonersapp.core.designsystem.theme.ColorFF000000
import com.eshc.goonersapp.core.designsystem.theme.ColorFF181818
import com.eshc.goonersapp.core.designsystem.theme.ColorFF777777
import com.eshc.goonersapp.core.designsystem.theme.ColorFF9E9E9E
import com.eshc.goonersapp.core.designsystem.theme.ColorFFDCDCDC
import com.eshc.goonersapp.core.designsystem.theme.ColorFFF5F5F5
import com.eshc.goonersapp.core.designsystem.theme.GnrTypography

@Composable
fun GnrDropdownMenuWithBottomSheet(
    label : String,
    modifier: Modifier = Modifier,
    bottomSheetContent : @Composable (()-> Unit) -> Unit
) {
    var expanded by remember { mutableStateOf(false) }

    OutlinedButton(
        modifier = modifier,
        colors = ButtonDefaults.outlinedButtonColors(
            contentColor = ColorFF9E9E9E
        ),
        border = BorderStroke(1.dp, ColorFFDCDCDC),
        shape = CircleShape,
        onClick = {
            expanded = true
        }
    ) {
        Text(
            modifier = Modifier
                .weight(1f)
                .padding(end = 4.dp),
            text = label,
            style = GnrTypography.body1Regular,
            color = ColorFF777777
        )
        Icon(
            imageVector = IconPack.IcArrowDown,
            contentDescription = "down"
        )
    }

    if (expanded) {
        GnrBottomSheet(
            onDismiss = {
                expanded = !expanded
            }
        ) {
            bottomSheetContent{
                expanded = !expanded
            }
        }
    }
}

@Composable
fun <T> GnrMenuContent(
    title: String,
    menuItems : List<T>,
    selectedItem : T? = null,
    onClick: (T?) -> Unit,
    modifier: Modifier = Modifier
) {
    var selected by remember {
        mutableStateOf(selectedItem)
    }
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            modifier = Modifier.padding(vertical = 7.dp),
            text = title,
            style = GnrTypography.heading2SemiBold,
            color = ColorFF181818
        )
        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .heightIn(max = 217.dp),
            contentPadding = PaddingValues(start = 15.dp, end = 15.dp, bottom = 16.dp)
        ) {
            items(
                menuItems
            ) {
                GnrMenuItem(
                    text = it.toString(),
                    selected = selected == it,
                    onClick = {
                        selected = it
                    },
                    modifier = Modifier.fillMaxWidth()
                )
            }
        }
        HorizontalDivider()
        GnrTextButton(
            modifier = Modifier
                .padding(vertical = 16.dp, horizontal = 50.dp)
                .fillMaxWidth()
                .wrapContentHeight(),
            onClick = {
                onClick(selected)
            },
            text = "OK"
        )
    }

}

@Composable
fun GnrMenuItem(
    text: String,
    selected: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .wrapContentHeight()
            .clip(RoundedCornerShape(10.dp))
            .background(if (selected) ColorFFF5F5F5 else Color.Transparent)
            .clickable {
                onClick()
            }
            .padding(vertical = 7.dp)
            ,
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = text,
            style = GnrTypography.body1Medium,
            color = ColorFF000000
        )
    }

}