package com.example.currencyexchangeapp_new.uilayer.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.currencyexchangeapp_new.data.CurrencyEntity
import com.example.currencyexchangeapp_new.databinding.ItemCurrencyBinding

class CurrencyAdapter(private val currencies: List<CurrencyEntity>) : RecyclerView.Adapter<CurrencyAdapter.CurrencyViewHolder>() {

    // Define the ViewHolder
    inner class CurrencyViewHolder(private val binding: ItemCurrencyBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(currency: CurrencyEntity) {
            binding.currencyName.text = currency.currencyName
            binding.exchangeRate.text = currency.exchangeRate.toString()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CurrencyViewHolder {
        val binding = ItemCurrencyBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CurrencyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CurrencyViewHolder, position: Int) {
        val currency = currencies[position]
        holder.bind(currency)
    }

    override fun getItemCount(): Int {
        return currencies.size
    }
}
