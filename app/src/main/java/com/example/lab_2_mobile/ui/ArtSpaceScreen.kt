package com.example.lab_2_mobile.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lab_2_mobile.R
//@Composable
//fun ArtSpaceScreen() {
//    var currentIndex by rememberSaveable { mutableIntStateOf(0) }
//
//    val artwork = artworks[currentIndex]
//
//    Column(
//        modifier = Modifier.fillMaxSize(),
//        horizontalAlignment = Alignment.CenterHorizontally,
//        verticalArrangement = Arrangement.SpaceEvenly
//    ) {
//        ArtworkDisplay(artwork)
//        NavigationButtons(
//            currentIndex = currentIndex,
//            onPrevious = { currentIndex-- },
//            onNext = { currentIndex++ }
//        )
//    }
//}

@Composable
fun ArtSpaceScreen() {
    var currentIndex by rememberSaveable { mutableIntStateOf(0) }
    val artwork = artworks[currentIndex]

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(dimensionResource(R.dimen.padding_medium)),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.weight(0.25f))
        ArtworkDisplay(artwork)

        Spacer(modifier = Modifier.weight(0.75f))

        NavigationButtons(
            currentIndex = currentIndex,
            onPrevious = { currentIndex-- },
            onNext = { currentIndex++ }
        )
    }
}


@Composable
fun ArtworkDisplay(artwork: Artwork) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(artwork.imageRes),
            //contentDescription = stringResource(artwork.titleRes),
            contentDescription = "${stringResource(artwork.titleRes)}, ${stringResource(artwork.authorRes)}" ,
            modifier = Modifier
                .size(dimensionResource(R.dimen.art_image_size))
                .padding(bottom = dimensionResource(R.dimen.padding_medium))
        )

        Text(
            text = stringResource(artwork.titleRes),
            fontSize = dimensionResource(R.dimen.text_title).value.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center
        )

        Text(
            text = stringResource(artwork.authorRes),
            fontSize = dimensionResource(R.dimen.text_author).value.sp,
            textAlign = TextAlign.Center
        )
    }
}


@Composable
fun NavigationButtons(
    currentIndex: Int,
    onPrevious: () -> Unit,
    onNext: () -> Unit
) {
    Row(
        modifier = Modifier.fillMaxWidth().padding(bottom = 16.dp),

        horizontalArrangement = Arrangement.SpaceEvenly

    ) {
        Button(
            onClick = onPrevious,
            enabled = currentIndex > 0
        ) {
            Text(
                stringResource(R.string.previous),
                fontSize = dimensionResource(R.dimen.text_button).value.sp,
                )


        }

        Button(
            onClick = onNext,
            enabled = currentIndex < artworks.lastIndex


        ) {
            Text(
                stringResource(R.string.next),
                fontSize = dimensionResource(R.dimen.text_button).value.sp,
                )
        }
    }
}


