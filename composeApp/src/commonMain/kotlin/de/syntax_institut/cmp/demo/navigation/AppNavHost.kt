package de.syntax_institut.cmp.demo.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import de.syntax_institut.cmp.demo.ui.FavoritesScreen
import de.syntax_institut.cmp.demo.ui.MealCategoriesScreen
import de.syntax_institut.cmp.demo.ui.MealDetailScreen
import de.syntax_institut.cmp.demo.ui.MealListScreen
import de.syntax_institut.cmp.demo.ui.RandomMealScreen

@Composable
fun AppNavHost(
    navController: NavHostController,
    didSelectCategory: (String) -> Unit,
    didSelectMeal: (String) -> Unit,
    didSelectRandomMeal: () -> Unit,
    modifier: Modifier = Modifier,
    selectedNavItem: NavigationItem
) {
    NavHost(
        navController = navController,
        startDestination = selectedNavItem.route
    ) {
        composable<Route.RandomMeal> {
            RandomMealScreen(modifier = modifier)
        }
        composable<Route.FavoriteMeals> {
            FavoritesScreen(modifier = modifier)
        }
        composable<Route.MealCategoryList> {
            MealCategoriesScreen(modifier = modifier)
        }
        composable<Route.MealDetail> {
            MealDetailScreen(modifier = modifier)
        }
        composable<Route.MealList> {
            MealListScreen(modifier = modifier)
        }
    }
}