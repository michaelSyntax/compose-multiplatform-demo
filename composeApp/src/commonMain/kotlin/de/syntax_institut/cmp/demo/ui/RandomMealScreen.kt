package de.syntax_institut.cmp.demo.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Refresh
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
fun RandomMealScreen(
    meal: Meal,
    onRandomMealRefreshSelection: () -> Unit,
    modifier: Modifier = Modifier
) {
    Scaffold(
        modifier = modifier,
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    onRandomMealRefreshSelection()
                },
                content = {
                    Icon(Icons.Default.Refresh, Icons.Default.Refresh.name)
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
                        contentDescription = null
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