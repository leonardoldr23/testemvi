package br.com.testemvi.modules.account.login.data.model

import java.util.UUID

data class Account (
    val id: UUID? = null,
    val email: String,
)