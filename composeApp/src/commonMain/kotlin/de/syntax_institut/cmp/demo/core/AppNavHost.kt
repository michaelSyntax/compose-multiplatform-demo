package de.syntax_institut.cmp.demo.core

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import de.syntax_institut.cmp.demo.navigation.NavigationItem
import de.syntax_institut.cmp.demo.navigation.Route
import de.syntax_institut.cmp.demo.ui.FavoritesScreen
import de.syntax_institut.cmp.demo.ui.MealCategoriesScreen
import de.syntax_institut.cmp.demo.ui.MealDetailScreen
import de.syntax_institut.cmp.demo.ui.MealListScreen
import de.syntax_institut.cmp.demo.ui.MealViewModel
import de.syntax_institut.cmp.demo.ui.RandomMealScreen
import org.koin.compose.viewmodel.koinViewModel
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import de.syntax_institut.cmp.demo.data.model.Meal

@Composable
fun AppNavHost(
    navController: NavHostController,
    didSelectCategory: (String) -> Unit,
    didSelectMeal: (String) -> Unit,
    didSelectRandomMeal: () -> Unit,
    modifier: Modifier = Modifier,
    selectedNavItem: NavigationItem
) {
    val viewModel = koinViewModel<MealViewModel>()
    val categories by viewModel.mealCategories.collectAsState()
    val randomMeal by viewModel.randomMeal.collectAsState()

    NavHost(
        navController = navController,
        startDestination = selectedNavItem.route
    ) {
        composable<Route.RandomMeal> {
            RandomMealScreen(
                meal = randomMeal,
                modifier = modifier,
                onRandomMealRefreshSelection = {
                    viewModel.refreshRandomMeal()
                }
            )
        }
        composable<Route.FavoriteMeals> {
            FavoritesScreen(modifier = modifier)
        }
        composable<Route.MealCategoryList> {
            MealCategoriesScreen(
                modifier = modifier,
                didSelectCategory = {

                },
                categories = categories,
            )
        }
        composable<Route.MealDetail> {
            MealDetailScreen(modifier = modifier)
        }
        composable<Route.MealList> {
            MealListScreen(modifier = modifier)
        }
    }
}