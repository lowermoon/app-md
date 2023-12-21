package com.jejetrue.skillshiftapp.view.main.home.kategori


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.jejetrue.skillshiftapp.R
import com.jejetrue.skillshiftapp.ui.theme.SkillShiftAppTheme

@Composable
fun KategoriFavorit() {
    Column(
        modifier = Modifier
            .padding(35.dp, 0.dp)
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally,

    ) {
        Spacer(modifier = Modifier.height(15.dp))
        Text(text = "Pilih Kategori Favorit Anda")
        Text(text = "Silahkan pilih terlebih dahulu kategori")
        Text(text = "favorit anda")
        Spacer(modifier = Modifier.height(15.dp))
//        LazyVerticalGrid(
//            columns = GridCells.Fixed(2),
//            verticalArrangement = Arrangement.spacedBy(16.dp),
//            horizontalArrangement = Arrangement.spacedBy(16.dp)
//            ){
//            items(KategoriData.Kategoris, key = {it.title}){Kategori ->
//                KategoriListItem(
//                    image =Kategori.image ,
//                    title =Kategori.title
//                )
//            }
//        }

        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
            KategoriBoxItem(painterResource = painterResource(id = R.drawable.battle_royale_game), title = "Battle Royale", onClick = {})
            KategoriBoxItem(painterResource = painterResource(id = R.drawable.moba_game), title = "MOBA", onClick = {})
        }
        Spacer(modifier = Modifier.height(15.dp))
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
            KategoriBoxItem(painterResource = painterResource(id = R.drawable.horror_game), title = "Horror", onClick = {})
            KategoriBoxItem(painterResource = painterResource(id = R.drawable.open_world_game), title = "Open World", onClick = {})
        }
        Spacer(modifier = Modifier.height(15.dp))
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
            KategoriBoxItem(painterResource = painterResource(id = R.drawable.sport_game), title = "Sports", onClick = {})
            KategoriBoxItem(painterResource = painterResource(id = R.drawable.puzzle_game), title = "Puzzle", onClick = {})
        }
        Spacer(modifier = Modifier.height(15.dp))
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
            KategoriBoxItem(painterResource = painterResource(id = R.drawable.fps_game), title = "FPS", onClick = {})
            KategoriBoxItem(painterResource = painterResource(id = R.drawable.adventure_game), title = "Ad", onClick = {})
        }
        Spacer(modifier = Modifier.height(15.dp))
        KategoriBoxItem(painterResource = painterResource(id = R.drawable.rpg_game), title = "RPG", onClick = {})

        Spacer(modifier = Modifier.height(30.dp))
        TombolSimpan()
        Spacer(modifier = Modifier.height(15.dp))


    }
}

//@Composable
//fun KategoriListItem(image:Int,title:String) {
//    Card {
//        Column(modifier = Modifier.padding(15.dp), horizontalAlignment = Alignment.CenterHorizontally,) {
//            Image(
//                painter = painterResource(id = image),
//                contentDescription = "",
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .size(80.dp)
//            )
//            Text(
//                text = title,
//                fontWeight = FontWeight.Bold ,
//                textAlign = TextAlign.Center,
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .align(Alignment.CenterHorizontally)
//            )
//        }
//    }
//}

@Composable
fun KategoriBoxItem(painterResource : Painter, title:String, onClick: () -> Unit) {
    Box(
        modifier = Modifier
            .width(150.dp)
            .height(150.dp)
            .clip(RoundedCornerShape(16.dp))
            .background(color = MaterialTheme.colorScheme.onSecondary)
            .clickable { onClick() }){
        Column(modifier = Modifier.padding(15.dp), horizontalAlignment = Alignment.CenterHorizontally,) {
            Image(
                painter = painterResource,
                contentDescription = "",
                modifier = Modifier
                    .fillMaxWidth()
                    .size(90.dp)
            )
            Text(
                text = title,
                fontWeight = FontWeight.Bold ,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.CenterHorizontally)
            )
        }

    }
    
}

@Composable
fun TombolSimpan() {
    Button(onClick = { }) {
        Text(text = "Simpan")
        
    }
    
}

@Preview
@Composable
fun KatFavPrev() {
    SkillShiftAppTheme {
        KategoriFavorit()
    }
    
}