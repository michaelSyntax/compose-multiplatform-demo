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
    private val _mealsForCategory = MutableStateFlow<List<Meal>>(emptyList<Meal>())
    val mealsForCategory = _mealsForCategory.asStateFlow()

    private val _mealCategories = MutableStateFlow<List<MealCategory>>(emptyList<MealCategory>())
    val mealCategories = _mealCategories.asStateFlow()

    private val _randomMeal = MutableStateFlow<Meal>(Meal())
    val randomMeal = _randomMeal.asStateFlow()

    private val _favoriteMeals = MutableStateFlow<List<Meal>>(emptyList<Meal>())
    val favoriteMeals = _favoriteMeals.asStateFlow()

    private val _isFavorite = MutableStateFlow<Boolean>(false)
    val isFavorite = _isFavorite.asStateFlow()

    private val _selectedDetailMeal = MutableStateFlow<Meal>(Meal())
    val selectedDetailMeal = _selectedDetailMeal.asStateFlow()

    init {
        viewModelScope.launch {
            _mealCategories.value = mealRepository.getMealCategories()
        }
    }

    fun refreshRandomMeal() {
        viewModelScope.launch {
            _randomMeal.value = mealRepository.getRandomMeal()
        }
    }

    fun didSelectCategory(catId: String) {
        viewModelScope.launch {
            _mealsForCategory.value = mealRepository.getMealsForCategory(catId)
        }
    }

    fun toggleFavoriteMeal(meal: Meal) {
        viewModelScope.launch {
            mealRepository.isMealFavorite(meal.idMeal).collect { isFavorite ->
                if (isFavorite) {
                    mealRepository.deleteFromFavorites(meal.idMeal)
                } else {
                    mealRepository.markAsFavorite(meal)
                }
            }
        }
    }

    fun selectDetailMeal(mealId: String) {
        viewModelScope.launch {
            _selectedDetailMeal.value = mealRepository.getMeal(mealId)
        }
    }

    fun isFavorite(mealId: String) {
        viewModelScope.launch {
            mealRepository.isMealFavorite(mealId).collect { isFavorite ->
                _isFavorite.value = isFavorite
            }
        }
    }
}