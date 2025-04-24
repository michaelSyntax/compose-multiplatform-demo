package de.syntax_institut.cmp.demo.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import de.syntax_institut.cmp.demo.data.model.Meal
import de.syntax_institut.cmp.demo.data.model.MealCategory
import de.syntax_institut.cmp.demo.data.repository.MealRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class MealViewModel(
    val mealRepository: MealRepository
): ViewModel() {
    val cachedMealsForCategory = emptyList<Meal>()

    private val _mealCategories = MutableStateFlow<List<MealCategory>>(emptyList<MealCategory>())
    val mealCategories = _mealCategories.asStateFlow()

    private val _randomMeal = MutableStateFlow<Meal>(Meal())
    val randomMeal = _randomMeal.asStateFlow()

    private val _favoriteMeals = MutableStateFlow<List<Meal>>(emptyList<Meal>())
    val favoriteMeals = _favoriteMeals.asStateFlow()

    fun refreshRandomMeal() {
        viewModelScope.launch {
            _randomMeal.value = mealRepository.getRandomMeal()
        }
    }
}