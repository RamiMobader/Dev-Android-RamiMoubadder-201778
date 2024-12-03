package com.example.currencyexchangeapp_new.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.currencyexchangeapp_new.data.CurrencyEntity
import com.example.currencyexchangeapp_new.data.CurrencyRepository
import kotlinx.coroutines.launch

class CurrencyViewModel(private val currencyRepository: CurrencyRepository) : ViewModel() {

    private val _currencyList = MutableLiveData<List<CurrencyEntity>>()
    val currencyList: LiveData<List<CurrencyEntity>> get() = _currencyList

    init {
        fetchCurrencyRates()
    }

    private fun fetchCurrencyRates() {
        viewModelScope.launch {
            currencyRepository.fetchCurrencyRatesFromApi()
            _currencyList.value = currencyRepository.getAllCurrencies() // Fetch data from the local database
        }
    }
}
