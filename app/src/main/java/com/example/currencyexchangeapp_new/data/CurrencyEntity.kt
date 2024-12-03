package com.example.currencyexchangeapp_new.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "currency")
data class CurrencyEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val currencyName: String,
    val exchangeRate: Double
)
