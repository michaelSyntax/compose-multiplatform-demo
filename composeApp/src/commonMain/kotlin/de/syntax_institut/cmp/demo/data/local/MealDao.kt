package de.syntax_institut.cmp.demo.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Upsert
import de.syntax_institut.cmp.demo.data.model.Meal

@Dao
interface MealDao {
    @Upsert
    suspend fun upsert(meal: Meal)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addFavorite(meal: Meal)

    @Query("SELECT * FROM favorite_meals")
    suspend fun getAllFavorites(): List<Meal>

    @Upsert
    suspend fun addMeals(meals: List<Meal>)
}