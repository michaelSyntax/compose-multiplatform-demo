package de.syntax_institut.cmp.demo.data.repository

import de.syntax_institut.cmp.demo.data.local.MealDao
import de.syntax_institut.cmp.demo.data.model.Meal
import de.syntax_institut.cmp.demo.data.model.MealCategory
import de.syntax_institut.cmp.demo.data.remote.MealApiService
import kotlinx.coroutines.flow.Flow
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
        return mealDao.getFavoriteMeal(mealId)
    }

    override fun getFavoriteMeals(): Flow<List<Meal>> {
        return mealDao
            .getFavoriteMeals()
    }

    override fun isMealFavorite(mealId: String): Flow<Boolean> {
        return mealDao
            .getFavoriteMeals()
            .map { meals ->
                meals.any { it.idMeal == mealId }
            }
    }

    override suspend fun deleteFromFavorites(mealId: String) {
        mealDao.deleteFavoriteMeal(mealId)
    }

    override suspend fun markAsFavorite(meal: Meal) {
        mealDao.upsert(meal)
    }
}