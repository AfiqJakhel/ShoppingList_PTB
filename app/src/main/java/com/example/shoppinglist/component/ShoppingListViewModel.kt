package com.example.shoppinglist.component

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel

class ShoppingListViewModel : ViewModel() {
    var items = mutableStateListOf<String>()
        private set

    fun addItem(name: String) {
        items.add(name)
    }

    fun deleteItem(name: String) {
        items.remove(name)
    }
}