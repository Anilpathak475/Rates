package com.example.rates.helper

import android.content.Context
import androidx.preference.PreferenceManager

/**
 *
 * @author Maxim on 2020-01-30
 */
object CurrencyManager {
    var baseCurrency: String? = null

    var currentRate: Double = 1.0

    fun updateBaseCurrency(context: Context, currencyShortName: String) {
        PreferenceManager.getDefaultSharedPreferences(context).edit()
            .putString("base", currencyShortName).apply()
        baseCurrency = currencyShortName
    }
}