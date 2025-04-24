package de.syntax_institut.cmp.demo.core

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import de.syntax_institut.cmp.demo.navigation.NavigationItem
import de.syntax_institut.cmp.demo.navigation.Route
import de.syntax_institut.cmp.demo.ui.FavoritesScreen
import de.syntax_institut.cmp.demo.ui.MealCategoriesScreen
import de.syntax_institut.cmp.demo.ui.MealDetailScreen
import de.syntax_institut.cmp.demo.ui.MealListScreen
import de.syntax_institut.cmp.demo.ui.MealViewModel
import de.syntax_institut.cmp.demo.ui.RandomMealScreen
import org.koin.compose.viewmodel.koinViewModel

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
    val mealsForCategory by viewModel.mealsForCategory.collectAsState()
    val selectedMealDetail by viewModel.selectedDetailMeal.collectAsState()
    val isFavorite by viewModel.isFavorite.collectAsState()

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
                    navController.navigate(Route.MealList(catId = it))
                },
                categories = categories,
            )
        }
        composable<Route.MealList> {
            val routeMealList: Route.MealList = it.toRoute()
            viewModel.didSelectCategory(routeMealList.catId)

            MealListScreen(
                modifier = modifier,
                meals = mealsForCategory,
                didSelectMeal = {
                    navController.navigate(Route.MealDetail(mealId = it))
                }
            )
        }
        composable<Route.MealDetail> {
            val routeMealDetail: Route.MealDetail = it.toRoute()
            viewModel.selectDetailMeal(routeMealDetail.mealId)
            viewModel.isFavorite(routeMealDetail.mealId)

            MealDetailScreen(
                meal = selectedMealDetail,
                toggleFavorite = { toggleMeal ->
                    viewModel.toggleFavoriteMeal(toggleMeal)
                },
                modifier = modifier,
                isFavorite = isFavorite
            )
        }
    }
}