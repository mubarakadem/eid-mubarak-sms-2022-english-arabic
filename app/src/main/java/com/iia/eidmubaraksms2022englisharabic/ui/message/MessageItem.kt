package com.iia.eidmubaraksms2022englisharabic.ui.message

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Popup
import androidx.compose.ui.window.PopupProperties
import androidx.constraintlayout.compose.ConstraintLayout

@ExperimentalMaterial3Api
@Composable
fun MessageItem() {
    var checked by remember { mutableStateOf(false) }
    var show by remember { mutableStateOf(false) }

    Card {
        ConstraintLayout(
            modifier = Modifier
                .fillMaxWidth()

        ) {
            val (heart, message, more, menu) = createRefs()

            IconToggleButton(
                checked = checked,
                onCheckedChange = { checked = it },
                modifier = Modifier.constrainAs(heart) {
                    top.linkTo(parent.top)
                    end.linkTo(parent.end)
                }
            ) {
                if (checked) {
                    Icon(
                        imageVector = Icons.Default.Favorite,
                        contentDescription = "Remove from favourites",
                        tint = Color.Red
                    )
                } else {
                    Icon(
                        imageVector = Icons.Default.FavoriteBorder,
                        contentDescription = "Add to Favourite"
                    )
                }
            }

            Text(
                text = "Creatures are the parasites of the neutral assimilation. Creatures are the parasites of the neutral assimilation. Creatures are the parasites of the neutral assimilation.",
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .constrainAs(message) {
                        top.linkTo(heart.bottom)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                    }
                    .padding(16.dp)
            )

            IconButton(onClick = {
                show = !show
            }, modifier = Modifier.constrainAs(more) {
                top.linkTo(message.bottom)
                end.linkTo(parent.end)
                bottom.linkTo(parent.bottom)
            }) {
                Icon(imageVector = Icons.Default.MoreVert, contentDescription = "More Menu")
            }

            if (show) {
                Popup(alignment = Alignment.BottomEnd, onDismissRequest = { show = false }, properties = PopupProperties(clippingEnabled = true)) {
                    Column(
                        verticalArrangement = Arrangement.spacedBy(2.dp),
                        modifier = Modifier.background(color = MaterialTheme.colorScheme.onSurface)
                    ) {
                        Row(
                            horizontalArrangement = Arrangement.spacedBy(2.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Icon(imageVector = Icons.Default.Home, contentDescription = "Copy")
                            Text(text = "Copy")
                        }
                        Row(
                            horizontalArrangement = Arrangement.spacedBy(2.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Icon(imageVector = Icons.Default.Share, contentDescription = "Share")
                        }
                        Row(
                            horizontalArrangement = Arrangement.spacedBy(2.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Icon(imageVector = Icons.Default.Home, contentDescription = "Copy")
                        }
                    }
                }
            }
        }
    }
}

@ExperimentalMaterial3Api
@Preview
@Composable
fun MessageItemPreview() {
    MessageItem()
}