package com.example.currencyexchangeapp_new.network

data class CurrencyApiResponse(
    val base: String,
    val date: String,
    val rates: Map<String, Double>
)
