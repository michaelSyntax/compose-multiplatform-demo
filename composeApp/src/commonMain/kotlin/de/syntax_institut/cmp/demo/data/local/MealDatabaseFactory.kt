package de.syntax_institut.cmp.demo.data.local

import androidx.room.RoomDatabase

@Suppress("NO_ACTUAL_FOR_EXPECT")
expect class DatabaseFactory {
    fun create(): RoomDatabase.Builder<MealDatabase>
}