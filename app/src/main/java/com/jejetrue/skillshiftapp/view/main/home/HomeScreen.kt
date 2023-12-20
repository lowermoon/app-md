package com.jejetrue.skillshiftapp.view.main.home

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.SearchBar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.jejetrue.skillshiftapp.data.repository.getToken
import com.jejetrue.skillshiftapp.data.response.project.ProjectData
import com.jejetrue.skillshiftapp.data.response.project.getAllProject
import com.jejetrue.skillshiftapp.data.retrofit.ExecApi
import com.jejetrue.skillshiftapp.ui.theme.SkillShiftAppTheme
import com.jejetrue.skillshiftapp.view.main.ProjectItem

@Composable
fun HomeScreen(
    navigateToDetail: (String) -> Unit
) {
    val token = getToken()
    var items by remember { mutableStateOf<List<ProjectData?>?>(null) }
    ExecApi {
        items = getAllProject(token)?.result?.project
    }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(15.dp)
    ) {
        SearchBarProject()
        LazyColumn{
            items(items ?: emptyList()) {
                Column( modifier = Modifier.clickable {
                    navigateToDetail(it?.projectId.toString())
                } ) {
                    ProjectItem(
                        title = it?.projectName.toString(),
                        subTitle = it?.projectDesc.toString()
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                }
            }
        }

    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchBarProject() {
    var text by remember { mutableStateOf("") }
    var active by remember { mutableStateOf(false) }

    SearchBar(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp),
        query = text,
        onQueryChange = { text = it },
        onSearch = { active = false },
        active = active,
        onActiveChange = { active = it },
        placeholder = { Text(text = "cari proyek") },
        leadingIcon = {
            Icon(
                imageVector = Icons.Default.Search,
                contentDescription = "Search Icon"
            )
        },

        ) {

    }
    
}





@Preview
@Composable
fun HomePreview() {
    SkillShiftAppTheme {
        HomeScreen({})
    }
    
}