package com.jejetrue.skillshiftapp.view.main.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.jejetrue.skillshiftapp.R
import com.jejetrue.skillshiftapp.data.repository.getToken
import com.jejetrue.skillshiftapp.data.response.project.ProjectByIdResponse
import com.jejetrue.skillshiftapp.data.response.project.getProjectById
import com.jejetrue.skillshiftapp.data.retrofit.ExecApi
import com.jejetrue.skillshiftapp.ui.theme.SkillShiftAppTheme
import com.jejetrue.skillshiftapp.view.main.project.Deskripsi
import com.jejetrue.skillshiftapp.view.main.project.ImageProject
import com.jejetrue.skillshiftapp.view.main.project.JudulProyek
import com.jejetrue.skillshiftapp.view.main.project.KategoriProject
import com.jejetrue.skillshiftapp.view.main.project.Keterangan
import com.jejetrue.skillshiftapp.view.main.project.SubJudulProyek

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun InfoTawaran(
    id: String,
    backToHome: () -> Unit
) {
    val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior(rememberTopAppBarState())
    val token = getToken()
    var item by remember { mutableStateOf<ProjectByIdResponse?>(null) }
    ExecApi {
        item = getProjectById(token, id)?.result?.project
    }

    Scaffold(
        modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        text = "Info Proyek",
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    ) },
                navigationIcon = {
                    IconButton(onClick = { backToHome() }) {
                        Icon(
                            imageVector = Icons.Filled.ArrowBack,
                            contentDescription = "Localized description"
                        )
                    }
                },

                scrollBehavior = scrollBehavior,

                )

        }
    ) {innerPadding ->
        //bottomsheet
        val sheetState = rememberModalBottomSheetState()
        var isSheetOpen by rememberSaveable {
            mutableStateOf(false)
        }
        Box {
            Column (
                modifier = Modifier
                    .padding(innerPadding)
                    .verticalScroll(rememberScrollState())
            ){

                Box(modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp)
                    .background(
                        color = MaterialTheme.colorScheme.onPrimary,
                        shape = RoundedCornerShape(8.dp)
                    )
                ) {
                    if ( item !== null ) {

                        Column(modifier = Modifier.padding(15.dp)) {

                            //Info Project di Daftar Penawaran Anda -> jika diklik salah satu item, maka akan langsung ke halaman ini
                            //disini akan menampilkan info dan juga dibawah ada tombol pembatalan

                            JudulProyek(item?.projectName.toString())
                            Spacer(modifier = Modifier.height(8.dp))

                            //kategori
                            Row(horizontalArrangement = Arrangement.spacedBy(5.dp)) {
                                KategoriProject("Games")
                                KategoriProject("mobile legends")
                            }

                            Spacer(modifier = Modifier.height(15.dp))
                            SubJudulProyek()
                            Spacer(modifier = Modifier.height(20.dp))
                            Deskripsi(item?.projectDesc.toString())
                            Spacer(modifier = Modifier.height(8.dp))
                            ImageProject()
                            Spacer(modifier = Modifier.height(10.dp))
                            Keterangan()
                            Spacer(modifier = Modifier.height(8.dp))

                            Button(onClick = { isSheetOpen = true }) {
                                Icon(painter = painterResource(id = R.drawable.ic_offering), contentDescription = "")
                                Spacer(Modifier.size(ButtonDefaults.IconSpacing))
                                Text(text = "Tawarkan")
                            }
                        }
                    }
                }
            }
        }


        if (isSheetOpen){
            ModalBottomSheet(
                sheetState = sheetState,
                onDismissRequest = { isSheetOpen = false }
            ) {
                Column {
                    InputUang()
                    Spacer(modifier = Modifier.height(8.dp))
                    TextArea()
                }
            }

        }
        
    }
    
}

@Composable
fun InputUang() {
    var text by remember { mutableStateOf("") }
    OutlinedTextField(
        value = text ,
        onValueChange ={text = it},
        label = { Text(text = "Jumlah Uang")},
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp),shape = RoundedCornerShape(8.dp)
    )
    
}
@Composable
fun TextArea() {
    var text by remember { mutableStateOf("") }
    OutlinedTextField(
        value = text ,
        onValueChange ={text = it},
        label = { Text(text = "Berikan alasan")},
        modifier = Modifier
            .fillMaxWidth()
            .height(100.dp)
            .padding(10.dp) ,shape = RoundedCornerShape(8.dp))

    
}

@Preview
@Composable
fun InfoTaawaranpreview() {
    SkillShiftAppTheme {
        InfoTawaran("", {})
    }

}