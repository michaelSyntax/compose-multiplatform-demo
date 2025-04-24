package de.syntax_institut.cmp.demp.data.remote

import de.syntax_institut.cmp.demp.data.model.Meal
import de.syntax_institut.cmp.demp.data.model.MealResponse
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.request.get
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

class MealDBApi(
    private val httpClient: HttpClient = HttpClient {
        install(ContentNegotiation) {
            json(
                Json {
                    ignoreUnknownKeys = true
                    prettyPrint = true
                    isLenient = true
                }
            )
        }
        install(Logging) {
            logger = object : Logger {
                override fun log(message: String) {
                    println(message)
                }
            }
            level = LogLevel.ALL
        }
    }
) {
    private val baseUrl = "https://www.themealdb.com/api/json/v1/1/"

    suspend fun randomMeal() : List<Meal> {
        val response: MealResponse = httpClient.get(baseUrl + "random.php").body()
        return response.meals
    }
}