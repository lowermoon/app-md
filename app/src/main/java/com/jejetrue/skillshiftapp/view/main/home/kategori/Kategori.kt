package com.jejetrue.skillshiftapp.view.main.home.kategori

import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import com.jejetrue.skillshiftapp.R

data class Kategori(
    val image: Int,
    val title: String
)

object KategoriData{
    val Kategoris = listOf(
        Kategori(
            R.drawable.battle_royale_game,
            "Battle Royale"
        ),
        Kategori(
            R.drawable.moba_game,
            "MOBA"
        ),
        Kategori(
            R.drawable.horror_game,
            "Horror"
        ),
        Kategori(
            R.drawable.open_world_game,
            "Open World"
        ),
        Kategori(
            R.drawable.sport_game,
            "Sports"
        ),
        Kategori(
            R.drawable.puzzle_game,
            "Puzzle"
        ),
        Kategori(
            R.drawable.fps_game,
            "FPS"
        ),
        Kategori(
            R.drawable.adventure_game,
            "Adventure"
        ),
        Kategori(
            R.drawable.rpg_game,
            "RPG"
        )

    )
}
