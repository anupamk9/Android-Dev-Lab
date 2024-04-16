package com.example.appathon.network.api


import com.example.appathon.data.model.FoodListing
import retrofit2.http.GET

interface FoodApi {
    @GET("food/listings")
    suspend fun getFoodListings(): List<FoodListing>
}
