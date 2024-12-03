package com.example.currencyexchangeapp_new.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.lifecycle.LiveData

@Dao
interface CurrencyDao {

    @Insert
    suspend fun insert(currency: CurrencyEntity)

    @Query("SELECT * FROM currency")
    fun getAllCurrencies(): LiveData<List<CurrencyEntity>>  // LiveData to observe the data changes
}
