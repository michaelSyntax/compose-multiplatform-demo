package de.syntax_institut.cmp.demo.data.model

import kotlinx.serialization.Serializable

@Serializable
data class MealCategory(
    val idCategory: String = "",
    val strCategory: String = "",
    val strCategoryThumb: String = "",
    val strCategoryDescription: String = ""
)
