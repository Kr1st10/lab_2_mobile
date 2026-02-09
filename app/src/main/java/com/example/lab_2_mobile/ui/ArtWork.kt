package com.example.lab_2_mobile.ui

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.example.lab_2_mobile.R

data class Artwork(
    @DrawableRes val imageRes: Int,
    @StringRes val titleRes: Int,
    @StringRes val authorRes: Int
)

val artworks = listOf(
    Artwork(
        imageRes = R.drawable.art_1,
        titleRes = R.string.artwork_title_1,
        authorRes = R.string.artwork_author_1
    ),
    Artwork(
        imageRes = R.drawable.art_2,
        titleRes = R.string.artwork_title_2,
        authorRes = R.string.artwork_author_2
    ),
    Artwork(
        imageRes = R.drawable.art_3,
        titleRes = R.string.artwork_title_3,
        authorRes = R.string.artwork_author_3
    )
)

