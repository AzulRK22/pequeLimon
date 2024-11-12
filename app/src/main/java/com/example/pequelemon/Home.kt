package com.example.pequelemon

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.*
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

@Composable
fun HomeScreen2(navController: NavHostController) {
    var searchPhrase by remember { mutableStateOf("") }

    Column {
        TopAppBar(navController = navController)
        UpperPanel(
            searchPhrase = searchPhrase,
            onSearchPhraseChange = { newPhrase ->
                searchPhrase = newPhrase
            }
        )
        LowerPanel(
            navController = navController,
            dishes = DishRepository.dishes,
            searchPhrase = searchPhrase
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewHomeScreen2() {
    HomeScreen2(navController = rememberNavController())
}

