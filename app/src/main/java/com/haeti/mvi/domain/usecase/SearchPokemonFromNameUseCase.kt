package com.haeti.mvi.domain.usecase

import com.haeti.mvi.data.entity.Pokemon
import com.haeti.mvi.data.repository.PokemonRepository

class SearchPokemonFromNameUseCase(private val pokemonRepository: PokemonRepository) {
    suspend operator fun invoke(name: String) : List<Pokemon> {
        return if (name.isEmpty()) {
            emptyList()
        } else {
            pokemonRepository.searchPokemonFromName(name)
        }
    }

}