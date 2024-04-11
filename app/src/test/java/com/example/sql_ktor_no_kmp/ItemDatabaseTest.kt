package com.example.sql_ktor_no_kmp

import com.squareup.sqldelight.sqlite.driver.JdbcSqliteDriver
import org.junit.Assert.assertEquals
import org.junit.Test

class ItemDatabaseTest {

    private val inMemorySqlDriver = JdbcSqliteDriver(JdbcSqliteDriver.IN_MEMORY).apply {
        Database.Schema.create(this)
    }

    private val queries = Database(inMemorySqlDriver).itemExampleQueries

    @Test
    fun smokeTest() {
        val emptyItems = queries.selectAll().executeAsList()
        assertEquals(emptyItems.size, 0)

        queries.insertOrReplace(
            label = "Pineapple",
            description = "Delicious exotic fruit",
            count = 5
        )

        val items = queries.selectAll().executeAsList()
        assertEquals(items.size, 1)

        val pineappleItem = queries.selectByLabel("Pineapple").executeAsOneOrNull()
        assertEquals(pineappleItem?.description, "Delicious exotic fruit")
        assertEquals(pineappleItem?.count?.toInt(), 5)
    }
}
