package com.haeti.mvi.ui.components.organisms

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.haeti.mvi.data.entity.Pokemon
import com.haeti.mvi.ui.SAMPLE_POKEMON

@Composable
fun PokemonTwoCard(
    one: Pokemon? = null,
    onClickedOne: (() -> Unit)? = null,
    two: Pokemon? = null,
    onClickedTwo: (() -> Unit)? = null,
    modifier: Modifier = Modifier
) {
    Row(modifier = modifier) {
        if (one != null) {
            PokemonCard(
                pokemon = one,
                onClick = { onClickedOne?.invoke() },
                modifier = Modifier
                    .fillMaxHeight()
                    .fillMaxWidth(fraction = 0.5f)
                    .padding(end = 4.dp)
            )
        }

        if (two != null) {
            PokemonCard(
                pokemon = two,
                onClick = { onClickedTwo?.invoke() },
                modifier = Modifier
                    .fillMaxHeight()
                    .fillMaxWidth()
                    .padding(start = 4.dp)
            )
        }
    }
}

@Preview
@Composable
fun PokemonTwoCard_Preview() {
    PokemonTwoCard(
        one = SAMPLE_POKEMON,
        two = SAMPLE_POKEMON,
        modifier = Modifier
            .height(150.dp)
            .fillMaxWidth()
    )
}

@Preview
@Composable
fun PokemonTwoCard_TwoNull_Preview() {
    PokemonTwoCard(
        one = SAMPLE_POKEMON,
        two = null,
        modifier = Modifier
            .height(150.dp)
            .fillMaxWidth()
    )
}