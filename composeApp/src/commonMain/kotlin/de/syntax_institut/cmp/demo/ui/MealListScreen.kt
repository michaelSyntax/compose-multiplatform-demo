package de.syntax_institut.cmp.demo.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import de.syntax_institut.cmp.demo.data.model.Meal

@Composable
fun MealListScreen(
    modifier: Modifier = Modifier,
    meals: List<Meal>,
    didSelectMeal: (String) -> Unit
) {
    LazyColumn(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        items(meals) {
            ElevatedCard(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(24.dp)
                    .clickable { didSelectMeal(it.idMeal) },
                content = {
                    Row {
                        AsyncImage(
                            model = it.strMealThumb,
                            contentDescription = it.idMeal
                        )
                        Column {
                            Text(text = it.idMeal)
                            Text(text = it.strCategory)
                            Text(text = it.strArea)
                        }
                        IconButton(
                            onClick = {

                            },
                            content = {
                                Icon(Icons.Default.Favorite, Icons.Default.Favorite.name)
                            }
                        )
                    }
                }
            )
        }
    }
}