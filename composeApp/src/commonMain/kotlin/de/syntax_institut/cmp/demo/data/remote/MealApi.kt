package de.syntax_institut.cmp.demo.data.remote

import de.syntax_institut.cmp.demo.data.model.Meal
import de.syntax_institut.cmp.demo.data.model.MealCategory
import de.syntax_institut.cmp.demo.data.model.MealCategoryResponse
import de.syntax_institut.cmp.demo.data.model.MealResponse
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.request.get
import io.ktor.http.ContentType
import io.ktor.http.contentType
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

private const val BASE_URL = "https://www.themealdb.com/api/json/v1/1/"

class MealApi(
    private val httpClient: HttpClient
): MealApiService {

    override suspend fun getRandomMeal(): Meal {
        val response: MealResponse = httpClient.get(BASE_URL + "random.php").body()
        return response.meals.first()
    }

    override suspend fun getMealCategories(): List<MealCategory> {
        val response: MealCategoryResponse = httpClient.get(BASE_URL + "categories.php").body()
        return response.categories
    }

    override suspend fun getMealsForCategory(catId: String): List<Meal> {
        val response: MealResponse = httpClient.get(BASE_URL + "filter.php?c=$catId").body()
        return response.meals
    }

    override suspend fun getMealDetails(mealId: String): Meal {
        val response: MealResponse = httpClient.get(BASE_URL + "lookup.php?i=$mealId").body()
        return response.meals.first()
    }
}