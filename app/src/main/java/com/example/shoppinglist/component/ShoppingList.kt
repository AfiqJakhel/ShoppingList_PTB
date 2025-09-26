package com.example.shoppinglist.component

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.dp

@Composable
fun ShoppingList(items: List<String>) {
    Column {
        items.forEach { item ->
            AnimatedVisibility(visible = true) {
                ShoppingListItem(itemName = item)
            }
            Spacer(modifier = Modifier.height(8.dp))
        }
    }
}


@Composable
fun ShoppingListItem(itemName: String) {
    var clicked by remember { mutableStateOf(false) }

    val backgroundColor by animateColorAsState(
        targetValue = if (clicked) {
            MaterialTheme.colorScheme.secondaryContainer
        } else {
            MaterialTheme.colorScheme.surface
        },
        label = "cardColor"
    )

    val elevation by animateDpAsState(
        targetValue = if (clicked) 8.dp else 2.dp,
        label = "cardElevation"
    )

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { clicked = !clicked },
        elevation = CardDefaults.cardElevation(
            defaultElevation = if (clicked) 8.dp else 2.dp
        ),
        colors = CardDefaults.cardColors(
            containerColor = if (clicked) MaterialTheme.colorScheme.secondaryContainer
            else MaterialTheme.colorScheme.surface
        )
    ) {
        Row(
            modifier = Modifier.padding(16.dp),
            horizontalArrangement = Arrangement.Start
        ) {
            Icon(
                imageVector = Icons.Default.ShoppingCart,
                contentDescription = null,
                tint = MaterialTheme.colorScheme.primary
            )
            Spacer(modifier = Modifier.width(12.dp))
            Text(
                text = itemName,
                style = MaterialTheme.typography.bodyLarge
            )
        }
    }
}