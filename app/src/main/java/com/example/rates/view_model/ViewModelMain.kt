package com.example.rates.view_model

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.rates.model.Currency
import com.example.rates.networking.RetrofitClient
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

/**
 *
 * @author Maxim on 2020-01-29
 */
class ViewModelMain : ViewModel() {

    val currencyList = MutableLiveData<MutableList<Currency>>()
    private val coroutineContext: CoroutineContext get() = Job() + Dispatchers.Default
    private val scope = CoroutineScope(coroutineContext)

    fun getNewRates(base: String = "EUR") {
        scope.launch {
            val newCurrencyRates = RetrofitClient.api.getRates(base)
            newCurrencyRates.rates.let {
                val listOfCurrencies = mutableListOf(Currency(newCurrencyRates.base, 100.0, true))
                listOfCurrencies.addAll(newCurrencyRates.rates.map {
                    Currency(
                        it.key,
                        it.value,
                        false
                    )
                })
                currencyList.postValue(listOfCurrencies)
            }
        }
    }
}