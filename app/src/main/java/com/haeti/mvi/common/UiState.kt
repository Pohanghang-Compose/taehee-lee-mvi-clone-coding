package com.haeti.mvi.common

sealed class UiStatus {
    data object Loading : UiStatus()
    data object Success : UiStatus()
    data class Failed(val message: String = "") : UiStatus()
}