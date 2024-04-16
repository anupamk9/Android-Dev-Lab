package com.example.appathon.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Send
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material3.*
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.appathon.components.FoodListItem
import com.example.appathon.data.model.FoodListing
import com.example.appathon.ui.theme.*
import com.example.appathon.viewmodels.FoodListingsViewModel

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FoodListingsScreen(navController: NavController) {
    AppathonTheme {
        val viewModel: FoodListingsViewModel = viewModel()
        var searchText by remember { mutableStateOf("") }
        val foodListings by remember(viewModel, searchText) {
            derivedStateOf {
                viewModel.getFilteredFoodListings(searchText)
            }
        }

        Scaffold(
            topBar = {
                TopAppBar(
                    title = { Text("Food Listings") },
                    navigationIcon = {
                        IconButton(
                            onClick = { navController.popBackStack() }
                        ) {
                            Icon(
                                imageVector = Icons.Default.Send,
                                contentDescription = null,
                                modifier = Modifier.size(Dimens.IconSize)
                            )
                        }
                    },
                    actions = {
                        IconButton(
                            onClick = { /* Handle search icon click */ }
                        ) {
                            Icon(
                                imageVector = Icons.Default.Add,
                                contentDescription = null,
                                modifier = Modifier.size(Dimens.IconSize)
                            )
                        }
                    }
                )
            },
            content = {
                FoodListingsContent(
                    searchText = searchText,
                    onSearchTextChange = { searchText = it },
                    foodListings = foodListings,
                    onItemClick = { /* Handle item click */ }
                )
            }
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FoodListingsContent(
    searchText: String,
    onSearchTextChange: (String) -> Unit,
    foodListings: List<FoodListing>, // Replace FoodListing with your actual data model
    onItemClick: (FoodListing) -> Unit // Define your actual onItemClick behavior
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .padding(Dimens.SpaceMedium)
    ) {
        // Search bar
        SearchBar(
            searchText = searchText,
            onSearchTextChange = onSearchTextChange
        )
        // Food listings
        LazyColumn(
            contentPadding = PaddingValues(Dimens.SpaceMedium)
        ) {
            items(foodListings) { foodListing ->
                FoodListItem(
                    foodListing = foodListing,
                    onItemClick = { onItemClick(foodListing) }
                )
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchBar(
    searchText: String,
    onSearchTextChange: (String) -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(Dimens.SpaceMedium)
    ) {
        BasicTextField(
            value = searchText,
            onValueChange = { onSearchTextChange(it) },
            modifier = Modifier
                .fillMaxWidth()
                .background(MaterialTheme.colorScheme.surface)
                .padding(Dimens.SpaceSmall)
        )
        IconButton(
            onClick = { /* Handle search icon click */ },
            modifier = Modifier.padding(start = Dimens.SpaceSmall)
        ) {
            Icon(
                imageVector = Icons.Outlined.Search,
                contentDescription = null,
                modifier = Modifier.size(Dimens.IconSize)
            )
        }
    }
}
