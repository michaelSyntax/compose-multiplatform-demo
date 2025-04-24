package de.syntax_institut.cmp.demo.navigation

import kotlinx.serialization.Serializable

sealed interface Route {
    @Serializable
    data object RandomMeal: Route

    @Serializable
    data object MealCategoryList: Route

    @Serializable
    data object FavoriteMeals: Route

    @Serializable
    data class MealList(val catId: String): Route

    @Serializable
    data class MealDetail(val mealId: String): Route
}