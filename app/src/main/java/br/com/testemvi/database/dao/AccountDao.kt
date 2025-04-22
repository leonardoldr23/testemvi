package br.com.mylister.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import br.com.mylister.database.entity.Account
import kotlinx.coroutines.flow.Flow
import java.util.UUID

@Dao
interface AccountDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun create(account: Account): Long

    @Query("SELECT * FROM accounts")
    fun list(): Flow<List<Account>>

    @Query("SELECT * FROM accounts WHERE id = :id")
    suspend fun show(id: UUID): Account?

    @Query("SELECT * FROM accounts WHERE email = :email")
    suspend fun showByEmail(email: String): Account?

    @Update
    suspend fun update(account: Account): Int

    @Delete
    suspend fun delete(account: Account): Int
}