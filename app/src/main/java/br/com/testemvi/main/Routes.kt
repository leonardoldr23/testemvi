package br.com.mylister.main

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import br.com.mylister.main.model.ScreenList
import br.com.mylister.modules.account.login.presentation.LoginScreen

fun NavGraphBuilder.Routes () {
    // ------------------------------------------
    // Login
    // ------------------------------------------
    composable(ScreenList.Login.name) {
        LoginScreen()
    }
    // ------------------------------------------
}