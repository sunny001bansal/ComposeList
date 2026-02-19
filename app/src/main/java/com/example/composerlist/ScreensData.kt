package com.example.composerlist

import androidx.compose.ui.graphics.Color

data class ListItem(
    val icon: String,
    val name: String
)

data class ScreenConfig(
    val id: Int,
    val title: String,
    val color: Color,
    val items: List<ListItem>
)

// Configuration for the 5 different screens
val screens = listOf(
    ScreenConfig(
        id = 1,
        title = "Red Screen",
        color = Color(0xFFFFCDD2),
        items = listOf(
            ListItem("⭐", "Red Item 1"),
            ListItem("⭐", "Red Item 2"),
            ListItem("⭐", "Red Item 3")
        )
    ),
    ScreenConfig(
        id = 2,
        title = "Green Screen",
        color = Color(0xFFC8E6C9),
        items = listOf(
            ListItem("🔥", "Green Item 1"),
            ListItem("🔥", "Green Item 2"),
            ListItem("🔥", "Green Item 3")
        )
    ),
    ScreenConfig(
        id = 3,
        title = "Blue Screen",
        color = Color(0xFFBBDEFB),
        items = listOf(
            ListItem("💡", "Blue Item 1"),
            ListItem("💡", "Blue Item 2"),
            ListItem("💡", "Blue Item 3")
        )
    ),
    ScreenConfig(
        id = 4,
        title = "Yellow Screen",
        color = Color(0xFFFFF9C4),
        items = listOf(
            ListItem("✅", "Yellow Item 1"),
            ListItem("✅", "Yellow Item 2"),
            ListItem("✅", "Yellow Item 3")
        )
    ),
    ScreenConfig(
        id = 5,
        title = "Purple Screen",
        color = Color(0xFFE1BEE7),
        items = listOf(
            ListItem("🎵", "Purple Item 1"),
            ListItem("🎵", "Purple Item 2"),
            ListItem("🎵", "Purple Item 3")
        )
    )
)

fun getScreenConfigById(id: Int): ScreenConfig? =
    screens.find { it.id == id }

