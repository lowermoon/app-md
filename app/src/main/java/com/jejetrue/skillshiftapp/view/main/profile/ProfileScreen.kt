@file:OptIn(ExperimentalMaterial3Api::class)

package com.jejetrue.skillshiftapp.view.main.profile

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ManageAccounts
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.jejetrue.skillshiftapp.ui.theme.SkillShiftAppTheme

@Composable
fun ProfileScreen(
){
    val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior(rememberTopAppBarState())
    Scaffold(
        modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
        
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        text = "Profile",
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                        )
                },
                actions = {
                    IconButton(
                        onClick = { }) {
                        Icon(imageVector = Icons.Default.ManageAccounts, contentDescription = "Edit Profile")
                        
                    }
                },
                scrollBehavior = scrollBehavior
            )
        },
        ) {innerPadding ->


    }

    

    

}




@Preview
@Composable
fun ProfilePreview() {
    SkillShiftAppTheme {
        ProfileScreen ()
    }

}