package com.example.rates.networking

import com.example.rates.model.RateModel
import retrofit2.http.GET
import retrofit2.http.Query

/**
 *
 * @author Maxim on 2020-01-29
 */
interface Api {
    @GET("/latest")
    suspend fun getRates(@Query("base") base: String): RateModel
}