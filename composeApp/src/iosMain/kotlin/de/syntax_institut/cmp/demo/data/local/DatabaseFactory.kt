package de.syntax_institut.cmp.demo.data.local

import androidx.room.Room
import androidx.room.RoomDatabase
import kotlinx.cinterop.ExperimentalForeignApi
import platform.Foundation.NSDocumentDirectory
import platform.Foundation.NSFileManager
import platform.Foundation.NSUserDomainMask

@ExperimentalForeignApi
actual class DatabaseFactory {
    actual fun create(): RoomDatabase.Builder<MealDatabase> {
        val dbFile = documentDirectory() + "/${MealDatabase.DB_NAME}"
        return Room.databaseBuilder<MealDatabase>(
            name = dbFile
        )
    }

    private fun documentDirectory(): String {
        val documentDirectory = NSFileManager.Companion.defaultManager.URLForDirectory(
            directory = NSDocumentDirectory,
            inDomain = NSUserDomainMask,
            appropriateForURL = null,
            create = false,
            error = null
        )
        return requireNotNull(documentDirectory?.path)
    }
}