package de.syntax_institut.cmp.demp.data.model

import kotlinx.serialization.Serializable

@Serializable
data class MealResponse(
    val meals: List<Meal>
)
