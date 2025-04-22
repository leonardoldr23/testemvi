package br.com.testemvi.modules.account.login.presentation.state

import br.com.testemvi.modules.account.login.data.model.Account
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emptyFlow

data class LoginFormState(
    val email: String = "",
    val error: String? = null,
)

data class LoginState(
    val form: LoginFormState = LoginFormState(),
    val accounts: Flow<List<Account>> = emptyFlow(),
)
