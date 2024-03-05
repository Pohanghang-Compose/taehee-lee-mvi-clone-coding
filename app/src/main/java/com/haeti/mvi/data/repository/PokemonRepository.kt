package com.haeti.mvi.data.repository

import com.haeti.mvi.data.entity.Pokemon

class PokemonRepository {

    suspend fun searchPokemonFromName(name: String): List<Pokemon> {
        return emptyList()
    }
}