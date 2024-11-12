package com.example.pequelemon

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import coil.compose.rememberAsyncImagePainter
import com.example.pequelemon.ui.theme.LittleLemonWhite
import com.example.pequelemon.ui.theme.LittleLemonYellow

@Composable
fun LowerPanel(
    navController: NavHostController,
    dishes: List<Dish> = listOf(),
    searchPhrase: String
) {
    var selectedCategory by remember { mutableStateOf("All") }

    // Filtrar los platos según la frase de búsqueda y la categoría seleccionada
    val filteredDishes = dishes.filter { dish ->
        (searchPhrase.isBlank() || dish.name.contains(searchPhrase, ignoreCase = true) ||
                dish.description.contains(searchPhrase, ignoreCase = true)) &&
                (selectedCategory == "All" || dish.category.displayName == selectedCategory)
    }

    Column {
        // Sección de botones de filtro de categoría
        FilterButtonsRow(selectedCategory) { category ->
            selectedCategory = category
        }

        WeeklySpecialCard()

        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            itemsIndexed(filteredDishes) { index, dish ->
                if (index > 0) {
                    HorizontalDivider(
                        modifier = Modifier.padding(vertical = 0.dp),
                        color = LittleLemonYellow
                    )
                }
                MenuDish(navController = navController, dish = dish)
            }
        }
    }
}

// Botones de filtro de categoría
@Composable
fun FilterButtonsRow(selectedCategory: String, onFilterSelected: (String) -> Unit) {
    Row(
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        val categories = DishCategory.entries.map { it.displayName }

        categories.forEach { category ->
            Button(
                onClick = { onFilterSelected(category) },
                colors = ButtonDefaults.buttonColors(
                    containerColor = if (selectedCategory == category) LittleLemonYellow else Color.Gray,
                    contentColor = Color.White
                ),
                shape = CircleShape,
                modifier = Modifier.wrapContentWidth()
            ) {
                Text(text = category)
            }
        }
    }
}

@Composable
fun WeeklySpecialCard() {
    Text(
        text = stringResource(R.string.weekly_special),
        style = MaterialTheme.typography.displaySmall,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp)
    )
}

@Composable
fun MenuDish(navController: NavHostController? = null, dish: Dish) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .background(LittleLemonWhite)
            .padding(horizontal = 16.dp, vertical = 8.dp)
            .clickable {
                navController?.navigate("${DishDetails.route}/${dish.id}")
            }
    ) {
        Column(
            modifier = Modifier
                .weight(1f)
                .padding(end = 16.dp)
        ) {
            Text(
                text = dish.name,
                style = MaterialTheme.typography.bodyLarge.copy(fontWeight = FontWeight.Bold),
                modifier = Modifier.fillMaxWidth()
            )
            Text(
                text = dish.description,
                style = MaterialTheme.typography.bodyMedium,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 4.dp)
            )
            Text(
                text = "$${dish.price}",
                style = MaterialTheme.typography.bodyMedium,
                modifier = Modifier.fillMaxWidth()
            )
        }
        Image(
            painter = rememberAsyncImagePainter(dish.imageResource),
            contentDescription = dish.name,
            modifier = Modifier
                .size(120.dp)
                .padding(start = 8.dp)
                .clip(RoundedCornerShape(10.dp))
        )
    }
}

