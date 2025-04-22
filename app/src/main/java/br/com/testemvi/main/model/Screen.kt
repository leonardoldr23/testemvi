package br.com.testemvi.main.model

import androidx.annotation.StringRes
import br.com.testemvi.R

enum class ScreenList (
    @StringRes val title: Int,
    val level: Int,
) {
    // ------------------------------------------
    // Login
    // ------------------------------------------
    Login (
        title = R.string.screen_list_login,
        level = 1000,
    ),
}

fun isEntering(initialRoute: String?, targetRoute: String?): Boolean {
    val initialScreen = ScreenList.entries.first { it.name === initialRoute };
    val destinationScreen = ScreenList.entries.first { it.name === targetRoute };
    return initialScreen.level < destinationScreen.level;
}