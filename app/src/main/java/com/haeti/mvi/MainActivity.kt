package com.haeti.mvi

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.primarySurface
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.toArgb
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.haeti.mvi.ui.components.pages.library.LibraryPage
import com.haeti.mvi.ui.components.pages.library.LibrarySideEffect
import com.haeti.mvi.ui.components.pages.library.LibraryViewModel
import com.haeti.mvi.ui.screen.Screen
import com.haeti.mvi.ui.theme.OrbitTheme
import dagger.hilt.android.AndroidEntryPoint
import org.orbitmvi.orbit.compose.collectAsState
import org.orbitmvi.orbit.compose.collectSideEffect

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            OrbitTheme {
                window.statusBarColor = MaterialTheme.colors.primarySurface.toArgb()
                Box(modifier = Modifier.fillMaxSize()){
                    val navController = rememberNavController()
                    NavHost(navController, startDestination = Screen.Init.route) {

                    }
                }
            }
        }
    }
}

//private fun NavGraphBuilder.addInit(navController: NavController) {
//    composable(route = Screen.Init.route) {
//        val viewModel = getComposeViewModel<InitViewModel>()
//        val state by viewModel.collectAsState()
//        viewModel.collectSideEffect {
//            when (it) {
//                is InitSideEffect.Completed -> {
//                    navController.navigate(route = Screen.Library.route)
//                }
//            }
//        }
//        InitPage(
//            state = state,
//            onRetry = { viewModel.retry() }
//        )
//    }
//}

private fun NavGraphBuilder.addLibrary(navController: NavController) {
    composable(route = Screen.Library.route) {
        val viewModel: LibraryViewModel = hiltViewModel()
        val state by viewModel.collectAsState()
        viewModel.collectSideEffect {
//            when (it) {
//                is LibrarySideEffect.ShowDetails -> {
//                    navController.navigate(route = Screen.Details.createRoute(it.id))
//                }
//            }
        }
        LibraryPage(
            state = state,
            onSearchPokemon = { text -> viewModel.searchPokemon(text) }
        )
    }
}
