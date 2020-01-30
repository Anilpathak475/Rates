package com.example.rates.networking

import com.example.rates.helper.CurrencyManager
import com.example.rates.model.Currency
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit


/**
 *
 * @author Maxim on 2020-01-29
 */
object RetrofitClient {
    private const val baseUrl = "https://revolut.duckdns.org/"
    val api: Api

    init {
        val loggingInterceptor = HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.HEADERS
            level = HttpLoggingInterceptor.Level.BODY
        }

        val httpBuilder = OkHttpClient().newBuilder()


        httpBuilder.apply {
            addInterceptor(loggingInterceptor)
            readTimeout(60, TimeUnit.SECONDS)
        }

        val retrofitBuilder = Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .client(httpBuilder.build())

        api = retrofitBuilder.build().create(Api::class.java)
    }

    suspend fun getRates(base: String = "EUR") {
        val response = api.getRates(base)
        CurrencyManager.baseCurrency = base

        response.rates.let {
            val listOfCurrencies = mutableListOf(Currency(base, 1.00, true))
            listOfCurrencies.addAll(response.rates.map { Currency(it.key, it.value, false) })
        }
    }
}