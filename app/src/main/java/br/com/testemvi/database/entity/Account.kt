package br.com.mylister.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey
import java.util.Date
import java.util.UUID

@Entity(tableName = "accounts", indices = [Index(value = ["email"], unique = true)])
data class Account (
    @PrimaryKey val id: UUID = UUID.randomUUID(),
    val name: String? = null,
    val email: String,
    @ColumnInfo(name = "createdAt", defaultValue = "CURRENT_TIMESTAMP")
    val createdAt: Date? = null,
    @ColumnInfo(name = "updatedAt", defaultValue = "CURRENT_TIMESTAMP")
    val updatedAt: Date? = null
)