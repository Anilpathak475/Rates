package com.example.rates.model

import com.example.rates.R

/**
 *
 * @author Maxim on 2020-01-30
 */
enum class CurrencyEnum(val drawableRes: Int, val currencyName: String) {
    EUR(R.drawable.ic_eu, "Euro"),
    CAD(R.drawable.ic_canada, "Canadian Dollar"),
    USD(R.drawable.ic_us, "US Dollar"),
    SEK(R.drawable.ic_sweden, "Swedish Krona"),
    AUD(R.drawable.ic_default_flag, "Australian Dollar"),
    BGN(R.drawable.ic_default_flag, "Bulgarian Lev"),
    BRL(R.drawable.ic_default_flag, "Brazilian Real"),
    CHF(R.drawable.ic_default_flag, "Swiss Franc"),
    CNY(R.drawable.ic_default_flag, "Renminbi (Yuan)"),
    CZK(R.drawable.ic_default_flag, "Czech Koruna"),
    DKK(R.drawable.ic_default_flag, "Danish Kroner"),
    GBP(R.drawable.ic_default_flag, "Pound Sterling"),
    HKD(R.drawable.ic_default_flag, "Hong Kong Dollar"),
    HRK(R.drawable.ic_default_flag, "Croatian Kuna"),
    HUF(R.drawable.ic_default_flag, "Forint"),
    IDR(R.drawable.ic_default_flag, "Rupiah"),
    ILS(R.drawable.ic_default_flag, "New Israeli Sheqel"),
    INR(R.drawable.ic_default_flag, "Indian Rupee"),
    ISK(R.drawable.ic_default_flag, "Iceland Krona"),
    JPY(R.drawable.ic_default_flag, "Yen"),
    KRW(R.drawable.ic_default_flag, "Won"),
    MXN(R.drawable.ic_default_flag, "Mexican Peso"),
    MYR(R.drawable.ic_default_flag, "Malaysian Ringgit"),
    NOK(R.drawable.ic_default_flag, "Norwegian Krone"),
    NZD(R.drawable.ic_default_flag, "New Zealand Dollar"),
    PHP(R.drawable.ic_default_flag, "Philippine Peso"),
    PLN(R.drawable.ic_default_flag, "Polish Zloty"),
    RON(R.drawable.ic_default_flag, "Leu"),
    RUB(R.drawable.ic_default_flag, "Russian Ruble"),
    SGD(R.drawable.ic_default_flag, "Singapore Dollar"),
    THB(R.drawable.ic_default_flag, "Thai Baht"),
    TRY(R.drawable.ic_default_flag, "Turkey Lira"),
    ZAR(R.drawable.ic_default_flag, "South African Rand");
}