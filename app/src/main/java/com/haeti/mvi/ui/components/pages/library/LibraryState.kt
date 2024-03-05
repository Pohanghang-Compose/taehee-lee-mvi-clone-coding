package com.haeti.mvi.ui.components.pages.library

import com.haeti.mvi.common.UiStatus
import com.haeti.mvi.data.entity.Pokemon

data class LibraryState(
    val status: UiStatus = UiStatus.Loading,
    val searchText: String = "",
    val detailsList: List<Pokemon> = emptyList()
)
