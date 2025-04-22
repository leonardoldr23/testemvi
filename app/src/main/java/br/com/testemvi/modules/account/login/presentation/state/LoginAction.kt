package br.com.mylister.modules.account.login.presentation.state

import java.util.UUID

sealed class LoginAction {
    object Load : LoginAction()
    data class Login(val email: String? = null): LoginAction()
    data class LoginFormChange(val form: LoginFormState): LoginAction()
    data class Delete(val id: UUID): LoginAction()
}