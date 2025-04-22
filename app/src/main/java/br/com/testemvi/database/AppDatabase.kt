package br.com.testemvi.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import br.com.testemvi.database.dao.AccountDao
import br.com.testemvi.database.entity.Account
import br.com.testemvi.database.type.DateTime
import br.com.testemvi.database.type.Uuid

@Database(entities = [Account::class], version = 1)
@TypeConverters(Uuid::class, DateTime::class)
abstract class AppDatabase: RoomDatabase() {
    abstract fun accountDao(): AccountDao

    companion object {
        private var instance: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase {
            if (instance == null) {
                instance = Room.databaseBuilder(
                    context,
                    AppDatabase::class.java,
                    "testemvi.db"
                ).build()
            }
            return instance!!
        }
    }
}