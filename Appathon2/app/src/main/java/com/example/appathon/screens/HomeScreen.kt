package com.example.appathon.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Send
import androidx.compose.material3.*

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.appathon.ui.theme.AppathonTheme
import com.example.appathon.ui.theme.ContentPadding
import com.example.appathon.ui.theme.Dimens

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavController) {
    AppathonTheme {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = { Text("Community Connect") },
                    navigationIcon = {
                        IconButton(
                            onClick = { /* Handle navigation icon click */ }
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
                            onClick = { /* Handle info icon click */ }
                        ) {
                            Icon(
                                imageVector = Icons.Default.Send,
                                contentDescription = null,
                                modifier = Modifier.size(Dimens.IconSize)
                            )
                        }
                    }
                )
            }
        ) {
            // Your HomeScreen UI code goes here
            Column(
                modifier = Modifier
                    .padding(ContentPadding)
            ) {
                Button(
                    onClick = { navController.navigate("foodListings") },
                    modifier = Modifier.padding(Dimens.SpaceMedium)
                ) {
                    Text("View Food Listings")
                }
            }
        }
    }
}
