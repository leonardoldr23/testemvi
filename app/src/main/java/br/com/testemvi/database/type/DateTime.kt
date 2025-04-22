package br.com.mylister.database.type

import androidx.room.TypeConverter
import java.util.Date

class DateTime {

    @TypeConverter
    fun fromDateTime(date: Date?): Long? {
        return date?.time
    }

    @TypeConverter
    fun toDateTime(timestamp: Long?): Date? {
        if (timestamp == null) {
            return null
        }
        return Date(timestamp)
    }
}