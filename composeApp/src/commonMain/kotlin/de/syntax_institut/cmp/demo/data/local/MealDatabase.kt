package de.syntax_institut.cmp.demo.data.local

import androidx.room.ConstructedBy
import androidx.room.Database
import androidx.room.RoomDatabase
import de.syntax_institut.cmp.demo.data.model.Meal

@Database(
    entities = [Meal::class],
    version = 1
)
@ConstructedBy(MealDatabaseConstructor::class)
abstract class MealDatabase: RoomDatabase() {
    abstract val mealDao: MealDao

    companion object {
        const val DB_NAME = "syntax.meal.db"
    }
}