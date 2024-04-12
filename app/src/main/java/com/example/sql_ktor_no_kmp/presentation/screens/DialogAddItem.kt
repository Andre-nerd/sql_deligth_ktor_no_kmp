package com.example.sql_ktor_no_kmp.presentation.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableLongStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.example.sql_ktor_no_kmp.presentation.ui.theme.modifierMainScreen
import com.example.sql_ktor_no_kmp.presentation.ui.theme.styleAnnotation
import sql.ItemExample

@Composable
fun DialogAddItem(
    onDismiss:()->Unit,
    onConfirm:(ItemExample)->Unit
){
    var label by remember { mutableStateOf("") }
    var description by remember { mutableStateOf("") }
    var count by remember { mutableLongStateOf(1L) }
    Dialog(onDismissRequest = onDismiss) {
        Card(
            modifier = modifierMainScreen.fillMaxWidth(),
            shape = RoundedCornerShape(16.dp)
        ){
            Column(modifier = Modifier.padding(16.dp)) {
                Text(text = "label:", style = styleAnnotation)
                TextField(value =label , onValueChange = {label = it})
                Text(text = "description:", style = styleAnnotation)
                TextField(value =description , onValueChange = {description = it})
                Text(text = "count:", style = styleAnnotation)
                TextField(value = count.toString() , onValueChange = {count = it.toLongOrNull() ?: 1})
                Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center){
                    TextButton(onClick = onDismiss) {
                        Text("Cancel")
                    }
                    TextButton(onClick = {
                        onConfirm.invoke(
                            ItemExample(
                                label = label,
                                description = description,
                                count = count
                            )
                        )
                    }) {
                        Text("Save")
                    }
                }
            }
        }
    }
}