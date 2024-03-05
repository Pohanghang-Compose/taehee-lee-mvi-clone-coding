package com.haeti.mvi.ui

import com.haeti.mvi.data.entity.ImageEntity
import com.haeti.mvi.data.entity.Pokemon

val SAMPLE_POKEMON = Pokemon(
    image = ImageEntity(
        id = 1,
        pokemonId = 1,
        localUrl = "http://www.serebii.net/pokemongo/pokemon/025.png"
    ),
    name = "Pikachu"
)