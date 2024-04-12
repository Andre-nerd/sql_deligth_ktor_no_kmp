package com.example.sql_ktor_no_kmp.data

import android.content.Context
import com.example.sql_ktor_no_kmp.Database
import com.squareup.sqldelight.android.AndroidSqliteDriver
import com.squareup.sqldelight.db.SqlDriver

class DatabaseDriverFactory(private val applicationContext:Context) {
    fun createDriver(): SqlDriver{
        val androidSqlDriver = AndroidSqliteDriver(
            schema = Database.Schema,
            context = applicationContext,
            name = "items.db"
        )
        return androidSqlDriver
    }
    companion object{
        fun createDatabase(factory: DatabaseDriverFactory):Database{
            val driver = factory.createDriver()
            val queries = Database(driver)
            val items = queries.itemExampleQueries.selectAll().executeAsList()
            if(items.isEmpty()){
                queries.itemExampleQueries.insertOrReplace(
                    label = "Pineapple",
                    description = "Delicious exotic fruit",
                    count = 5
                )
                queries.itemExampleQueries.insertOrReplace(
                    label = "Carrot",
                    description = "Vegetable good for weight loss",
                    count = 20
                )
                queries.itemExampleQueries.insertOrReplace(
                    label = "Raspberries",
                    description = "Great choice for dessert",
                    count = 1
                )
            }
            return queries
        }
    }
}