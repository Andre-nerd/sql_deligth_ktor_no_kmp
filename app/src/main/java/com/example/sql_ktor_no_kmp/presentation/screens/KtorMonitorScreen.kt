package com.example.sql_ktor_no_kmp.presentation.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.sql_ktor_no_kmp.domain.State
import com.example.sql_ktor_no_kmp.presentation.ui.theme.styleTitle
import com.example.sql_ktor_no_kmp.presentation.viewmodel.ApiViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun KtorMonitorScreen(apiViewModel: ApiViewModel = koinViewModel()){
    val state = apiViewModel.state.collectAsState()
    Column(modifier = Modifier
        .fillMaxWidth()
        .padding(top = 38.dp), horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = "KtorMonitorScreen")
        Spacer(modifier = Modifier.size(38.dp))
        Text(text = "Ktor Recommends activity", style  = styleTitle)
        Spacer(modifier = Modifier.size(16.dp))
        Text(text = state.value.message)
        Button(onClick = { apiViewModel.getUserActivity() }) {
            Text(text = "Refresh")
        }
        Spacer(modifier = Modifier.size(16.dp))
        if(state.value is State.Loading){
            CircularProgressIndicator(
                modifier = Modifier.width(64.dp),
                color = MaterialTheme.colorScheme.secondary
            )
        }
    }
}