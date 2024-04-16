package com.example.appathon.data.repository

import com.example.appathon.data.model.FoodListing


class FoodRepository {

    // Mock data for simplicity
    private val mockFoodListings = listOf(
        FoodListing("1", "Fresh Apples", "Organic apples from my garden", 5, "2024-03-15"),
        FoodListing("2", "Homemade Bread", "Freshly baked whole wheat bread", 2, "2024-03-10")
    )

    fun getFoodListings(): List<FoodListing> {
        // In a real app, you would fetch data from an API or database
        return mockFoodListings
    }
}