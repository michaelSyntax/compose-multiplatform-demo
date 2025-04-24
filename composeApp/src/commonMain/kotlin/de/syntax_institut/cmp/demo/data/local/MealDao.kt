package de.syntax_institut.cmp.demo.data.local

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import de.syntax_institut.cmp.demo.data.model.Meal
import kotlinx.coroutines.flow.Flow

@Dao
interface MealDao {

    @Upsert
    suspend fun upsert(meal: Meal)

    @Query("select * from Meal")
    fun getFavoriteMeals(): Flow<List<Meal>>

    @Query("SELECT * FROM Meal WHERE idMeal = :id")
    suspend fun getFavoriteMeal(id: String): Meal

    @Query("DELETE FROM Meal WHERE idMeal = :id")
    suspend fun deleteFavoriteMeal(id: String)
}