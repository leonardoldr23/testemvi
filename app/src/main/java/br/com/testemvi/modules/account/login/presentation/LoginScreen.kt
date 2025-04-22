package br.com.mylister.modules.account.login.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import br.com.mylister.ds.text.HeaderLarge
import br.com.mylister.modules.account.login.presentation.component.AccountList
import br.com.mylister.modules.account.login.presentation.component.LoginForm
import br.com.mylister.modules.account.login.presentation.state.LoginAction
import br.com.mylister.modules.account.login.presentation.LoginViewModel

@Composable
fun LoginScreen() {
    val viewModel: LoginViewModel = viewModel()
    val state = viewModel.state.collectAsState().value
    val accounts = state.accounts.collectAsState(listOf()).value

    viewModel.dispatch(LoginAction.Load)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
    ) {
        HeaderLarge(
            "El Loginero",
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(
                    top = 32.dp,
                    bottom = 48.dp
                )
        )
        LoginForm(
            state = state.form,
            onChange = { form ->
                viewModel.dispatch(LoginAction.LoginFormChange(form))
            },
            onSubmit = { viewModel.dispatch(LoginAction.Login()) },
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        )
        if (accounts.isNotEmpty()) {
            AccountList(
                accounts = accounts,
                onClick = { account ->
                    viewModel.dispatch(LoginAction.Login(account.email))
                },
                onDelete = { account ->
                    viewModel.dispatch(LoginAction.Delete(account.id!!))
                },
            )
        }
    }
}