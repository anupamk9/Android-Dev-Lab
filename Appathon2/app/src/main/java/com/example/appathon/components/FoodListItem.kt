// ui/components/FoodListItem.kt
package com.example.appathon.components

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.appathon.data.model.FoodListing
import com.example.appathon.ui.theme.Dimens


@Composable
fun FoodListItem(foodListing: FoodListing, onItemClick: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(Dimens.SpaceMedium)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(Dimens.SpaceMedium)
        ) {
            Text(text = foodListing.title)
            Text(text = foodListing.description)
            Text(text = "Quantity: ${foodListing.quantity}")
            Text(text = "Expires on: ${foodListing.expirationDate}")
        }
    }
}
