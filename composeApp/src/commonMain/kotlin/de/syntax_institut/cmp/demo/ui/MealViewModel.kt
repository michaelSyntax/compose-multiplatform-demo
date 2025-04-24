package de.syntax_institut.cmp.demo.ui

import androidx.lifecycle.ViewModel
import de.syntax_institut.cmp.demo.data.model.Meal
import de.syntax_institut.cmp.demo.data.model.MealCategory
import de.syntax_institut.cmp.demo.data.repository.MealRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class MealViewModel(
    val mealRepository: MealRepository
): ViewModel() {
    val cachedMealsForCategory = emptyList<Meal>()

    private val _mealCategories = MutableStateFlow<List<MealCategory>>(emptyList<MealCategory>())
    val mealCategories = _mealCategories.asStateFlow()
}