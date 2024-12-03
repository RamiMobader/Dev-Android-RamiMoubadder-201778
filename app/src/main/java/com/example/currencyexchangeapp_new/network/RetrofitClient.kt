package com.example.currencyexchangeapp_new.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {

    private const val BASE_URL = "https://v6.exchangerate-api.com/v6/7143720874c1d9c485718851/" // Base API URL

    val retrofitInstance: Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create()) // Use Gson to parse the JSON response
        .build()
}
