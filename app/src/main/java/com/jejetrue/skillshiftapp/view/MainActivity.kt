package com.jejetrue.skillshiftapp.view

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.jejetrue.skillshiftapp.navigation.RootNavigationGraph
import com.jejetrue.skillshiftapp.ui.theme.SkillShiftAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SkillShiftAppTheme {
                RootNavigationGraph(navController = rememberNavController())
            }
        }
    }
}

