package de.syntax_institut.cmp.demo.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import de.syntax_institut.cmp.demo.data.model.MealCategory

@Composable
fun MealCategoriesScreen(
    didSelectCategory: (String) -> Unit,
    categories: List<MealCategory>,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        modifier = modifier.background(MaterialTheme.colorScheme.background),
        content = {
            items(categories) {
                ElevatedCard(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(12.dp)
                        .clickable(onClick = { didSelectCategory(it.strCategory) }),
                    content = {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.Center,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            AsyncImage(
                                model = it.strCategoryThumb,
                                contentDescription = it.strCategoryThumb
                            )
                            Text(
                                modifier = Modifier.padding(12.dp),
                                text = it.strCategory,
                                fontWeight = FontWeight.Bold
                            )
                        }
                    }
                )
            }
        }
    )
}