package de.syntax_institut.cmp.demo.data.remote

import de.syntax_institut.cmp.demo.data.model.Meal
import de.syntax_institut.cmp.demo.data.model.MealCategory

interface MealApiService {
    suspend fun getRandomMeal(): Meal
    suspend fun getMealCategories(): List<MealCategory>
    suspend fun getMealsForCategory(catId: String): List<Meal>
    suspend fun getMealDetails(mealId: String): Meal
}