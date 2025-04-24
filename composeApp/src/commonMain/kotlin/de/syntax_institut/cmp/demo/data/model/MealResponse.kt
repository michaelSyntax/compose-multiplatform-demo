package de.syntax_institut.cmp.demo.data.model

import kotlinx.serialization.Serializable

@Serializable
data class MealResponse(
    val meals: List<Meal>
)
