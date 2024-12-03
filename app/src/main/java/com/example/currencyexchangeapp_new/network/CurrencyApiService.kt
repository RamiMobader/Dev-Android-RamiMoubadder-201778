package com.example.currencyexchangeapp_new.network

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface CurrencyApiService {

    @GET("latest/USD")
    suspend fun getExchangeRates(
        @Query("apikey") apiKey: String = "7143720874c1d9c485718851"
    ): Response<CurrencyApiResponse>
}
