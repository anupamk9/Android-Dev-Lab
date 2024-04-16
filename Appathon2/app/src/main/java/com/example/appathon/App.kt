package com.example.appathon

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Send
import androidx.compose.runtime.*
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.appathon.navigation.Navigation
//import com.example.appathon.screens.CommunityKitchenScreen
//import com.example.appathon.screens.DonationOptionsScreen
import com.example.appathon.screens.FoodListingsScreen
import com.example.appathon.screens.HomeScreen
//import com.example.appathon.screens.PickupDeliveryScreen
//import com.example.appathon.screens.RequestSystemScreen
import com.example.appathon.ui.theme.AppathonTheme

class App : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CommunityConnectApp()
        }
    }
}

@Composable
fun CommunityConnectApp() {
    val navController = rememberNavController()

    AppathonTheme {
        AppContent(navController)
    }
}

@Composable
@OptIn(ExperimentalMaterial3Api::class)
fun AppContent(navController: NavController) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Community Connect") },
                navigationIcon = {
                    IconButton(
                        onClick = {
                            navController.navigateUp()
                        }
                    ) {
                        Icon(imageVector = Icons.Default.Send, contentDescription = null)
                    }
                },
                actions = {
                    IconButton(
                        onClick = {
                            // Add actions if needed
                        }
                    ) {
                        Icon(imageVector = Icons.Default.Info, contentDescription = null)
                    }
                }
            )
        },
    ) { innerPadding ->
        Navigation(navController = navController, innerPadding = innerPadding)
    }
}


@Composable
fun Navigation(navController: NavController, innerPadding: PaddingValues) {
    NavHost(
        navController = navController as NavHostController,
        startDestination = Navigation.Home
    ) {
        composable(Navigation.Home) {
            HomeScreen(navController = navController)
        }
        composable(Navigation.FoodListings) {
            FoodListingsScreen(navController = navController)
        }
//        composable(Navigation.RequestSystem) {
//            RequestSystemScreen(navController = navController)
//        }
//        composable(Navigation.PickupDelivery) {
//            PickupDeliveryScreen(navController = navController)
//        }
//        composable(Navigation.CommunityKitchen) {
//            CommunityKitchenScreen(navController = navController)
//        }
//        composable(Navigation.DonationOptions) {
//            DonationOptionsScreen(navController = navController)
//        }
    }
}

enum class NavigationItems(val title: String, val icon: ImageVector) {
    Home("Home", Icons.Default.Home),
//    FoodListings("Food Listings", Icons.Default.Fastfood),
//    RequestSystem("Request System", Icons.Default.Send),
//    PickupDelivery("Pickup & Delivery", Icons.Default.LocalShipping),
//    CommunityKitchen("Community Kitchen", Icons.Default.Kitchen),
//    DonationOptions("Donation Options", Icons.Default.Favorite)
}
