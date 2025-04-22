package br.com.testemvi.modules.account.login.presentation

import br.com.testemvi.main.core.MviViewModel
import br.com.testemvi.modules.account.login.data.repository.AccountRepository
import br.com.testemvi.modules.account.login.presentation.state.LoginAction
import br.com.testemvi.modules.account.login.presentation.state.LoginEvent
import br.com.testemvi.modules.account.login.presentation.state.LoginFormState
import br.com.testemvi.modules.account.login.presentation.state.LoginState
import java.util.*

class LoginViewModel : MviViewModel<LoginAction, LoginEvent, LoginState>(LoginState()) {

    override suspend fun on(action: LoginAction) {
        when (action) {
            is LoginAction.Load -> loadAccounts()
            is LoginAction.Login -> login(action.email)
            is LoginAction.LoginFormChange -> { updateForm(action.form) }
            is LoginAction.Delete -> delete(action.id)
        }
    }

    private suspend fun delete(id: UUID) {
        AccountRepository().delete(id)
    }

    private suspend fun loadAccounts() {
        _state.value = _state.value.copy(accounts = AccountRepository().list())
    }

    private fun updateForm(form: LoginFormState) {
        _state.value = _state.value.copy(form = form)
    }

    private suspend fun login(email: String? = null) {
        val email = email ?: _state.value.form.email
        if (email.isEmpty()) {
            _state.value = _state.value.copy(
                form = _state.value.form.copy(
                    error = "Campo obrigatório"
                )
            )
        } else if (!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            _state.value = _state.value.copy(
                form = _state.value.form.copy(
                    error = "E-mail inválido"
                )
            )
        } else {
            _state.value = _state.value.copy(
                form = _state.value.form.copy(
                    error = null
                )
            )
            val account = AccountRepository().insert(email)
            emit(LoginEvent.LoginSuccess(account))
        }
    }
}