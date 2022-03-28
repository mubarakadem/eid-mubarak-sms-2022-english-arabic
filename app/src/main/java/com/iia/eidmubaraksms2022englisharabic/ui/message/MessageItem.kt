package com.iia.eidmubaraksms2022englisharabic.ui.message

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Popup
import androidx.compose.ui.window.PopupProperties

@ExperimentalMaterial3Api
@Composable
fun MessageItem() {
    var checked by remember { mutableStateOf(false) }
    var show by remember { mutableStateOf(false) }

    Card {
        Column(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            IconToggleButton(
                checked = checked,
                onCheckedChange = { checked = it },
                modifier = Modifier.align(Alignment.End)
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
                    .align(Alignment.CenterHorizontally)
                    .padding(16.dp)
            )

            IconButton(
                onClick = { show = !show },
                modifier = Modifier.align(Alignment.End)
            ) {
                Icon(imageVector = Icons.Default.MoreVert, contentDescription = "More Menu")
            }

            if (show) {
                PopUpMenu(
                    modifier = Modifier
                        .padding(vertical = 12.dp),
                    onDismiss = { show = false }
                ) {
                    MenuItem(onClick = {}) {
                        Icon(imageVector = Icons.Default.Home, contentDescription = "Copy")
                        Text(text = "Copy", color = MaterialTheme.colorScheme.onSurface)
                    }
                    MenuItem(onClick = {}) {
                        Icon(
                            imageVector = Icons.Default.Share,
                            contentDescription = "Share as Text"
                        )
                        Text(text = "Share as Text", color = MaterialTheme.colorScheme.onSurface)
                    }
                    MenuItem(onClick = {}) {
                        Icon(
                            imageVector = Icons.Default.Share,
                            contentDescription = "Share as Image"
                        )
                        Text(text = "Share as Image", color = MaterialTheme.colorScheme.onSurface)
                    }
                    MenuItem(onClick = {}) {
                        Icon(imageVector = Icons.Default.ThumbUp, contentDescription = "Save")
                        Text(text = "Copy", color = MaterialTheme.colorScheme.onSurface)
                    }
                }

            }

            BackHandler(enabled = show) {
                show = false
            }
        }
    }
}

@Composable
private fun PopUpMenu(
    modifier: Modifier = Modifier,
    onDismiss: () -> Unit,
    content: @Composable ColumnScope.() -> Unit
) {
    Popup(
        alignment = Alignment.BottomEnd,
        onDismissRequest = onDismiss,
        properties = PopupProperties(clippingEnabled = false)
    ) {
        Surface(
            shape = RoundedCornerShape(8.dp),
            tonalElevation = 12.dp,
            color = Color.White,
            shadowElevation = 8.dp
        ) {
            Column(
                verticalArrangement = Arrangement.spacedBy(8.dp),
                modifier = modifier
            ) {
                content()
            }
        }
    }
}

@Composable
private fun MenuItem(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    content: @Composable RowScope.() -> Unit
) {
    Row(
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .wrapContentSize()
            .clip(RoundedCornerShape(8.dp))
            .clickable(
                onClick = onClick,
                role = Role.Button
            )
            .padding(horizontal = 12.dp, vertical = 4.dp)
    ) {
        content()
    }
}

@ExperimentalMaterial3Api
@Preview
@Composable
fun MessageItemPreview() {
    MessageItem()
}

@Preview
@Composable
fun PopUpMenuPreview() {
    PopUpMenu(onDismiss = {}) {
        MenuItem(onClick = {}) {
            Icon(imageVector = Icons.Default.Home, contentDescription = "Copy")
            Text(text = "Copy", color = MaterialTheme.colorScheme.onSurface)
        }
        MenuItem(onClick = {}) {
            Icon(imageVector = Icons.Default.Share, contentDescription = "Share")
            Text(text = "Share", color = MaterialTheme.colorScheme.onSurface)
        }
        MenuItem(onClick = {}) {
            Icon(imageVector = Icons.Default.ThumbUp, contentDescription = "Copy")
            Text(text = "Save", color = MaterialTheme.colorScheme.onSurface)
        }
    }
}