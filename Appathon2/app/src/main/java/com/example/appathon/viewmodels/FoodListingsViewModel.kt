// ui/viewmodels/FoodListingsViewModel.kt
package com.example.appathon.viewmodels

import androidx.lifecycle.ViewModel
import com.example.appathon.data.model.FoodListing
import com.example.appathon.data.repository.FoodRepository

class FoodListingsViewModel(private val foodRepository: FoodRepository) : ViewModel() {

    val foodListings: List<FoodListing> by lazy {
        foodRepository.getFoodListings()
    }

    fun getFilteredFoodListings(query: String): List<FoodListing> {
        // Implement your logic to filter food listings based on the search query
        return foodListings.filter { it.title.contains(query, ignoreCase = true) }
    }
}
