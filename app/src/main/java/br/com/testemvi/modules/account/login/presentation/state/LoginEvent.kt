package br.com.testemvi.modules.account.login.presentation.state

import br.com.testemvi.modules.account.login.data.model.Account

sealed class LoginEvent {
    data class LoginSuccess(val account: Account) : LoginEvent()
}