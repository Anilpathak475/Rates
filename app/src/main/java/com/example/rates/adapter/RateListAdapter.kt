package com.example.rates.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.doAfterTextChanged
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.rates.R
import com.example.rates.extensions.getFullNameAndDrawable
import com.example.rates.helper.CurrencyManager
import com.example.rates.helper.RatesDiffUtilCallback
import com.example.rates.model.Currency
import kotlinx.android.synthetic.main.rate_item.view.*
import java.util.*


/**
 *
 * @author Maxim on 2020-01-29
 */
class RateListAdapter(private val currencies: ArrayList<Currency>) :
    RecyclerView.Adapter<RateListAdapter.RateViewHolder>() {

    private var blockUpdating: Boolean = false

    fun updateRates(newCurrencies: List<Currency>) {
        if (newCurrencies.isNotEmpty() && !blockUpdating) {
            val diffUtilRes =
                DiffUtil.calculateDiff(RatesDiffUtilCallback(currencies, newCurrencies))
            currencies.clear()
            currencies.addAll(newCurrencies)
            diffUtilRes.dispatchUpdatesTo(this)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, p1: Int) = RateViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.rate_item, parent, false)
    )

    override fun getItemCount() = currencies.size
    override fun onBindViewHolder(holder: RateViewHolder, position: Int) {
        val currentCurrency = currencies[position]

        holder.itemView.apply {
            setOnClickListener {
                if (position != 0) {
                    blockUpdating = true
                    Collections.swap(currencies, 0, position)
                    updateCurrency(currentCurrency.name, currentCurrency.rate)
                    notifyDataSetChanged()
                    blockUpdating = false
                }
            }
        }.let { rootView ->
            val currencyEnum = currentCurrency.getFullNameAndDrawable()
            rootView.iv_country.setImageResource(currencyEnum.drawableRes)
            rootView.tv_country.text = currentCurrency.name
            rootView.tv_country_fullname.text = currencyEnum.currencyName

            rootView.et_rate.apply {
                CurrencyManager.currentRate?.let { amount ->
                    text.replace(
                        0, this.text.length,
                        when (currentCurrency.isBase) {
                            true -> currentCurrency.rate.toString()
                            else -> String.format(
                                "%.4f",
                                currentCurrency.rate * amount
                            )
                        }
                    )
                }

                setOnFocusChangeListener { v, isFocused ->
                    if (isFocused && holder.adapterPosition != 0) {
                        rootView.performClick()
                    }
                }

                doAfterTextChanged { text ->
                    val stringAmount = text.toString()
                    if (holder.adapterPosition == 0 && CurrencyManager.currentRate != stringAmount.toDoubleOrNull()) {
                        CurrencyManager.currentRate = stringAmount.toDoubleOrNull()
                    }
                }
            }
        }
    }

    private fun updateCurrency(newBase: String, newAmount: Double) {
        CurrencyManager.baseCurrency = newBase
        CurrencyManager.currentRate = newAmount
    }


    class RateViewHolder(view: View) : RecyclerView.ViewHolder(view)

    fun getCurrentBase() = CurrencyManager.baseCurrency
}