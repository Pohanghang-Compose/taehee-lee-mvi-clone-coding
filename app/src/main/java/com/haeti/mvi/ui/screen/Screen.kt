package com.haeti.mvi.ui.screen

import androidx.navigation.NavBackStackEntry

sealed class Screen(val route: String) {
    data object Init : Screen(route = "init")
    data object Library : Screen(route = "library")

    fun createRoute(id: Int) = "details/$id"
    fun getArgumentId(entry: NavBackStackEntry): Int {
        return entry.arguments?.getString("id")?.toInt() ?: 0
    }
}
