package de.syntax_institut.cmp.demo.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import coil3.compose.AsyncImage
import de.syntax_institut.cmp.demo.data.model.Meal

@Composable
fun MealDetailScreen(
    meal: Meal,
    isFavorite: Boolean,
    toggleFavorite: (Meal) -> Unit,
    modifier: Modifier = Modifier
) {
    Scaffold(
        modifier = modifier,
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    toggleFavorite(meal)
                },
                content = {
                    if (isFavorite) {
                        Icon(Icons.Default.Favorite, Icons.Default.Favorite.name)
                    } else {
                        Icon(Icons.Default.FavoriteBorder, Icons.Default.FavoriteBorder.name)
                    }
                }
            )
        },
        content = {
            Column(
                modifier = Modifier.fillMaxSize().padding(it),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                content = {
                    AsyncImage(
                        model = meal.strMealThumb,
                        contentDescription = meal.strMeal
                    )
                    Text(meal.strMeal)
                    Text(meal.strArea)
                    Text(meal.strCategory)
                    Text(meal.strYoutube)
                }
            )
        }
    )
}