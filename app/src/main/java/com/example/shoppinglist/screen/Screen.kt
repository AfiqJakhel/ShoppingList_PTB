package com.example.shoppinglist.screen

sealed class Screen(val route: String, val title: String) {
    object Home : Screen("home", "Shopping List")
    object Profile : Screen("profile", "Profile")
    object Setting : Screen("setting", "Settings")

    object DetailItem : Screen("detail_item/{itemName}", "Detail Item") {
        fun createRoute(itemName: String) = "detail_item/$itemName"
    }
}