package com.jejetrue.skillshiftapp.view

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.jejetrue.skillshiftapp.navigation.Nav
import com.jejetrue.skillshiftapp.ui.theme.SkillShiftAppTheme

@Composable
fun SkillShiftApp(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
) {
    SkillShiftAppTheme {
        // A surface container using the 'background' color from the theme
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            Nav()
        }
    }
}