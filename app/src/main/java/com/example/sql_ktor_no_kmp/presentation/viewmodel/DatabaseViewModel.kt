package com.example.sql_ktor_no_kmp.presentation.viewmodel

import androidx.compose.foundation.text.selection.DisableSelection
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.sql_ktor_no_kmp.data.database.DatabaseDriverFactory
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import sql.ItemExample

class DatabaseViewModel(databaseDriverFactory: DatabaseDriverFactory) : ViewModel() {
    private val queries = DatabaseDriverFactory.initDatabase(databaseDriverFactory)
    private val _items = MutableStateFlow<List<ItemExample>>(emptyList())
    val items: StateFlow<List<ItemExample>>
        get() = _items

    init {
        getAll()
    }

    private fun getAll() {
        viewModelScope.launch(Dispatchers.IO) {
            _items.value = queries.itemExampleQueries.selectAll().executeAsList()
        }
    }
    fun delete(item:ItemExample){
        viewModelScope.launch(Dispatchers.IO) {
            queries.itemExampleQueries.deleteByLabel(item.label)
            getAll()
        }
    }
    fun insert(item:ItemExample){
        viewModelScope.launch(Dispatchers.IO) {
            queries.itemExampleQueries.insertOrReplace(item.label, item.description, count = 1)
            getAll()
        }
    }
}