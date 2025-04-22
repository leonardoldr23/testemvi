package br.com.testemvi.modules.account.login.presentation.component

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.ImeAction
import br.com.testemvi.ds.form.button.PrimaryButton
import br.com.testemvi.modules.account.login.presentation.state.LoginFormState

@Composable
fun LoginForm(
    state: LoginFormState,
    onSubmit: () -> Unit,
    onChange: (LoginFormState) -> Unit,
    modifier: Modifier = Modifier,
) {
    TextField(
        value = state.email,
        onValueChange = {
            onChange(LoginFormState(
                email = it.trim(),
                error = null
            ))
        },
        singleLine = true,
        keyboardOptions = KeyboardOptions(
            imeAction = ImeAction.Done
        ),
        keyboardActions = KeyboardActions(
            onDone = { onSubmit.invoke() }
        ),
        label = {
            Text("E-mail")
        },
        isError = (state.error ?: "") != "",
        supportingText = {
            Text(state.error ?: "")
        },
        modifier = modifier
            .fillMaxWidth()
    )
    PrimaryButton(
        text = "Entrar",
        onClick = { onSubmit.invoke() },
        modifier = modifier
            .fillMaxWidth()
    )
}