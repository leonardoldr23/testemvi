package br.com.mylister.modules.account.login.data.repository

import br.com.mylister.database.entity.Account as AccountEntity
import br.com.mylister.main.core.Application
import br.com.mylister.modules.account.login.data.model.Account
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.transform
import java.util.UUID

class AccountRepository {
    private val dao = Application.database.accountDao()

    suspend fun insert(email: String): Account {
        dao.create(AccountEntity(
            email = email
        ))
        val account = dao.showByEmail(email)!!
        return Account(
            id = account.id,
            email = account.email
        )
    }

    suspend fun delete(id: UUID) {
        val account = dao.show(id)
        if (account != null) {
            dao.delete(account)
        }
    }

    suspend fun list(): Flow<List<Account>> {
        return dao.list().transform { list ->
            val accounts = list.map { account ->
                Account(
                    id = account.id,
                    email = account.email
                )
            }
            emit(accounts)
        }
    }
}