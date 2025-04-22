package br.com.mylister.modules.account.login.presentation.state

import br.com.mylister.modules.account.login.data.model.Account

sealed class LoginEvent {
    data class LoginSuccess(val account: Account) : LoginEvent()
}