package com.example.rates.helper

import androidx.recyclerview.widget.DiffUtil
import com.example.rates.model.Currency

/**
 *
 * @author Maxim on 2020-01-30
 */
class RatesDiffUtilCallback(
    private val oldCurrencies: List<Currency>,
    private val newCurrencies: List<Currency>
) : DiffUtil.Callback() {

    override fun getOldListSize() = oldCurrencies.size

    override fun getNewListSize() = newCurrencies.size

    override fun areItemsTheSame(oldPos: Int, newPos: Int) =
        oldCurrencies[oldPos].name == newCurrencies[newPos].name

    override fun areContentsTheSame(oldPos: Int, newPos: Int) =
        oldCurrencies[oldPos] == newCurrencies[newPos]
}