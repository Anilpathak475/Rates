package com.example.rates.view_model

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.rates.model.Currency
import com.example.rates.networking.RetrofitClient
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

/**
 *
 * @author Maxim on 2020-01-29
 */
class ViewModelMain : ViewModel() {

    val currencyList = MutableLiveData<MutableList<Currency>>()

    //create a coroutine context with the job and the dispatcher
    private val coroutineContext: CoroutineContext get() = Job() + Dispatchers.Default
    //create a coroutine scope with the coroutine context
    private val scope = CoroutineScope(coroutineContext)

//
//    val list =
//        liveData(Dispatchers.IO) {
//            val retrievedData = RetrofitClient.api.getRates("EUR")
//            retrievedData.rates.let {
//                val listOfCurrencies = mutableListOf(Currency(retrievedData.base, 1.00, true))
//                listOfCurrencies.addAll(retrievedData.rates.map {
//                    Currency(
//                        it.key,
//                        it.value,
//                        false
//                    )
//                })
//                emit(listOfCurrencies)
//            }
//        }

    fun updateCurrency(base: String = "EUR") {
        scope.launch {
            val newCurrencyRates = RetrofitClient.api.getRates(base)
            newCurrencyRates.rates.let {
                val listOfCurrencies =
                    mutableListOf(Currency(newCurrencyRates.base, 1.00, true))
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

    fun cancelRequests() = coroutineContext.cancel()
}