package de.syntax_institut.cmp.demo.data.local

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase

actual class DatabaseFactory(
    private val context: Context
) {
    actual fun create(): RoomDatabase.Builder<MealDatabase> {
        val appContext = context.applicationContext
        val dbFile = appContext.getDatabasePath(MealDatabase.DB_NAME)

        return Room.databaseBuilder(
            context = appContext,
            name = dbFile.absolutePath
        )
    }
}