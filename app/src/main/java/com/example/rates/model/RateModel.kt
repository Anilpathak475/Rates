package com.example.rates.model

/**
 *
 * @author Maxim on 2020-01-29
 */
data class RateModel(
    val base: String,
    val date: String,
    val rates: Map<String, Double>
)