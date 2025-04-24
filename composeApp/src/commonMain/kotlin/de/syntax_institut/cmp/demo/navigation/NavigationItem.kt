package de.syntax_institut.cmp.demo.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Star
import androidx.compose.ui.graphics.vector.ImageVector

enum class NavigationItem(
    val route: Any,
    val label: String,
    val icon: ImageVector
) {
    Random(
        route = Route.RandomMeal,
        label = "Random",
        icon = Icons.Default.Star
    ),
    Categories(
        route = Route.MealCategoryList,
        label = "Menu",
        icon = Icons.Default.List
    ),
    Favorites(
        route = Route.FavoriteMeals,
        label = "Favorites",
        icon = Icons.Default.Favorite
    )
}