package com.example.sql_ktor_no_kmp.presentation.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.ExposurePlus1
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.sql_ktor_no_kmp.presentation.ui.theme.modifierMainScreen
import com.example.sql_ktor_no_kmp.presentation.ui.theme.styleDescription
import com.example.sql_ktor_no_kmp.presentation.ui.theme.styleTitle
import com.example.sql_ktor_no_kmp.presentation.viewmodel.DatabaseViewModel
import org.koin.androidx.compose.koinViewModel
import sql.ItemExample


@Composable
fun DatabaseMonitorScreen(dbViewModel: DatabaseViewModel = koinViewModel()) {

    val goods = dbViewModel.items.collectAsState()
    var openDialogAddItem by remember { mutableStateOf(false) }

    Column(modifier = Modifier.padding(bottom = 132.dp), horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = "DatabaseMonitorScreen")
        Spacer(modifier = Modifier.size(16.dp))
        LazyColumn {
            items(goods.value) {
                CardItem(it) {
                    dbViewModel.delete(it)
                }
            }
        }
    }
    if (openDialogAddItem) DialogAddItem(onDismiss = { openDialogAddItem = !openDialogAddItem }) {
        openDialogAddItem = !openDialogAddItem
        dbViewModel.insert(it)
    }
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(bottom = 132.dp),
        contentAlignment = Alignment.BottomCenter
    ) {
        Button(onClick = { openDialogAddItem = !openDialogAddItem }) {
            Icon(imageVector = Icons.Default.ExposurePlus1, contentDescription = "Plus")
        }
    }
}

@Composable
fun CardItem(item: ItemExample, delete: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 8.dp),
        shape = RoundedCornerShape(16.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(modifier = modifierMainScreen) {
                Text(text = item.label, style = styleTitle)
                Text(text = item.description, style = styleDescription)
                Text(text = "count: ${item.count}", style = styleDescription)
            }
            IconButton(onClick = { delete.invoke() }) {
                Icon(imageVector = Icons.Default.Delete, contentDescription = "Delete")
            }
        }
    }
}