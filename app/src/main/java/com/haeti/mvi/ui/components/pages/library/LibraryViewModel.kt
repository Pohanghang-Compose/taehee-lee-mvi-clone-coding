package com.haeti.mvi.ui.components.pages.library

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.haeti.mvi.common.UiStatus
import com.haeti.mvi.domain.usecase.SearchPokemonFromNameUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import org.orbitmvi.orbit.Container
import org.orbitmvi.orbit.ContainerHost
import org.orbitmvi.orbit.syntax.simple.intent
import org.orbitmvi.orbit.syntax.simple.reduce
import org.orbitmvi.orbit.viewmodel.container
import javax.inject.Inject

@HiltViewModel
class LibraryViewModel @Inject constructor(
    private val searchPokemonFromNameUseCase: SearchPokemonFromNameUseCase
): ContainerHost<LibraryState, LibrarySideEffect>, ViewModel() {
    private var searchJob: Job? = null

    override val container = container<LibraryState, LibrarySideEffect>(
        LibraryState()
    )


    fun searchPokemon(name: String) {
        intent {
            searchJob?.cancel()
            searchJob = viewModelScope.launch(Dispatchers.IO) {
                reduce {
                    state.copy(
                        status = UiStatus.Loading,
                        searchText = name,
                    )
                }
            }

            val result = searchPokemonFromNameUseCase(name)
            delay(1000)

            if (result.isNotEmpty()) {
                reduce {
                    state.copy(
                        status = UiStatus.Success,
                        detailsList = result
                    )
                }
            } else {
                reduce {
                    state.copy(
                        status = UiStatus.Failed("No results found"),
                        detailsList = emptyList()
                    )
                }
            }
        }
    }

}