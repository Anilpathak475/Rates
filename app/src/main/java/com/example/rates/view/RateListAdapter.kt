package com.example.rates.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
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
class RateListAdapter(var currencies: ArrayList<Currency>) :
    RecyclerView.Adapter<RateListAdapter.RateViewHolder>() {

    fun updateRates(newCurrencies: List<Currency>) {
        if(newCurrencies.isNotEmpty()) {
            val diffUtilRes = DiffUtil.calculateDiff(RatesDiffUtilCallback(currencies, newCurrencies))
            currencies.clear()
            currencies.addAll(newCurrencies)
            diffUtilRes.dispatchUpdatesTo(this)
        } else {
            notifyDataSetChanged()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, p1: Int) = RateViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.rate_item, parent, false)
    )

    override fun getItemCount() = currencies.size
    override fun onBindViewHolder(holder: RateViewHolder, position: Int) {
        val currentCurrency = currencies[position]
        holder.bind(currentCurrency)

        holder.itemView.setOnClickListener {
            Collections.swap(currencies, 0, position)
            notifyDataSetChanged()
            CurrencyManager.updateBaseCurrency(it.context, currentCurrency.name)
        }
    }


    class RateViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val imageView = view.iv_country
        private val countryName = view.tv_country
        private val countryFullName = view.tv_country_fullname
        private val currencyRate = view.et_rate

        fun bind(currency: Currency) {
            val currencyEnum = currency.getFullNameAndDrawable()
            imageView.setImageResource(currencyEnum.drawableRes)
            countryName.text = currency.name
            countryFullName.text = currencyEnum.currencyName

            if (!currency.isBase) {
                currencyRate.setText(
                    String.format(
                        "%.4f",
                        currency.rate * CurrencyManager.currentRate
                    )
                )
            }
        }
    }

    fun getCurrentBase() = CurrencyManager.baseCurrency
}