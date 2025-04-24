package de.syntax_institut.cmp.demo.data.local

import androidx.room.RoomDatabaseConstructor

@Suppress("NO_ACTUAL_FOR_EXPECT")
expect object MealDatabaseConstructor: RoomDatabaseConstructor<MealDatabase> {
    override fun initialize(): MealDatabase
}