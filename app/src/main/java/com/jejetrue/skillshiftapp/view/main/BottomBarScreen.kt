package com.jejetrue.skillshiftapp.view.main

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Assignment
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomBarScreen(
    val route: String,
    val title: String,
    val icon: ImageVector
) {
    object Home : BottomBarScreen(
        route = "HOME",
        title = "Home",
        icon = Icons.Default.Home
    )

    object Project : BottomBarScreen(
        route = "PROJECT",
        title = "Project",
        icon = Icons.Default.Assignment
    )

    object Profile : BottomBarScreen(
        route = "PROFILE",
        title = "Profile",
        icon = Icons.Default.Person
    )
}