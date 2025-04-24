package de.syntax_institut.cmp.demo.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun AppNavHost(
    navController: NavHostController,
    didSelectCategory: (String) -> Unit,
    didSelectMeal: (String) -> Unit,
    didSelectRandomMeal: () -> Unit,
    modifier: Modifier = Modifier
) {
    NavHost(
        navController = navController,
        startDestination = Route.RandomMeal
    ) {
        composable<Route.RandomMeal> {

        }
        composable<Route.FavoriteMeals> {

        }
        composable<Route.MealCategoryList> {

        }
        composable<Route.MealDetail> {

        }
        composable<Route.MealList> {

        }
    }
}