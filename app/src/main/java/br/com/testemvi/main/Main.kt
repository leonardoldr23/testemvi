package br.com.mylister.main

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import br.com.mylister.main.model.ScreenList
import br.com.mylister.main.model.enterTransition
import br.com.mylister.main.model.exitTransition

@Composable
fun Main (navController: NavHostController = rememberNavController()) {
    // Get current back stack entry
    val backStackEntry = navController.currentBackStackEntry
    // Get the name of the current screen
    val currentScreen = ScreenList.valueOf(
        backStackEntry?.destination?.route ?: ScreenList.Login.name
    )
    Scaffold (
        topBar = {
            // Your TopBar content
        },
        bottomBar = {
            // Your BottomBar content
        }
    ) { innerPadding ->
        val transitionDuration = 500
        NavHost (
            navController = navController,
            startDestination = currentScreen.name,
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(innerPadding),
            enterTransition = enterTransition(transitionDuration),
            exitTransition = exitTransition(transitionDuration),
        ) {
            Routes()
        }
    }
}