package br.com.testemvi.main.core

import android.app.Application
import android.content.Context
import br.com.testemvi.database.AppDatabase

class Application: Application() {

    companion object {
        private lateinit var instance: Application
        private lateinit var databaseInstance: AppDatabase

        val context: Context
            get() = instance.applicationContext

        val database: AppDatabase
            get() {
                if (!::databaseInstance.isInitialized) {
                    databaseInstance = AppDatabase.getInstance(context)
                }
                return databaseInstance
            }
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }
}