package de.syntax_institut.cmp.demo.data.repository

import de.syntax_institut.cmp.demo.data.local.MealDao
import de.syntax_institut.cmp.demo.data.model.Meal
import de.syntax_institut.cmp.demo.data.model.MealCategory
import de.syntax_institut.cmp.demo.data.remote.MealApiService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.map

class DefaultMealRepository(
    val apiService: MealApiService,
    val mealDao: MealDao
): MealRepository {
    override suspend fun getRandomMeal(): Meal {
        return apiService.getRandomMeal()
    }

    override suspend fun getMealCategories(): List<MealCategory> {
        return apiService.getMealCategories()
    }

    override suspend fun getMealsForCategory(catId: String): List<Meal> {
        return apiService.getMealsForCategory(catId)
    }

    override suspend fun getMeal(mealId: String): Meal {
        return apiService.getMealDetails(mealId)
    }

    override suspend fun getFavoriteMeals(): List<Meal> {
        return mealDao.getAllFavorites()
    }

    fun isMealFavorite(mealId: String): Boolean {
        return false
    }

    override suspend fun deleteFromFavorites(mealId: String) {
       // mealDao.deleteFavoriteMeal(mealId)
    }

    override suspend fun markAsFavorite(meal: Meal) {
        println("DEBUG:: markAsFavorite --> meal.${meal.strMeal}")
//        mealDao.upsert(meal)
//        mealDao.addFavorite(meal)
        try {
            mealDao.addFavorite(meal)
        } catch(e: Exception) {
            println("ERROR:: addFavorite $e")
        }
    }
}