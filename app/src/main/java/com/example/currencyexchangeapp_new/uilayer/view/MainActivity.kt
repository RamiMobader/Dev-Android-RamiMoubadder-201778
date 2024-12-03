package com.example.currencyexchangeapp_new.uilayer.view

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.viewModels
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.currencyexchangeapp_new.data.CurrencyEntity
import com.example.currencyexchangeapp_new.uilayer.adapter.CurrencyAdapter
import com.example.currencyexchangeapp_new.ui.theme.CurrencyExchangeAppNewTheme
import com.example.currencyexchangeapp_new.viewmodel.CurrencyViewModel

class MainActivity : ComponentActivity() {
    private val currencyViewModel: CurrencyViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CurrencyExchangeAppNewTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    CurrencyListScreen(modifier = Modifier.padding(innerPadding), currencyViewModel)
                }
            }
        }
    }
}

@Composable
fun CurrencyListScreen(modifier: Modifier, currencyViewModel: CurrencyViewModel) {
    val currencies = currencyViewModel.currencyList.observeAsState(emptyList()).value


    AndroidView(
        modifier = modifier,
        factory = { context ->
            RecyclerView(context).apply {
                layoutManager = LinearLayoutManager(context)
                adapter = CurrencyAdapter(currencies)
            }
        }
    )
}
