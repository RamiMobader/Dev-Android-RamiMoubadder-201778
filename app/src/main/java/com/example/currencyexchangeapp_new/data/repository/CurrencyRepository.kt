package com.example.currencyexchangeapp_new.data

import androidx.lifecycle.LiveData
import com.example.currencyexchangeapp_new.network.CurrencyApiResponse
import com.example.currencyexchangeapp_new.network.CurrencyApiService
import retrofit2.Response

class CurrencyRepository(
    private val currencyDao: CurrencyDao,
    private val apiService: CurrencyApiService
) {


    fun getAllCurrenciesLive(): LiveData<List<CurrencyEntity>> {
        return currencyDao.getAllCurrencies()
    }

    // Function to fetch currency rates from the API and store them in the Room database
    suspend fun fetchCurrencyRatesFromApi() {
        // Make a network request to fetch exchange rates
        val response: Response<CurrencyApiResponse> = apiService.getExchangeRates()

        // Check if the response was successful
        if (response.isSuccessful) {
            val currencyApiResponse = response.body()


            currencyApiResponse?.rates?.let { rates ->

                currencyDao.clearAllCurrencies()


                rates.forEach { (currencyCode, exchangeRate) ->
                    val currencyEntity = CurrencyEntity(currencyName = currencyCode, exchangeRate = exchangeRate)
                    currencyDao.insert(currencyEntity) // Insert into Room
                }
            }
        }
    }
}
