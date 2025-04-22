package br.com.testemvi.main

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import br.com.testemvi.main.model.ScreenList
import br.com.testemvi.modules.account.login.presentation.LoginScreen

fun NavGraphBuilder.Routes () {
    // ------------------------------------------
    // Login
    // ------------------------------------------
    composable(ScreenList.Login.name) {
        LoginScreen()
    }
    // ------------------------------------------
}