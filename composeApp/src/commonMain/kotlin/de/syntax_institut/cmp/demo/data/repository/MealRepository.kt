package de.syntax_institut.cmp.demo.data.repository

import de.syntax_institut.cmp.demo.data.model.Meal
import de.syntax_institut.cmp.demo.data.model.MealCategory
import kotlinx.coroutines.flow.Flow

interface MealRepository {
    suspend fun getRandomMeal() : Meal
    suspend fun getMealCategories(): List<MealCategory>
    suspend fun getMealsForCategory(catId: String): List<Meal>
    suspend fun getMeal(mealId: String): Meal

    fun getFavoriteMeals(): Flow<List<Meal>>
    fun isMealFavorite(mealId: String): Flow<Boolean>

    suspend fun deleteFromFavorites(mealId: String)
    suspend fun markAsFavorite(meal: Meal)
}